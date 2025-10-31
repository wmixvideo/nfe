package com.fincatto.documentofiscal.nfse.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfse.NFSeConfig;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.*;
import com.fincatto.documentofiscal.nfse.utils.NFSeDPSUtils;
import com.fincatto.documentofiscal.nfse.utils.NFSeEventoUtils;
import com.fincatto.documentofiscal.nfse.utils.NFSeHttpClient;
import com.fincatto.documentofiscal.nfse.utils.NFSeObjectMapper;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class WSSefinNFSe implements DFLog {

    // todo: adicionar URL de produção quando liberar
    //    public static final String URL_BASE_SEFINNACIONAL = "https://sefin.nfse.gov.br/sefinnacional";
    public static final String URL_BASE_HOMOLOGACAO_SEFINNACIONAL = "https://sefin.producaorestrita.nfse.gov.br/sefinnacional";
    public static final String URL_HOMOLOGACAO_NFSE = URL_BASE_HOMOLOGACAO_SEFINNACIONAL + "/nfse";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeConfig config;


    public WSSefinNFSe(final NFSeConfig config) {
        this.config = config;
//        this.client = ;
    }

    /**
     * Consulta NFSe pela chave de acesso
     * @param nfseChaveAcesso
     * @return objeto de resposta da consulta
     * @throws Exception
     */
    public NFSeSefinNacionalGetResponse getNFSeByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        final var urlHomologacao = new URI(String.format("%s/%s", URL_HOMOLOGACAO_NFSE, nfseChaveAcesso));
        final var response = new NFSeHttpClient(config).sendGetRequest(urlHomologacao);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalGetResponse.class);
    }

    /**
     * Emite NFSe a partir do DPS
     */
    public NFSeSefinNacionalPostResponseSucesso emitirNFSeByDPS(final NFSeSefinNacionalDPS dps) throws Exception {
        // Gera o id e seta no objeto para preenchimento no xml
        dps.getInfDPS().setId(NFSeDPSUtils.gerarId(dps));

        byte[] gzipped;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             java.util.zip.GZIPOutputStream gos = new java.util.zip.GZIPOutputStream(baos)) {
            gos.write(new DFAssinaturaDigital(this.config).setOmitirDeclaracaoXML(false).setUsarIdComoReferencia(false).assinarDocumento(dps.toXml()).getBytes(StandardCharsets.UTF_8));
            gos.finish();
            gzipped = baos.toByteArray();
        };

        final var response = new NFSeHttpClient(config).sendPostRequest(new URI(String.format("%s", URL_HOMOLOGACAO_NFSE)), String.format("{dpsXmlGZipB64:\"%s\"}", Base64.getEncoder().encodeToString(gzipped)));
        if (response.statusCode() != 201) {
            final var responseError = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseErro.class);
            throw new IllegalStateException(String.format("Erro ao enviar DPS. Erros: %s", responseError.getErros()));
        }

        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseSucesso.class);
    }

    /**
     * Emite um evento de cancelamento para uma NFSe
     */
    public NFSeSefinNacionalPostResponseSucesso enviarPedidoRegistroEvento(final NFSeSefinNacionalPedRegEvt pedidoRegistroEvento) throws Exception {
        // Gera o id e seta no objeto para preenchimento no xml
        pedidoRegistroEvento.getInfPedReg().setId(NFSeEventoUtils.gerarId(pedidoRegistroEvento));

        byte[] gzipped;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             java.util.zip.GZIPOutputStream gos = new java.util.zip.GZIPOutputStream(baos)) {
            gos.write(new DFAssinaturaDigital(this.config).setOmitirDeclaracaoXML(false).setUsarIdComoReferencia(false).assinarDocumento(pedidoRegistroEvento.toXml(), "infPedReg").getBytes(StandardCharsets.UTF_8));
            gos.finish();
            gzipped = baos.toByteArray();
        }

        final var urlHomologacao = new URI(String.format("%s/%s/eventos", URL_HOMOLOGACAO_NFSE, pedidoRegistroEvento.getInfPedReg().getChaveAcessoNFSE()));
        final var response = new NFSeHttpClient(config).sendPostRequest(urlHomologacao, String.format("{pedidoRegistroEventoXmlGZipB64:\"%s\"}", Base64.getEncoder().encodeToString(gzipped)));

        if (response.statusCode() != 201) {
            final var responseError = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseErro.class);
            throw new IllegalStateException(String.format("Erro ao enviar pedido de registro de evento. Erros: %s", responseError.getErros()));
        }

        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseSucesso.class);
    }
}

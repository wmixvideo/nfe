package com.fincatto.documentofiscal.nfse.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.nfse.NFSeConfig;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalGetResponse;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalPostResponseErro;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalPostResponseSucesso;
import com.fincatto.documentofiscal.nfse.utils.NFSeHttpClient;
import com.fincatto.documentofiscal.nfse.utils.NFSeObjectMapper;

import java.net.URI;

public class WSSefinNFSe implements DFLog {

    public static final String URL_BASE_HOMOLOGACAO_SEFINNACIONAL = "https://sefin.producaorestrita.nfse.gov.br/sefinnacional";
    public static final String URL_BASE_HOMOLOGACAO_NFSE = URL_BASE_HOMOLOGACAO_SEFINNACIONAL + "/nfse";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeHttpClient client;


    public WSSefinNFSe(final NFSeConfig config) {
        this.client = new NFSeHttpClient(config);
    }

    /**
     * Consulta NFSe pela chave de acesso
     * @param nfseChaveAcesso
     * @return objeto de resposta da consulta
     * @throws Exception
     */
    public NFSeSefinNacionalGetResponse getNFSeByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        final var urlHomologacao = new URI(String.format("%s/%s", URL_BASE_HOMOLOGACAO_NFSE, nfseChaveAcesso));
        final var response = client.sendGetRequest(urlHomologacao);
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalGetResponse.class);
    }

    /**
     * Emite NFSe a partir do DPS
     * @param dps
     * @return objeto de resposta da emissão
     * @throws Exception
     */
    public NFSeSefinNacionalPostResponseSucesso emitirNFSeByDPS(final String dps) throws Exception {
        final var urlHomologacao = new URI(String.format("%s", URL_BASE_HOMOLOGACAO_NFSE));
        final var response = client.sendPostRequest(urlHomologacao, String.format("{dpsXmlGZipB64:\"%s\"}", dps));

        if (response.statusCode() != 201) {
            final var responseError = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseErro.class);
            throw new IllegalStateException(String.format("Erro ao emitir NFSe. Erros: %s", responseError.getErros()));
        }

        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseSucesso.class);
    }


}

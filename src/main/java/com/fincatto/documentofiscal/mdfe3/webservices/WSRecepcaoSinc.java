package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.nota.MDFe;
import com.fincatto.documentofiscal.mdfe3.classes.nota.envio.MDFEnvioRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.nota.envio.MDFEnvioRetornoDados;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

class WSRecepcaoSinc implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRecepcaoSinc";
    private static final String SOAP_ACTION = WSRecepcaoSinc.NAMESPACE_WSDL + "/mdfeRecepcao";

    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSRecepcaoSinc(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    public MDFEnvioRetornoDados envioRecepcaoSinc(MDFe mdfeRecepcao) throws Exception {
        //assina o mdfe
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(mdfeRecepcao.toString(), "infMDFe");
        final MDFe mdfeAssinado = this.config.getPersister().read(MDFe.class, documentoAssinado);

        //comunica o mdfe
        final MDFEnvioRetorno retorno = comunicaSinc(documentoAssinado);
        return new MDFEnvioRetornoDados(retorno, mdfeAssinado);
    }

    public MDFEnvioRetornoDados envioRecepcaoSincAssinado(final String mdfeEnvioXmlAssinado) throws Exception {
        final MDFe mdfeAssinado = this.config.getPersister().read(MDFe.class, mdfeEnvioXmlAssinado);

        //comunica o mdfe
        final MDFEnvioRetorno retorno = comunicaSinc(mdfeEnvioXmlAssinado);
        return new MDFEnvioRetornoDados(retorno, mdfeAssinado);
    }

    private MDFEnvioRetorno comunicaSinc(final String mdfeAssinadoXml) throws Exception {
        //valida o mdfe assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaMDFe(mdfeAssinadoXml);

        String mdfeAssinadoXmlGZip = encodeXmlToGZip(mdfeAssinadoXml);

        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeRecepcaoSinc(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao do MDFe, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSRecepcaoSinc.NAMESPACE_WSDL, "mdfeDadosMsg", mdfeAssinadoXmlGZip);
        final String resposta = this.httpClient.postSoap(endpoint, WSRecepcaoSinc.SOAP_ACTION, envelope);
        final String xmlResultado = DFSoapEnvelope.desempacotar(resposta);
        final MDFEnvioRetorno retorno = this.config.getPersister().read(MDFEnvioRetorno.class, xmlResultado);
        this.getLogger().debug(retorno.toString());
        return retorno;
    }

    private static String encodeXmlToGZip(final String stringXml) throws Exception {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
             try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
                 gzipOutputStream.write(stringXml.getBytes(StandardCharsets.UTF_8));
             }
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }
    }
}

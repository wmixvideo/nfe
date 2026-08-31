package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTAutorizador400;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeEnvioRetornoDados;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeEnvioRetorno;
import com.fincatto.documentofiscal.cte400.classes.nota.CTeNota;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

class WSRecepcaoCTe implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoSincV4";
    private static final String SOAP_ACTION = WSRecepcaoCTe.NAMESPACE_WSDL + "/cteRecepcao";

    private final CTeConfig config;
    private final DFHttpClient httpClient;

    WSRecepcaoCTe(final CTeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    public CTeEnvioRetornoDados enviaCTe(CTeNota cte) throws Exception {
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cte.toString(), "infCte");
        final CTeNota cteAssinado = this.config.getPersister().read(CTeNota.class, documentoAssinado);

        final CTeEnvioRetorno retorno = comunicaLote(documentoAssinado);
        return new CTeEnvioRetornoDados(retorno, cteAssinado);
    }

    private CTeEnvioRetorno comunicaLote(final String cteAssinadoXml) throws Exception {
        DFXMLValidador.validaNotaCte400(cteAssinadoXml);

        String conteudoCompactado;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
             try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
                 gzipOutputStream.write(cteAssinadoXml.getBytes(StandardCharsets.UTF_8));
             }
            conteudoCompactado = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }

        final CTAutorizador400 autorizador = CTAutorizador400.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = autorizador.getCteRecepcaoSinc(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSRecepcaoCTe.NAMESPACE_WSDL, "cteDadosMsg", conteudoCompactado);
        final String resposta = this.httpClient.postSoap(endpoint, WSRecepcaoCTe.SOAP_ACTION, envelope);
        final String xmlResultado = DFSoapEnvelope.desempacotar(resposta);
        final CTeEnvioRetorno retorno = this.config.getPersister().read(CTeEnvioRetorno.class, xmlResultado);
        this.getLogger().debug(retorno.toString());
        return retorno;
    }
}

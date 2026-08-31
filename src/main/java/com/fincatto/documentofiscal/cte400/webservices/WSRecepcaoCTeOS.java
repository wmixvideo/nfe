package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTAutorizador400;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeOSEnvioRetorno;
import com.fincatto.documentofiscal.cte400.classes.envio.CTeOSEnvioRetornoDados;
import com.fincatto.documentofiscal.cte400.classes.os.CTeOS;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

class WSRecepcaoCTeOS implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4";
    private static final String SOAP_ACTION = WSRecepcaoCTeOS.NAMESPACE_WSDL + "/cteRecepcaoOS";

    private final CTeConfig config;
    private final DFHttpClient httpClient;

    WSRecepcaoCTeOS(final CTeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    public CTeOSEnvioRetornoDados enviaCTe(CTeOS cteOS) throws Exception {
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cteOS.toString(), "infCte");
        final CTeOS cteAssinado = this.config.getPersister().read(CTeOS.class, documentoAssinado);

        final CTeOSEnvioRetorno retorno = comunicaLote(documentoAssinado);
        return new CTeOSEnvioRetornoDados(retorno, cteAssinado);
    }

    private CTeOSEnvioRetorno comunicaLote(final String cteAssinadoXml) throws Exception {
        DFXMLValidador.validaNotaCTeOS400(cteAssinadoXml);

        String conteudoCompactado;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
             try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
                 gzipOutputStream.write(cteAssinadoXml.getBytes(StandardCharsets.UTF_8));
             }
            conteudoCompactado = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }

        final CTAutorizador400 autorizador = CTAutorizador400.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = autorizador.getCteRecepcaoOS(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao OS, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSRecepcaoCTeOS.NAMESPACE_WSDL, "cteDadosMsg", conteudoCompactado);
        final String resposta = this.httpClient.postSoap(endpoint, WSRecepcaoCTeOS.SOAP_ACTION, envelope);
        final String xmlResultado = DFSoapEnvelope.desempacotar(resposta);
        final CTeOSEnvioRetorno retorno = this.config.getPersister().read(CTeOSEnvioRetorno.class, xmlResultado);
        this.getLogger().debug(retorno.toString());
        return retorno;
    }
}

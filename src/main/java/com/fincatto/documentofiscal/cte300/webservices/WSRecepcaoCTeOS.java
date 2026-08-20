package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.envio.CTeOSEnvioRetorno;
import com.fincatto.documentofiscal.cte300.classes.envio.CTeOSEnvioRetornoDados;
import com.fincatto.documentofiscal.cte300.classes.os.CTeOS;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

class WSRecepcaoCTeOS implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS";
    private static final String SOAP_ACTION = WSRecepcaoCTeOS.NAMESPACE_WSDL + "/cteRecepcaoOS";

    private final CTeConfig config;
    private final DFHttpClient httpClient;

    WSRecepcaoCTeOS(final CTeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    public CTeOSEnvioRetornoDados envioRecepcao(CTeOS cteOS) throws Exception {
        //assina o lote
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cteOS.toString(), "infCte");
        final CTeOS loteAssinado = this.config.getPersister().read(CTeOS.class, documentoAssinado);

        //comunica o lote
        final CTeOSEnvioRetorno retorno = comunicaLote(documentoAssinado);
        return new CTeOSEnvioRetornoDados(retorno, loteAssinado);
    }

    private CTeOSEnvioRetorno comunicaLote(final String loteAssinadoXml) throws Exception {
        DFXMLValidador.validaCTeOS300(loteAssinadoXml);

        final String cabecalho = this.getCabecalhoSOAP();
        this.getLogger().debug(loteAssinadoXml);

        final CTAutorizador31 autorizador = CTAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = autorizador.getCteRecepcaoOS(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao OS, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        final String envelope = DFSoapEnvelope.envelopar(WSRecepcaoCTeOS.NAMESPACE_WSDL, "cteCabecMsg", cabecalho, "cteDadosMsg", loteAssinadoXml);
        final String resposta = this.httpClient.postSoap(endpoint, WSRecepcaoCTeOS.SOAP_ACTION, envelope);
        final String xmlResultado = DFSoapEnvelope.desempacotar(resposta);
        final CTeOSEnvioRetorno retorno = this.config.getPersister().read(CTeOSEnvioRetorno.class, xmlResultado);
        this.getLogger().debug(retorno.toString());
        return retorno;
    }

    private String getCabecalhoSOAP() {
        return "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>3.00</versaoDados>";
    }
}

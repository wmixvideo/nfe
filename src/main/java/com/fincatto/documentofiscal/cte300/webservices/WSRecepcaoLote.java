package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLote;
import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLoteRetorno;
import com.fincatto.documentofiscal.cte300.classes.enviolote.CTeEnvioLoteRetornoDados;
import com.fincatto.documentofiscal.utils.DFAssinaturaDigital;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;

class WSRecepcaoLote implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao";
    private static final String SOAP_ACTION = WSRecepcaoLote.NAMESPACE_WSDL + "/cteRecepcaoLote";

    private final CTeConfig config;
    private final DFHttpClient httpClient;

    WSRecepcaoLote(final CTeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    public CTeEnvioLoteRetornoDados envioRecepcao(CTeEnvioLote cteRecepcaoLote) throws Exception {
        //assina o lote
        final String documentoAssinado = new DFAssinaturaDigital(this.config).assinarDocumento(cteRecepcaoLote.toString(), "infCte");
        final CTeEnvioLote loteAssinado = this.config.getPersister().read(CTeEnvioLote.class, documentoAssinado);

        //comunica o lote
        final CTeEnvioLoteRetorno retorno = comunicaLote(documentoAssinado);
        return new CTeEnvioLoteRetornoDados(retorno, loteAssinado);
    }

    private CTeEnvioLoteRetorno comunicaLote(final String loteAssinadoXml) throws Exception {
        //valida o lote assinado, para verificar se o xsd foi satisfeito, antes de comunicar com a sefaz
        DFXMLValidador.validaLoteCTe300(loteAssinadoXml);

        final String cabecalho = this.getCabecalhoSOAP();
        this.getLogger().debug(loteAssinadoXml);

        final CTAutorizador31 autorizador = CTAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = autorizador.getCteRecepcao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Recepcao, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSRecepcaoLote.NAMESPACE_WSDL, "cteCabecMsg", cabecalho, "cteDadosMsg", loteAssinadoXml);
        final String resposta = this.httpClient.postSoap(endpoint, WSRecepcaoLote.SOAP_ACTION, envelope);
        final String xmlResultado = DFSoapEnvelope.desempacotar(resposta);
        final CTeEnvioLoteRetorno retorno = this.config.getPersister().read(CTeEnvioLoteRetorno.class, xmlResultado);
        this.getLogger().debug(retorno.toString());
        return retorno;
    }

    private String getCabecalhoSOAP() {
        return "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>3.00</versaoDados>";
    }
}

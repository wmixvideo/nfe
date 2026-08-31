package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.enviolote.consulta.CTeConsultaRecLote;
import com.fincatto.documentofiscal.cte300.classes.enviolote.consulta.CTeConsultaRecLoteRet;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;

class WSRecepcaoLoteRetorno implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CteRetRecepcao";
    private static final String SOAP_ACTION = WSRecepcaoLoteRetorno.NAMESPACE_WSDL + "/cteRetRecepcao";

    private final CTeConfig config;
    private final DFHttpClient httpClient;

    WSRecepcaoLoteRetorno(final CTeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    CTeConsultaRecLoteRet consultaLote(final String numeroRecibo) throws Exception {
        final String xmlConsulta = this.gerarDadosConsulta(numeroRecibo).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsulta(xmlConsulta);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(CTeConsultaRecLoteRet.class, xmlResultado);
    }

    private String efetuaConsulta(final String xmlConsulta) throws IOException, DFSoapFaultException {
        final String cabecalho = "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>3.00</versaoDados>";

        final CTAutorizador31 autorizador = CTAutorizador31.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getCteRetRecepcao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RetRecepcao, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSRecepcaoLoteRetorno.NAMESPACE_WSDL, "cteCabecMsg", cabecalho, "cteDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSRecepcaoLoteRetorno.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private CTeConsultaRecLote gerarDadosConsulta(final String numeroRecibo) {
        final CTeConsultaRecLote consulta = new CTeConsultaRecLote();
        consulta.setNumeroRecebimento(numeroRecibo);
        consulta.setAmbiente(this.config.getAmbiente());
        consulta.setVersao("3.00");
        return consulta;
    }
}

package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.consultastatusservico.CTeConsStatServ;
import com.fincatto.documentofiscal.cte300.classes.consultastatusservico.CTeConsStatServRet;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;

class WSStatusConsulta implements DFLog {

    private static final String NOME_SERVICO = "STATUS";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico";
    private static final String SOAP_ACTION = WSStatusConsulta.NAMESPACE_WSDL + "/cteStatusServicoCT";

    private final CTeConfig config;
    private final DFHttpClient httpClient;

    WSStatusConsulta(final CTeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    CTeConsStatServRet consultaStatus(final DFUnidadeFederativa uf) throws Exception {
        final String xmlConsulta = WSStatusConsulta.gerarDadosConsulta(this.config).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsultaStatus(xmlConsulta, uf);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(CTeConsStatServRet.class, xmlResultado);
    }

    private static CTeConsStatServ gerarDadosConsulta(final CTeConfig config) {
        final CTeConsStatServ consStatServ = new CTeConsStatServ();
        consStatServ.setAmbiente(config.getAmbiente());
        consStatServ.setVersao("3.00");
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }

    private String efetuaConsultaStatus(final String xmlConsulta, final DFUnidadeFederativa unidadeFederativa) throws IOException, DFSoapFaultException {
        final CTAutorizador31 autorizador = CTAutorizador31.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getCteStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico, autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }

        final String envelope = WSStatusConsulta.montarEnvelope(unidadeFederativa, xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSStatusConsulta.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    /**
     * Monta o envelope SOAP 1.2 desta operacao, com o {@code cteCabecMsg} (obrigatorio em toda
     * operacao do cte300) contendo {@code cUF}/{@code versaoDados}. Extraido de
     * {@link #efetuaConsultaStatus} como metodo puro (sem I/O) para poder ser pinado por teste
     * sem precisar de servidor HTTP.
     */
    static String montarEnvelope(final DFUnidadeFederativa unidadeFederativa, final String xmlConsulta) {
        final String cabecalho = "<cUF>" + unidadeFederativa.getCodigoIbge() + "</cUF><versaoDados>3.00</versaoDados>";
        return DFSoapEnvelope.envelopar(WSStatusConsulta.NAMESPACE_WSDL, "cteCabecMsg", cabecalho, "cteDadosMsg", xmlConsulta);
    }
}

package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTAutorizador400;
import com.fincatto.documentofiscal.cte400.classes.nota.consulta.CTeNotaConsulta;
import com.fincatto.documentofiscal.cte400.classes.nota.consulta.CTeNotaConsultaRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;

class WSConsulta implements DFLog {

    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CTeConsultaV4";
    private static final String SOAP_ACTION = WSConsulta.NAMESPACE_WSDL + "/cteConsultaCT";

    private final CTeConfig config;
    private final DFHttpClient httpClient;

    WSConsulta(final CTeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    CTeNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final String xmlConsulta = this.gerarDadosConsulta(chaveDeAcesso).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsulta(xmlConsulta, chaveDeAcesso);
        this.getLogger().debug(xmlResultado);

        final CTeNotaConsultaRetorno retorno = this.config.getPersister().read(CTeNotaConsultaRetorno.class, xmlResultado);
        this.getLogger().debug(retorno.toString());
        return retorno;
    }

    private String efetuaConsulta(final String xmlConsulta, final String chaveDeAcesso)
            throws IOException, DFSoapFaultException {
        final CTAutorizador400 autorizador = CTAutorizador400.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = autorizador.getCteConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        this.getLogger().debug(endpoint);

        final String envelope = DFSoapEnvelope.envelopar(WSConsulta.NAMESPACE_WSDL, "cteDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSConsulta.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private CTeNotaConsulta gerarDadosConsulta(final String chaveDeAcesso) {
        final CTeNotaConsulta notaConsulta = new CTeNotaConsulta();
        notaConsulta.setAmbiente(this.config.getAmbiente());
        notaConsulta.setChave(chaveDeAcesso);
        notaConsulta.setServico(WSConsulta.NOME_SERVICO);
        notaConsulta.setVersao(new BigDecimal("4.00"));
        return notaConsulta;
    }
}

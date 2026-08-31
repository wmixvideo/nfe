package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.consultastatusservico.MDFeConsStatServ;
import com.fincatto.documentofiscal.mdfe3.classes.consultastatusservico.MDFeConsStatServRet;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;

/**
 * Created by Eldevan Nery Junior on 10/11/17.
 * Classe para envio do pedido de Consulta do Status do Servico MDF-e.
 */
class WSStatusConsulta implements DFLog {

    private static final String NOME_SERVICO = "STATUS";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeStatusServico";
    private static final String SOAP_ACTION = WSStatusConsulta.NAMESPACE_WSDL + "/mdfeStatusServicoMDF";

    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSStatusConsulta(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    MDFeConsStatServRet consultaStatus(final DFUnidadeFederativa uf) throws Exception {
        final String xmlConsulta = WSStatusConsulta.gerarDadosConsulta(this.config).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsultaStatus(xmlConsulta, uf);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(MDFeConsStatServRet.class, xmlResultado);
    }

    private static MDFeConsStatServ gerarDadosConsulta(final MDFeConfig config) {
        final MDFeConsStatServ consStatServ = new MDFeConsStatServ();
        consStatServ.setAmbiente(config.getAmbiente());
        consStatServ.setVersao(MDFeConfig.VERSAO);
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }

    private String efetuaConsultaStatus(final String xmlConsulta, final DFUnidadeFederativa unidadeFederativa) throws IOException, DFSoapFaultException {
        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = autorizador.getMDFeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico, autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }

        final String cabecalho = "<cUF>" + unidadeFederativa.getCodigoIbge() + "</cUF><versaoDados>" + MDFeConfig.VERSAO + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSStatusConsulta.NAMESPACE_WSDL, "mdfeCabecMsg", cabecalho, "mdfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSStatusConsulta.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }
}

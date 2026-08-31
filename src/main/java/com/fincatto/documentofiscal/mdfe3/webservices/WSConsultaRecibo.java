package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.consultaRecibo.MDFeConsultaRecibo;
import com.fincatto.documentofiscal.mdfe3.classes.consultaRecibo.MDFeConsultaReciboRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;

/**
 * Created by Eldevan Nery Junior on 30/11/17.
 * Classe para envio do pedido de Consulta do recibo MDF-e.
 */
class WSConsultaRecibo implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeRetRecepcao";
    private static final String SOAP_ACTION = WSConsultaRecibo.NAMESPACE_WSDL + "/mdfeRetRecepcao";

    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSConsultaRecibo(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    MDFeConsultaReciboRetorno consultaRecibo(final String numeroRecibo) throws Exception {
        final String xmlConsulta = this.gerarDadosConsulta(numeroRecibo).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsultaRecibo(xmlConsulta);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(MDFeConsultaReciboRetorno.class, xmlResultado);
    }

    private MDFeConsultaRecibo gerarDadosConsulta(final String numeroRecibo) {
        final MDFeConsultaRecibo consultaRecibo = new MDFeConsultaRecibo();
        consultaRecibo.setNumeroRecibo(numeroRecibo);
        consultaRecibo.setAmbiente(this.config.getAmbiente());
        consultaRecibo.setVersao(MDFeConfig.VERSAO);
        return consultaRecibo;
    }

    private String efetuaConsultaRecibo(final String xmlConsulta) throws IOException, DFSoapFaultException {
        final String cabecalho = "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>" + MDFeConfig.VERSAO + "</versaoDados>";

        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeRetornoRecepcao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta Recibo, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSConsultaRecibo.NAMESPACE_WSDL, "mdfeCabecMsg", cabecalho, "mdfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSConsultaRecibo.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }
}

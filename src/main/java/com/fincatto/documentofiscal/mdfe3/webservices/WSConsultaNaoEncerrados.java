package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados.MDFeConsultaNaoEncerrados;
import com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados.MDFeConsultaNaoEncerradosRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;

/**
 * Created by Eldevan Nery Junior on 22/11/17.
 * Classe para envio do pedido de Consulta  do Servico de  MDF-e's nao encerrados.
 */
class WSConsultaNaoEncerrados implements DFLog {

    private static final String NOME_SERVICO = "CONSULTAR NÃO ENCERRADOS";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeConsNaoEnc";
    private static final String SOAP_ACTION = WSConsultaNaoEncerrados.NAMESPACE_WSDL + "/mdfeConsNaoEnc";

    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSConsultaNaoEncerrados(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    MDFeConsultaNaoEncerradosRetorno consultaNaoEncerrados(final String cnpj) throws Exception {
        final String xmlConsulta = this.gerarDadosConsulta(cnpj).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsultaStatus(xmlConsulta);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(MDFeConsultaNaoEncerradosRetorno.class, xmlResultado);
    }

    private MDFeConsultaNaoEncerrados gerarDadosConsulta(final String cnpj) {
        final MDFeConsultaNaoEncerrados encerrados = new MDFeConsultaNaoEncerrados();
        encerrados.setAmbiente(this.config.getAmbiente());
        encerrados.setVersao(MDFeConfig.VERSAO);
        encerrados.setCnpj(cnpj);
        encerrados.setServico(WSConsultaNaoEncerrados.NOME_SERVICO);
        return encerrados;
    }

    private String efetuaConsultaStatus(final String xmlConsulta) throws IOException, DFSoapFaultException {
        final String cabecalho = "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>" + MDFeConfig.VERSAO + "</versaoDados>";

        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeConsNaoEnc(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para CONSULTAR NAO ENCERRADOS, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        this.getLogger().debug(endpoint);

        final String envelope = DFSoapEnvelope.envelopar(WSConsultaNaoEncerrados.NAMESPACE_WSDL, "mdfeCabecMsg", cabecalho, "mdfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSConsultaNaoEncerrados.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }
}

package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.nota.consulta.MDFeNotaConsulta;
import com.fincatto.documentofiscal.mdfe3.classes.nota.consulta.MDFeNotaConsultaRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;

class WSNotaConsulta implements DFLog {

    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "3.00";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeConsulta";
    private static final String SOAP_ACTION = WSNotaConsulta.NAMESPACE_WSDL + "/mdfeConsultaMDF";

    private final MDFeConfig config;
    private final DFHttpClient httpClient;

    WSNotaConsulta(final MDFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    public MDFeNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final String xmlConsulta = this.gerarDadosConsulta(chaveDeAcesso).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsulta(xmlConsulta, chaveDeAcesso);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(MDFeNotaConsultaRetorno.class, xmlResultado);
    }

    private String efetuaConsulta(final String xmlConsulta, final String chaveDeAcesso) throws IOException, DFSoapFaultException {
        final MDFChaveParser ctChaveParser = new MDFChaveParser(chaveDeAcesso);
        final String cabecalho = "<cUF>" + ctChaveParser.getNFUnidadeFederativa().getCodigoIbge() + "</cUF><versaoDados>" + WSNotaConsulta.VERSAO_SERVICO + "</versaoDados>";

        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeConsulta(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSNotaConsulta.NAMESPACE_WSDL, "mdfeCabecMsg", cabecalho, "mdfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSNotaConsulta.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private MDFeNotaConsulta gerarDadosConsulta(final String chaveDeAcesso) {
        final MDFeNotaConsulta notaConsulta = new MDFeNotaConsulta();
        notaConsulta.setAmbiente(this.config.getAmbiente());
        notaConsulta.setChave(chaveDeAcesso);
        notaConsulta.setServico(WSNotaConsulta.NOME_SERVICO);
        notaConsulta.setVersao(new BigDecimal(WSNotaConsulta.VERSAO_SERVICO));
        return notaConsulta;
    }
}

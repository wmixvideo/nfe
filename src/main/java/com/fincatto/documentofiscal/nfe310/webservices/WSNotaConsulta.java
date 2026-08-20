package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.nota.consulta.NFNotaConsulta;
import com.fincatto.documentofiscal.nfe310.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.documentofiscal.nfe310.parsers.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;

class WSNotaConsulta implements DFLog {

    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "3.10";
    private static final String NAMESPACE_WSDL_SVRS = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta2";
    private static final String SOAP_ACTION_SVRS = WSNotaConsulta.NAMESPACE_WSDL_SVRS + "/nfeConsultaNF2";
    private static final String NAMESPACE_WSDL_BA = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta";
    private static final String SOAP_ACTION_BA = WSNotaConsulta.NAMESPACE_WSDL_BA + "/nfeConsultaNF";

    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSNotaConsulta(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final String xmlConsulta = this.gerarDadosConsulta(chaveDeAcesso).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsulta(xmlConsulta, chaveDeAcesso);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(NFNotaConsultaRetorno.class, xmlResultado);
    }

    private String efetuaConsulta(final String xmlConsulta, final String chaveDeAcesso) throws Exception {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);

        final boolean consultaNFeBahia = DFUnidadeFederativa.BA.equals(notaFiscalChaveParser.getNFUnidadeFederativa()) && DFModelo.NFE.equals(notaFiscalChaveParser.getModelo());
        if (consultaNFeBahia) {
            return this.efetuaConsultaBA(xmlConsulta, chaveDeAcesso);
        } else {
            return this.efetuaConsultaSVRS(xmlConsulta, chaveDeAcesso);
        }
    }

    private String efetuaConsultaSVRS(final String xmlConsulta, final String chaveDeAcesso) throws IOException, DFSoapFaultException {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = DFModelo.NFCE.equals(notaFiscalChaveParser.getModelo()) ? autorizador.getNfceConsultaProtocolo(this.config.getAmbiente()) : autorizador.getNfeConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para ConsultaProtocolo " + notaFiscalChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        final String cabecalho = "<cUF>" + notaFiscalChaveParser.getNFUnidadeFederativa().getCodigoIbge() + "</cUF><versaoDados>" + WSNotaConsulta.VERSAO_SERVICO + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSNotaConsulta.NAMESPACE_WSDL_SVRS, "nfeCabecMsg", cabecalho, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSNotaConsulta.SOAP_ACTION_SVRS, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private String efetuaConsultaBA(final String xmlConsulta, final String chaveDeAcesso) throws IOException, DFSoapFaultException {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = DFModelo.NFCE.equals(notaFiscalChaveParser.getModelo()) ? autorizador.getNfceConsultaProtocolo(this.config.getAmbiente()) : autorizador.getNfeConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para ConsultaProtocolo " + notaFiscalChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        final String cabecalho = "<cUF>" + notaFiscalChaveParser.getNFUnidadeFederativa().getCodigoIbge() + "</cUF><versaoDados>" + WSNotaConsulta.VERSAO_SERVICO + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSNotaConsulta.NAMESPACE_WSDL_BA, "nfeCabecMsg", cabecalho, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSNotaConsulta.SOAP_ACTION_BA, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private NFNotaConsulta gerarDadosConsulta(final String chaveDeAcesso) {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        notaConsulta.setAmbiente(this.config.getAmbiente());
        notaConsulta.setChave(chaveDeAcesso);
        notaConsulta.setServico(WSNotaConsulta.NOME_SERVICO);
        notaConsulta.setVersao(new BigDecimal(WSNotaConsulta.VERSAO_SERVICO));
        return notaConsulta;
    }
}

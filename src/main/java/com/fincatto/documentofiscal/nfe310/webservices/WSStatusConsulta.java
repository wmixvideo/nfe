package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.statusservico.consulta.NFStatusServicoConsulta;
import com.fincatto.documentofiscal.nfe310.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;

class WSStatusConsulta implements DFLog {

    private static final String NOME_SERVICO = "STATUS";
    private static final String NAMESPACE_WSDL_SVRS = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico2";
    private static final String SOAP_ACTION_SVRS = WSStatusConsulta.NAMESPACE_WSDL_SVRS + "/nfeStatusServicoNF2";
    private static final String NAMESPACE_WSDL_BA = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico";
    private static final String SOAP_ACTION_BA = WSStatusConsulta.NAMESPACE_WSDL_BA + "/nfeStatusServicoNF";

    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSStatusConsulta(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf, final DFModelo modelo) throws Exception {
        final String xmlConsulta = this.gerarDadosConsulta(uf).toString();
        this.getLogger().debug(xmlConsulta);

        final boolean consultaNotaBahiaWorkaround = DFUnidadeFederativa.BA.equals(uf) && DFModelo.NFE.equals(modelo);
        final String xmlResultado = consultaNotaBahiaWorkaround ? this.efetuaConsultaStatusBahia(xmlConsulta) : this.efetuaConsultaStatus(xmlConsulta, uf, modelo);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(NFStatusServicoConsultaRetorno.class, xmlResultado);
    }

    private NFStatusServicoConsulta gerarDadosConsulta(final DFUnidadeFederativa unidadeFederativa) {
        final NFStatusServicoConsulta consStatServ = new NFStatusServicoConsulta();
        consStatServ.setUf(unidadeFederativa);
        consStatServ.setAmbiente(this.config.getAmbiente());
        consStatServ.setVersao(this.config.getVersao());
        consStatServ.setServico(WSStatusConsulta.NOME_SERVICO);
        return consStatServ;
    }

    private String efetuaConsultaStatus(final String xmlConsulta, final DFUnidadeFederativa unidadeFederativa, final DFModelo modelo) throws IOException, DFSoapFaultException {
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = DFModelo.NFCE.equals(modelo) ? autorizador.getNfceStatusServico(this.config.getAmbiente()) : autorizador.getNfeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }

        final String cabecalho = "<cUF>" + unidadeFederativa.getCodigoIbge() + "</cUF><versaoDados>" + this.config.getVersao() + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSStatusConsulta.NAMESPACE_WSDL_SVRS, "nfeCabecMsg", cabecalho, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSStatusConsulta.SOAP_ACTION_SVRS, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    // este metodo teve que ser implementado pois a Bahia trata de forma diferente
    private String efetuaConsultaStatusBahia(final String xmlConsulta) throws IOException, DFSoapFaultException {
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(DFUnidadeFederativa.BA);
        final String endpoint = autorizador.getNfeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + DFModelo.NFE.name() + ", autorizador " + autorizador.name() + ", UF " + DFUnidadeFederativa.BA.name());
        }

        final String cabecalho = "<cUF>" + DFUnidadeFederativa.BA.getCodigoIbge() + "</cUF><versaoDados>" + this.config.getVersao() + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSStatusConsulta.NAMESPACE_WSDL_BA, "nfeCabecMsg", cabecalho, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSStatusConsulta.SOAP_ACTION_BA, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }
}

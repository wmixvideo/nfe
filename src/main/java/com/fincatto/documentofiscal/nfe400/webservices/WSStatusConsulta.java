package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.statusservico.consulta.NFStatusServicoConsulta;
import com.fincatto.documentofiscal.nfe400.classes.statusservico.consulta.NFStatusServicoConsultaRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;

class WSStatusConsulta implements DFLog {

    private static final String NOME_SERVICO = "STATUS";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4";
    private static final String SOAP_ACTION = NAMESPACE_WSDL + "/nfeStatusServicoNF";

    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSStatusConsulta(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    /**
     * Consulta o status do servico da SEFAZ responsavel pela UF informada.
     *
     * @param uf UF que deseja consultar o status do sefaz responsavel.
     * @param modelo modelo da nota (NF-e ou NFC-e).
     * @return dados da consulta de status retornado pelo webservice.
     * @throws IOException caso nao consiga se conectar a SEFAZ.
     * @throws DFSoapFaultException caso a SEFAZ devolva um soap:Fault.
     * @throws Exception caso nao consiga fazer o parse do XML de retorno.
     */
    NFStatusServicoConsultaRetorno consultaStatus(final DFUnidadeFederativa uf, final DFModelo modelo) throws Exception {
        final String xmlConsulta = this.gerarDadosConsulta(uf).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsultaStatus(xmlConsulta, uf, modelo);
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
        final NFAutorizador400 autorizador = NFAutorizador400.valueOfCodigoUF(unidadeFederativa);
        final String endpoint = DFModelo.NFCE.equals(modelo) ? autorizador.getNfceStatusServico(this.config.getAmbiente()) : autorizador.getNfeStatusServico(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para StatusServico " + modelo.name() + ", autorizador " + autorizador.name() + ", UF " + unidadeFederativa.name());
        }

        final String envelope = DFSoapEnvelope.envelopar(NAMESPACE_WSDL, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }
}

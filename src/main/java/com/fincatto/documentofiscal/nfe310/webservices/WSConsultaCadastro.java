package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFConsultaCadastro;
import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFInfoConsultaCadastro;
import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFRetornoConsultaCadastro;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;

class WSConsultaCadastro implements DFLog {

    private static final String NOME_SERVICO = "CONS-CAD";
    private static final String VERSAO_SERVICO = "2.00";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro2";
    private static final String SOAP_ACTION = WSConsultaCadastro.NAMESPACE_WSDL + "/consultaCadastro2";

    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSConsultaCadastro(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFRetornoConsultaCadastro consultaCadastro(final String cnpj, final DFUnidadeFederativa uf) throws Exception {
        final NFConsultaCadastro dadosConsulta = this.getDadosConsulta(cnpj, uf);
        final String xmlConsulta = dadosConsulta.toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsulta(uf, xmlConsulta);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(NFRetornoConsultaCadastro.class, xmlResultado);
    }

    private String efetuaConsulta(final DFUnidadeFederativa uf, final String xmlConsulta) throws IOException, DFSoapFaultException {
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfCodigoUF(uf);
        final String endpoint = autorizador.getConsultaCadastro(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalStateException(String.format("UF %s nao possui URL de ConsultaCadastro (autorizador %s, ambiente %s)", uf.getDescricao(), autorizador.name(), this.config.getAmbiente()));
        }

        final String cabecalho = "<cUF>" + uf.getCodigoIbge() + "</cUF><versaoDados>" + WSConsultaCadastro.VERSAO_SERVICO + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSConsultaCadastro.NAMESPACE_WSDL, "nfeCabecMsg", cabecalho, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSConsultaCadastro.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private NFConsultaCadastro getDadosConsulta(final String cnpj, final DFUnidadeFederativa uf) {
        final NFConsultaCadastro consulta = new NFConsultaCadastro();
        consulta.setVersao(WSConsultaCadastro.VERSAO_SERVICO);
        consulta.setConsultaCadastro(new NFInfoConsultaCadastro());
        consulta.getConsultaCadastro().setCnpj(cnpj);
        consulta.getConsultaCadastro().setServico(WSConsultaCadastro.NOME_SERVICO);
        consulta.getConsultaCadastro().setUf(uf.getCodigo());
        return consulta;
    }
}

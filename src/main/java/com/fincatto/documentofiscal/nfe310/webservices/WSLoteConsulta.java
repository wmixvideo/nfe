package com.fincatto.documentofiscal.nfe310.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe310.classes.NFAutorizador31;
import com.fincatto.documentofiscal.nfe310.classes.lote.consulta.NFLoteConsulta;
import com.fincatto.documentofiscal.nfe310.classes.lote.consulta.NFLoteConsultaRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;

class WSLoteConsulta implements DFLog {

    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeRetAutorizacao";
    private static final String SOAP_ACTION = WSLoteConsulta.NAMESPACE_WSDL + "/nfeRetAutorizacaoLote";

    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSLoteConsulta(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFLoteConsultaRetorno consultaLote(final String numeroRecibo, final DFModelo modelo) throws Exception {
        final String xmlConsulta = this.gerarDadosConsulta(numeroRecibo).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsulta(xmlConsulta, modelo);
        this.getLogger().debug(xmlResultado);

        return this.config.getPersister().read(NFLoteConsultaRetorno.class, xmlResultado);
    }

    private String efetuaConsulta(final String xmlConsulta, final DFModelo modelo) throws IOException, DFSoapFaultException {
        final NFAutorizador31 autorizador = NFAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = DFModelo.NFCE.equals(modelo) ? autorizador.getNfceRetAutorizacao(this.config.getAmbiente()) : autorizador.getNfeRetAutorizacao(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para RetAutorizacao " + modelo.name() + ", autorizador " + autorizador.name());
        }

        final String cabecalho = "<cUF>" + this.config.getCUF().getCodigoIbge() + "</cUF><versaoDados>" + this.config.getVersao() + "</versaoDados>";
        final String envelope = DFSoapEnvelope.envelopar(WSLoteConsulta.NAMESPACE_WSDL, "nfeCabecMsg", cabecalho, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSLoteConsulta.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private NFLoteConsulta gerarDadosConsulta(final String numeroRecibo) {
        final NFLoteConsulta consulta = new NFLoteConsulta();
        consulta.setRecibo(numeroRecibo);
        consulta.setAmbiente(this.config.getAmbiente());
        consulta.setVersao(new BigDecimal(this.config.getVersao()));
        return consulta;
    }
}

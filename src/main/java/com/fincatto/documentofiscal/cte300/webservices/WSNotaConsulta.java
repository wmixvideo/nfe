package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.nota.consulta.CTeNotaConsulta;
import com.fincatto.documentofiscal.cte300.classes.nota.consulta.CTeNotaConsultaRetorno;
import com.fincatto.documentofiscal.cte300.parsers.CTChaveParser;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;

class WSNotaConsulta implements DFLog {
    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "3.00";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta";
    private static final String SOAP_ACTION = WSNotaConsulta.NAMESPACE_WSDL + "/cteConsultaCT";

    private final CTeConfig config;
    private final DFHttpClient httpClient;

    WSNotaConsulta(final CTeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    public CTeNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final String xmlConsulta = this.gerarDadosConsulta(chaveDeAcesso).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlResultado = this.efetuaConsulta(xmlConsulta, chaveDeAcesso);
        this.getLogger().debug(xmlResultado);

        final CTeNotaConsultaRetorno retorno = this.config.getPersister().read(CTeNotaConsultaRetorno.class, xmlResultado);
        this.getLogger().debug(retorno.toString());
        return retorno;
    }

    private String efetuaConsulta(final String xmlConsulta, final String chaveDeAcesso) throws IOException, DFSoapFaultException {
        final CTChaveParser ctChaveParser = new CTChaveParser(chaveDeAcesso);
        final String cabecalho = "<cUF>" + ctChaveParser.getNFUnidadeFederativa().getCodigoIbge() + "</cUF><versaoDados>" + WSNotaConsulta.VERSAO_SERVICO + "</versaoDados>";
        this.getLogger().debug(cabecalho);

        final CTAutorizador31 autorizador = CTAutorizador31.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = autorizador.getCteConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta, autorizador " + autorizador.name() + ", UF " + ctChaveParser.getNFUnidadeFederativa().name());
        }
        this.getLogger().debug(endpoint);

        final String envelope = DFSoapEnvelope.envelopar(WSNotaConsulta.NAMESPACE_WSDL, "cteCabecMsg", cabecalho, "cteDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSNotaConsulta.SOAP_ACTION, envelope);
        return DFSoapEnvelope.desempacotar(resposta);
    }

    private CTeNotaConsulta gerarDadosConsulta(final String chaveDeAcesso) {
        final CTeNotaConsulta notaConsulta = new CTeNotaConsulta();
        notaConsulta.setAmbiente(this.config.getAmbiente());
        notaConsulta.setChave(chaveDeAcesso);
        notaConsulta.setServico(WSNotaConsulta.NOME_SERVICO);
        notaConsulta.setVersao(new BigDecimal(WSNotaConsulta.VERSAO_SERVICO));
        return notaConsulta;
    }
}

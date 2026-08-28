package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.nota.consulta.NFNotaConsulta;
import com.fincatto.documentofiscal.nfe400.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.documentofiscal.utils.DFHttpClient;
import com.fincatto.documentofiscal.utils.DFSoapEnvelope;
import com.fincatto.documentofiscal.utils.DFSoapFaultException;

import java.io.IOException;
import java.math.BigDecimal;

class WSNotaConsulta implements DFLog {
    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "4.00";
    private static final String NAMESPACE_WSDL = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4";
    private static final String SOAP_ACTION = WSNotaConsulta.NAMESPACE_WSDL + "/nfeConsultaNF";
    private final NFeConfig config;
    private final DFHttpClient httpClient;

    WSNotaConsulta(final NFeConfig config, final DFHttpClient httpClient) {
        this.config = config;
        this.httpClient = httpClient;
    }

    NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        return this.config.getPersister().read(NFNotaConsultaRetorno.class, this.consultaNotaAsString(chaveDeAcesso));
    }

    public String consultaNotaAsString(String chaveDeAcesso) throws IOException, DFSoapFaultException {
        final String xmlConsulta = this.gerarDadosConsulta(chaveDeAcesso).toString();
        this.getLogger().debug(xmlConsulta);

        final String xmlRetorno = this.efetuaConsulta(xmlConsulta, chaveDeAcesso);
        this.getLogger().debug(xmlRetorno);
        return xmlRetorno;
    }

    /**
     * Envia a consulta da nota para a SEFAZ via {@link DFHttpClient} e devolve o XML de negocio
     * ja desempacotado do envelope SOAP 1.2 de resposta.
     */
    private String efetuaConsulta(final String xmlConsulta, final String chaveDeAcesso) throws IOException, DFSoapFaultException {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);

        final NFAutorizador400 autorizador = NFAutorizador400.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = DFModelo.NFCE.equals(notaFiscalChaveParser.getModelo()) ? autorizador.getNfceConsultaProtocolo(this.config.getAmbiente()) : autorizador.getNfeConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para ConsultaProtocolo " + notaFiscalChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }

        final String envelope = DFSoapEnvelope.envelopar(WSNotaConsulta.NAMESPACE_WSDL, "nfeDadosMsg", xmlConsulta);
        final String resposta = this.httpClient.postSoap(endpoint, WSNotaConsulta.SOAP_ACTION, envelope);
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

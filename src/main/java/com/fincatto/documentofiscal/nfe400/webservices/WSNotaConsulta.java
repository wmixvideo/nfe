package com.fincatto.documentofiscal.nfe400.webservices;

import java.math.BigDecimal;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.NFAutorizador400;
import com.fincatto.documentofiscal.nfe400.classes.nota.consulta.NFNotaConsulta;
import com.fincatto.documentofiscal.nfe400.classes.nota.consulta.NFNotaConsultaRetorno;
import com.fincatto.documentofiscal.nfe400.parsers.NotaFiscalChaveParser;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeConsultaProtocolo4Stub;
import com.fincatto.documentofiscal.nfe400.webservices.gerado.NFeConsultaProtocolo4Stub.NfeConsultaNFResult;
import com.fincatto.documentofiscal.transformers.DFRegistryMatcher;

class WSNotaConsulta {
    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "4.00";
    private final static Logger LOGGER = LoggerFactory.getLogger(WSNotaConsulta.class);
    private final NFeConfig config;

    WSNotaConsulta(final NFeConfig config) {
        this.config = config;
    }

    NFNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(chaveDeAcesso).toString());
        WSNotaConsulta.LOGGER.debug(omElementConsulta.toString());

        final OMElement omElementRetorno = this.efetuaConsulta(omElementConsulta, chaveDeAcesso);
        WSNotaConsulta.LOGGER.debug(omElementRetorno.toString());
        return new Persister(new DFRegistryMatcher(), new Format(0)).read(NFNotaConsultaRetorno.class, omElementRetorno.toString());
    }

    private OMElement efetuaConsulta(final OMElement omElementConsulta, final String chaveDeAcesso) throws Exception {
        final NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser(chaveDeAcesso);

        final NFeConsultaProtocolo4Stub.NfeDadosMsg dados = new NFeConsultaProtocolo4Stub.NfeDadosMsg();
        dados.setExtraElement(omElementConsulta);

        final NFAutorizador400 autorizador = NFAutorizador400.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = DFModelo.NFCE.equals(notaFiscalChaveParser.getModelo()) ? autorizador.getNfceConsultaProtocolo(this.config.getAmbiente()) : autorizador.getNfeConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para ConsultaProtocolo " + notaFiscalChaveParser.getModelo().name() + ", autorizador " + autorizador.name());
        }
        final NfeConsultaNFResult consultaNFResult = new NFeConsultaProtocolo4Stub(endpoint).nfeConsultaNF(dados);
        return consultaNFResult.getExtraElement();
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
package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.cte300.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.nota.consulta.CTeNotaConsulta;
import com.fincatto.documentofiscal.cte300.classes.nota.consulta.CTeNotaConsultaRetorno;
import com.fincatto.documentofiscal.cte300.parsers.CTChaveParser;
import com.fincatto.documentofiscal.cte300.webservices.consulta.CteConsultaStub;
import com.fincatto.documentofiscal.persister.DFPersister;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

class WSNotaConsulta {
    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "3.00";
    private final static Logger LOGGER = LoggerFactory.getLogger(WSNotaConsulta.class);
    private final CTeConfig config;

    WSNotaConsulta(final CTeConfig config) {
        this.config = config;
    }

    public CTeNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(chaveDeAcesso).toString());
        WSNotaConsulta.LOGGER.debug(omElementConsulta.toString());

        final OMElement omElementRetorno = this.efetuaConsulta(omElementConsulta, chaveDeAcesso);
        WSNotaConsulta.LOGGER.debug(omElementRetorno.toString());
        final CTeNotaConsultaRetorno retorno = new DFPersister().read(CTeNotaConsultaRetorno.class,
                omElementRetorno.toString());
        WSNotaConsulta.LOGGER.info(retorno.toString());
        return retorno;
    }

    private OMElement efetuaConsulta(final OMElement omElementConsulta, final String chaveDeAcesso) throws Exception {
        final CTChaveParser ctChaveParser = new CTChaveParser(chaveDeAcesso);
        final CteConsultaStub.CteCabecMsg cabec = new CteConsultaStub.CteCabecMsg();
        cabec.setCUF(ctChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        cabec.setVersaoDados(WSNotaConsulta.VERSAO_SERVICO);

        final CteConsultaStub.CteCabecMsgE cabecE = new CteConsultaStub.CteCabecMsgE();
        cabecE.setCteCabecMsg(cabec);

        final CteConsultaStub.CteDadosMsg dados = new CteConsultaStub.CteDadosMsg();
        dados.setExtraElement(omElementConsulta);

        WSNotaConsulta.LOGGER.info(cabec.toString());

        final CTAutorizador31 autorizador = CTAutorizador31.valueOfTipoEmissao(this.config.getTipoEmissao(), this.config.getCUF());
        final String endpoint = autorizador.getCteConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        WSNotaConsulta.LOGGER.info(endpoint);
        final CteConsultaStub.CteConsultaCTResult cteConsultaCTResult = new CteConsultaStub(endpoint).cteConsultaCT(dados, cabecE);
        return cteConsultaCTResult.getExtraElement();
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

package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.nota.consulta.MDFeNotaConsulta;
import com.fincatto.documentofiscal.mdfe3.classes.nota.consulta.MDFeNotaConsultaRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.mdfe3.webservices.consulta.MDFeConsultaStub;
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
    private final MDFeConfig config;

    WSNotaConsulta(final MDFeConfig config) {
        this.config = config;
    }

    public MDFeNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(chaveDeAcesso).toString());
        WSNotaConsulta.LOGGER.debug(omElementConsulta.toString());

        final OMElement omElementRetorno = this.efetuaConsulta(omElementConsulta, chaveDeAcesso);
        WSNotaConsulta.LOGGER.debug(omElementRetorno.toString());
        final MDFeNotaConsultaRetorno retorno = new DFPersister().read(MDFeNotaConsultaRetorno.class,
                omElementRetorno.toString());
        WSNotaConsulta.LOGGER.info(retorno.toString());
        return retorno;
    }

    private OMElement efetuaConsulta(final OMElement omElementConsulta, final String chaveDeAcesso) throws Exception {
        final MDFChaveParser ctChaveParser = new MDFChaveParser(chaveDeAcesso);
        final MDFeConsultaStub.MdfeCabecMsg cabec = new MDFeConsultaStub.MdfeCabecMsg();
        cabec.setCUF(ctChaveParser.getNFUnidadeFederativa().getCodigoIbge());
        cabec.setVersaoDados(WSNotaConsulta.VERSAO_SERVICO);

        final MDFeConsultaStub.MdfeCabecMsgE cabecE = new MDFeConsultaStub.MdfeCabecMsgE();
        cabecE.setMdfeCabecMsg(cabec);

        final MDFeConsultaStub.MdfeDadosMsg dados = new MDFeConsultaStub.MdfeDadosMsg();
        dados.setExtraElement(omElementConsulta);

        WSNotaConsulta.LOGGER.info(cabec.toString());

        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeConsulta(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        WSNotaConsulta.LOGGER.info(endpoint);
        final MDFeConsultaStub.MdfeConsultaMDFResult mdfeConsultaMDFResult = new MDFeConsultaStub(endpoint).mdfeConsultaMDF(dados, cabecE);
        return mdfeConsultaMDFResult.getExtraElement();
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

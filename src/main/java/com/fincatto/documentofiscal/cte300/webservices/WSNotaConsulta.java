package com.fincatto.documentofiscal.cte300.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte300.classes.CTAutorizador31;
import com.fincatto.documentofiscal.cte300.classes.nota.consulta.CTeNotaConsulta;
import com.fincatto.documentofiscal.cte300.classes.nota.consulta.CTeNotaConsultaRetorno;
import com.fincatto.documentofiscal.cte300.parsers.CTChaveParser;
import com.fincatto.documentofiscal.cte300.webservices.consulta.CteConsultaStub;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;

class WSNotaConsulta implements DFLog {
    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "3.00";
    private final CTeConfig config;

    WSNotaConsulta(final CTeConfig config) {
        this.config = config;
    }

    public CTeNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(chaveDeAcesso).toString());
        this.getLogger().debug(omElementConsulta.toString());

        final OMElement omElementRetorno = this.efetuaConsulta(omElementConsulta, chaveDeAcesso);
        this.getLogger().debug(omElementRetorno.toString());
    
        final CTeNotaConsultaRetorno retorno = this.config.getPersister().read(CTeNotaConsultaRetorno.class, omElementRetorno.toString());
        this.getLogger().debug(retorno.toString());
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
    
        this.getLogger().debug(cabec.toString());

        final CTAutorizador31 autorizador = CTAutorizador31.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = autorizador.getCteConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        this.getLogger().debug(endpoint);
        final CteConsultaStub.CteConsultaCTResult cteConsultaCTResult = new CteConsultaStub(endpoint, config).cteConsultaCT(dados, cabecE);
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

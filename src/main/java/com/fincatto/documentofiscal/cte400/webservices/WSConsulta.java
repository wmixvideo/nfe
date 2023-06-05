package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.cte400.classes.CTAutorizador400;
import com.fincatto.documentofiscal.cte400.classes.nota.consulta.CTeNotaConsulta;
import com.fincatto.documentofiscal.cte400.classes.nota.consulta.CTeNotaConsultaRetorno;
import com.fincatto.documentofiscal.cte400.webservices.gerado.CTeConsultaV4Stub;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;

public class WSConsulta implements DFLog {

    private static final String NOME_SERVICO = "CONSULTAR";
    private final CTeConfig config;

    WSConsulta(final CTeConfig config) {
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
        final CTeConsultaV4Stub.CteDadosMsg dados = new CTeConsultaV4Stub.CteDadosMsg();
        dados.setExtraElement(omElementConsulta);

        final CTAutorizador400 autorizador = CTAutorizador400.valueOfChaveAcesso(chaveDeAcesso);
        final String endpoint = autorizador.getCteConsultaProtocolo(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        this.getLogger().debug(endpoint);
        final CTeConsultaV4Stub.CteConsultaCTResult cteConsultaCTResult = new CTeConsultaV4Stub(endpoint, config).cteConsultaCT(dados);
        return cteConsultaCTResult.getExtraElement();
    }

    private CTeNotaConsulta gerarDadosConsulta(final String chaveDeAcesso) {
        final CTeNotaConsulta notaConsulta = new CTeNotaConsulta();
        notaConsulta.setAmbiente(this.config.getAmbiente());
        notaConsulta.setChave(chaveDeAcesso);
        notaConsulta.setServico(WSConsulta.NOME_SERVICO);
        notaConsulta.setVersao(new BigDecimal("4.00"));
        return notaConsulta;
    }
}

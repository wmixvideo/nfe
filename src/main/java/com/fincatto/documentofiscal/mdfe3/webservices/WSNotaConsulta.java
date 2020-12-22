package com.fincatto.documentofiscal.mdfe3.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.mdfe3.MDFeConfig;
import com.fincatto.documentofiscal.mdfe3.classes.MDFAutorizador3;
import com.fincatto.documentofiscal.mdfe3.classes.nota.consulta.MDFeNotaConsulta;
import com.fincatto.documentofiscal.mdfe3.classes.nota.consulta.MDFeNotaConsultaRetorno;
import com.fincatto.documentofiscal.mdfe3.classes.parsers.MDFChaveParser;
import com.fincatto.documentofiscal.mdfe3.webservices.consulta.MDFeConsultaStub;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import java.math.BigDecimal;

class WSNotaConsulta implements DFLog {
    
    private static final String NOME_SERVICO = "CONSULTAR";
    private static final String VERSAO_SERVICO = "3.00";
    private final MDFeConfig config;
    
    WSNotaConsulta(final MDFeConfig config) {
        this.config = config;
    }
    
    public MDFeNotaConsultaRetorno consultaNota(final String chaveDeAcesso) throws Exception {
        final OMElement omElementConsulta = AXIOMUtil.stringToOM(this.gerarDadosConsulta(chaveDeAcesso).toString());
        this.getLogger().debug(omElementConsulta.toString());
        
        final OMElement omElementRetorno = this.efetuaConsulta(omElementConsulta, chaveDeAcesso);
        this.getLogger().debug(omElementRetorno.toString());
        
        return this.config.getPersister().read(MDFeNotaConsultaRetorno.class, omElementRetorno.toString());
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
        
        final MDFAutorizador3 autorizador = MDFAutorizador3.valueOfCodigoUF(this.config.getCUF());
        final String endpoint = autorizador.getMDFeConsulta(this.config.getAmbiente());
        if (endpoint == null) {
            throw new IllegalArgumentException("Nao foi possivel encontrar URL para Consulta, autorizador " + autorizador.name() + ", UF " + this.config.getCUF().name());
        }
        final MDFeConsultaStub.MdfeConsultaMDFResult mdfeConsultaMDFResult = new MDFeConsultaStub(endpoint, config).mdfeConsultaMDF(dados, cabecE);
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

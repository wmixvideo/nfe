package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * NT 2026.005 - campos do Simples Nacional (tpRegimeIBSCBS, cAtivSN, gTribSN).
 */
public class NFNotaInfoIBSCBSSimplesNacionalTest {

    private static NFNotaInfoItemImpostoIBSCBSTribSN tribSN(boolean comIBS) {
        final NFNotaInfoItemImpostoIBSCBSTribSN tribSN = new NFNotaInfoItemImpostoIBSCBSTribSN();
        if (comIBS) {
            final NFNotaInfoItemImpostoIBSCBSTribSN.GIBSSN ibs = new NFNotaInfoItemImpostoIBSCBSTribSN.GIBSSN();
            ibs.setPIBSSN(new BigDecimal("1.25"));
            ibs.setVIBSSN(new BigDecimal("12.50"));
            tribSN.setGIBSSN(ibs);
        }
        final NFNotaInfoItemImpostoIBSCBSTribSN.GCBSSN cbs = new NFNotaInfoItemImpostoIBSCBSTribSN.GCBSSN();
        cbs.setPCBSSN(new BigDecimal("2.7500"));
        cbs.setVCBSSN(new BigDecimal("27.50"));
        tribSN.setGCBSSN(cbs);
        return tribSN;
    }

    @Test
    public void deveGerarXmlDoItemSimplesNacionalSemRegimeRegular() {
        final NFNotaInfoItemImpostoIBSCBS ibsCbs = new NFNotaInfoItemImpostoIBSCBS();
        ibsCbs.setCst(NFNotaInfoImpostoTributacaoIBSCBS.CST_000);
        ibsCbs.setcClassTrib("000001");
        ibsCbs.setGrupoTributacaoSimplesNacional(tribSN(true));

        Assertions.assertEquals("<NFNotaInfoItemImpostoIBSCBS><CST>000</CST><cClassTrib>000001</cClassTrib>"
                + "<gTribSN><gIBSSN><pIBSSN>1.25</pIBSSN><vIBSSN>12.50</vIBSSN></gIBSSN>"
                + "<gCBSSN><pCBSSN>2.75</pCBSSN><vCBSSN>27.50</vCBSSN></gCBSSN></gTribSN>"
                + "</NFNotaInfoItemImpostoIBSCBS>", ibsCbs.toString());
    }

    @Test
    public void deveGerarGTribSNDepoisDoAjusteCompetenciaEAntesDoEstornoCredito() {
        final NFNotaInfoItemImpostoIBSCBS ibsCbs = new NFNotaInfoItemImpostoIBSCBS();
        ibsCbs.setCst(NFNotaInfoImpostoTributacaoIBSCBS.CST_000);
        ibsCbs.setcClassTrib("000001");
        ibsCbs.setGrupoTributacaoSimplesNacional(tribSN(false));
        final NFNotaInfoIBSCBSGrupoEstornoCredito estorno = new NFNotaInfoIBSCBSGrupoEstornoCredito();
        estorno.setValorIbsEstornado(BigDecimal.ONE);
        estorno.setValorCbsEstornado(BigDecimal.ONE);
        ibsCbs.setGrupoEstornoCredito(estorno);
        final NFNotaInfoItemImpostoIBSCBS.GrupoAjusteCompetencia ajuste = new NFNotaInfoItemImpostoIBSCBS.GrupoAjusteCompetencia();
        ajuste.setDataCompetenciaApuracao(java.time.YearMonth.of(2027, 1));
        ajuste.setValorIBS(BigDecimal.ONE);
        ajuste.setValorCBS(BigDecimal.ONE);
        ibsCbs.setGrupoAjusteCompetencia(ajuste);

        final String xml = ibsCbs.toString();
        Assertions.assertFalse(xml.contains("<gIBSSN>"), "CRT 2 sem regime regular informa somente gCBSSN");
        Assertions.assertTrue(xml.indexOf("<gAjusteCompet") < xml.indexOf("<gTribSN>"));
        Assertions.assertTrue(xml.indexOf("<gTribSN>") < xml.indexOf("<gEstornoCred"));
    }

    @Test
    public void deveGerarXmlDoTotalSimplesNacional() {
        final NFNotaInfoIBSCBSTot.GTribSN total = new NFNotaInfoIBSCBSTot.GTribSN();
        total.setVIBSSN(new BigDecimal("12.50"));
        total.setVCBSSN(new BigDecimal("27.50"));
        final NFNotaInfoIBSCBSTot ibsCbsTot = new NFNotaInfoIBSCBSTot();
        ibsCbsTot.setVBCIBSCBS(new BigDecimal("1000.00"));
        ibsCbsTot.setGrupoTributacaoSimplesNacional(total);

        Assertions.assertEquals("<NFNotaInfoIBSCBSTot><vBCIBSCBS>1000.00</vBCIBSCBS>"
                + "<gTribSN><vIBSSN>12.50</vIBSSN><vCBSSN>27.50</vCBSSN></gTribSN>"
                + "</NFNotaInfoIBSCBSTot>", ibsCbsTot.toString());
    }

    @Test
    public void deveGerarCAtivSNDepoisDoIndicadorBemMovelUsado() {
        final NFNotaInfoItemProduto produto = com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake.getNFNotaInfoItemProduto();
        produto.setIndicadorBemMovelUsado("1");
        produto.setCodigoAtividadeSimplesNacional("01");
        final String xml = produto.toString();
        Assertions.assertTrue(xml.contains("<indBemMovelUsado>1</indBemMovelUsado><cAtivSN>01</cAtivSN>"), xml);
    }

    @Test
    public void naoDevePermitirCAtivSNComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemProduto().setCodigoAtividadeSimplesNacional("1"));
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemProduto().setCodigoAtividadeSimplesNacional("AB"));
    }

    @Test
    public void deveGerarTpRegimeIBSCBSDepoisDoCRT() {
        final NFNotaInfoEmitente emitente = com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake.getNFNotaInfoEmitente();
        emitente.setRegimeTributario(com.fincatto.documentofiscal.nfe400.classes.NFRegimeTributario.SIMPLES_NACIONAL);
        emitente.setTipoRegimeIBSCBS("1");
        Assertions.assertTrue(emitente.toString().endsWith("<CRT>1</CRT><tpRegimeIBSCBS>1</tpRegimeIBSCBS></NFNotaInfoEmitente>"), emitente.toString());
    }

    @Test
    public void naoDevePermitirTpRegimeIBSCBSInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoEmitente().setTipoRegimeIBSCBS("5"));
    }
}

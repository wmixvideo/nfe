package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFCodigoAtividadeSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS;
import com.fincatto.documentofiscal.nfe400.classes.NFRegimeTributario;
import com.fincatto.documentofiscal.nfe400.classes.NFTipoRegimeIBSCBS;
import com.fincatto.documentofiscal.validadores.DFXMLValidador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXParseException;

import java.math.BigDecimal;
import java.time.YearMonth;

/**
 * NT 2026.005 v1.00 - campos do Simples Nacional (tpRegimeIBSCBS, cAtivSN, gTribSN), pacote PL_010h_v1.03.
 */
public class NFNotaInfoIBSCBSSimplesNacionalTest {

    private static NFNotaInfoItemImpostoIBSCBS ibsCbsComTribSN(final NFNotaInfoItemImpostoIBSCBSTribSN tribSN) {
        final NFNotaInfoItemImpostoIBSCBS ibsCbs = new NFNotaInfoItemImpostoIBSCBS();
        ibsCbs.setCst(NFNotaInfoImpostoTributacaoIBSCBS.CST_000);
        ibsCbs.setcClassTrib("000001");
        ibsCbs.setGrupoTributacaoSimplesNacional(tribSN);
        return ibsCbs;
    }

    @Test
    public void deveValidarNotaCompletaComCamposDoSimplesNacionalNoXSD() throws Exception {
        final NFNota nota = FabricaDeObjetosFake.getNFNota();
        final NFNotaInfo info = nota.getInfo();
        info.getEmitente().setRegimeTributario(NFRegimeTributario.SIMPLES_NACIONAL);
        info.getEmitente().setTipoRegimeIBSCBS(NFTipoRegimeIBSCBS.SIMPLES_NACIONAL_REGIME_REGULAR);
        for (final NFNotaInfoItem item : info.getItens()) {
            item.getProduto().setCodigoAtividadeSimplesNacional(NFCodigoAtividadeSimplesNacional.REVENDA_OU_INDUSTRIALIZACAO_ANEXO_I);
            item.getImposto().setIbsCbs(ibsCbsComTribSN(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSTribSN()));
        }
        final NFNotaInfoIBSCBSTot ibsCbsTot = new NFNotaInfoIBSCBSTot();
        ibsCbsTot.setVBCIBSCBS(new BigDecimal("1000.00"));
        ibsCbsTot.setGrupoTributacaoSimplesNacional(FabricaDeObjetosFake.getNFNotaInfoIBSCBSTotTribSN());
        info.getTotal().setIbscbsTot(ibsCbsTot);

        final String xml = nota.toString();
        Assertions.assertTrue(xml.contains("<tpRegimeIBSCBS>1</tpRegimeIBSCBS>"), xml);
        Assertions.assertTrue(xml.contains("<cAtivSN>01</cAtivSN>"), xml);
        try {
            DFXMLValidador.validaNota400(xml);
            Assertions.fail("Esperava falha de validacao apenas pela ausencia da assinatura (Signature)");
        } catch (final SAXParseException e) {
            Assertions.assertTrue(e.getMessage().contains("Signature"), e.getMessage());
        }
    }

    @Test
    public void deveGerarXmlDoItemSimplesNacionalComIBSECBS() {
        final NFNotaInfoItemImpostoIBSCBS ibsCbs = ibsCbsComTribSN(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSTribSN());

        Assertions.assertEquals("<NFNotaInfoItemImpostoIBSCBS><CST>000</CST><cClassTrib>000001</cClassTrib>"
                + "<gTribSN><gIBSSN><pIBSSN>1.25</pIBSSN><vIBSSN>12.50</vIBSSN></gIBSSN>"
                + "<gCBSSN><pCBSSN>2.75</pCBSSN><vCBSSN>27.50</vCBSSN></gCBSSN></gTribSN>"
                + "</NFNotaInfoItemImpostoIBSCBS>", ibsCbs.toString());
    }

    @Test
    public void naoDeveGerarGIBSSNQuandoNaoInformado() {
        final NFNotaInfoItemImpostoIBSCBSTribSN tribSN = FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSTribSN();
        tribSN.setGIBSSN(null);

        Assertions.assertEquals("<NFNotaInfoItemImpostoIBSCBS><CST>000</CST><cClassTrib>000001</cClassTrib>"
                + "<gTribSN><gCBSSN><pCBSSN>2.75</pCBSSN><vCBSSN>27.50</vCBSSN></gCBSSN></gTribSN>"
                + "</NFNotaInfoItemImpostoIBSCBS>", ibsCbsComTribSN(tribSN).toString());
    }

    @Test
    public void naoDeveGerarGTribSNQuandoNaoInformado() {
        final String xml = ibsCbsComTribSN(null).toString();
        Assertions.assertFalse(xml.contains("gTribSN"), xml);
        final NFNotaInfoIBSCBSTot tot = new NFNotaInfoIBSCBSTot();
        tot.setVBCIBSCBS(BigDecimal.TEN);
        Assertions.assertFalse(tot.toString().contains("gTribSN"), tot.toString());
    }

    @Test
    public void deveGerarGTribSNDepoisDoAjusteCompetenciaEAntesDoEstornoCredito() {
        final NFNotaInfoItemImpostoIBSCBS ibsCbs = ibsCbsComTribSN(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIBSCBSTribSN());
        final NFNotaInfoIBSCBSGrupoEstornoCredito estorno = new NFNotaInfoIBSCBSGrupoEstornoCredito();
        estorno.setValorIbsEstornado(BigDecimal.ONE);
        estorno.setValorCbsEstornado(BigDecimal.ONE);
        ibsCbs.setGrupoEstornoCredito(estorno);
        final NFNotaInfoItemImpostoIBSCBS.GrupoAjusteCompetencia ajuste = new NFNotaInfoItemImpostoIBSCBS.GrupoAjusteCompetencia();
        ajuste.setDataCompetenciaApuracao(YearMonth.of(2027, 1));
        ajuste.setValorIBS(BigDecimal.ONE);
        ajuste.setValorCBS(BigDecimal.ONE);
        ibsCbs.setGrupoAjusteCompetencia(ajuste);

        final String xml = ibsCbs.toString();
        Assertions.assertTrue(xml.indexOf("<gAjusteCompet") < xml.indexOf("<gTribSN>"), xml);
        Assertions.assertTrue(xml.indexOf("<gTribSN>") < xml.indexOf("<gEstornoCred"), xml);
    }

    @Test
    public void deveGerarXmlDoTotalSimplesNacional() {
        final NFNotaInfoIBSCBSTot ibsCbsTot = new NFNotaInfoIBSCBSTot();
        ibsCbsTot.setVBCIBSCBS(new BigDecimal("1000.00"));
        ibsCbsTot.setGrupoTributacaoSimplesNacional(FabricaDeObjetosFake.getNFNotaInfoIBSCBSTotTribSN());

        Assertions.assertEquals("<NFNotaInfoIBSCBSTot><vBCIBSCBS>1000.00</vBCIBSCBS>"
                + "<gTribSN><vIBSSN>12.50</vIBSSN><vCBSSN>27.50</vCBSSN></gTribSN>"
                + "</NFNotaInfoIBSCBSTot>", ibsCbsTot.toString());
    }

    @Test
    public void naoDevePermitirAliquotasForaDoTipoTDec0302a04RTC() {
        final NFNotaInfoItemImpostoIBSCBSTribSN.GIBSSN ibs = new NFNotaInfoItemImpostoIBSCBSTribSN.GIBSSN();
        final NFNotaInfoItemImpostoIBSCBSTribSN.GCBSSN cbs = new NFNotaInfoItemImpostoIBSCBSTribSN.GCBSSN();
        // limite: 3 inteiros e ate 4 casas decimais
        ibs.setPIBSSN(new BigDecimal("999.9999"));
        cbs.setPCBSSN(new BigDecimal("999.9999"));
        Assertions.assertEquals("999.9999", ibs.getPIBSSN());
        Assertions.assertEquals("999.9999", cbs.getPCBSSN());
        Assertions.assertThrows(NumberFormatException.class, () -> ibs.setPIBSSN(new BigDecimal("1000.00")));
        Assertions.assertThrows(NumberFormatException.class, () -> cbs.setPCBSSN(new BigDecimal("1000.00")));
        Assertions.assertThrows(NumberFormatException.class, () -> ibs.setPIBSSN(new BigDecimal("1.12345")));
        Assertions.assertThrows(NumberFormatException.class, () -> cbs.setPCBSSN(new BigDecimal("1.12345")));
        Assertions.assertThrows(NumberFormatException.class, () -> ibs.setPIBSSN(new BigDecimal("-1.00")));
        Assertions.assertThrows(NumberFormatException.class, () -> cbs.setPCBSSN(new BigDecimal("-1.00")));
    }

    @Test
    public void naoDevePermitirValoresForaDoTipoTDec1302RTC() {
        final NFNotaInfoItemImpostoIBSCBSTribSN.GIBSSN ibs = new NFNotaInfoItemImpostoIBSCBSTribSN.GIBSSN();
        final NFNotaInfoItemImpostoIBSCBSTribSN.GCBSSN cbs = new NFNotaInfoItemImpostoIBSCBSTribSN.GCBSSN();
        final NFNotaInfoIBSCBSTot.GTribSN tot = new NFNotaInfoIBSCBSTot.GTribSN();
        // limite: 13 inteiros e 2 casas decimais
        final BigDecimal maximo = new BigDecimal("9999999999999.99");
        ibs.setVIBSSN(maximo);
        cbs.setVCBSSN(maximo);
        tot.setVIBSSN(maximo);
        tot.setVCBSSN(maximo);
        Assertions.assertEquals("9999999999999.99", tot.getVCBSSN());
        for (final String invalido : new String[]{"10000000000000.00", "1.123", "-1.00"}) {
            final BigDecimal valor = new BigDecimal(invalido);
            Assertions.assertThrows(NumberFormatException.class, () -> ibs.setVIBSSN(valor), invalido);
            Assertions.assertThrows(NumberFormatException.class, () -> cbs.setVCBSSN(valor), invalido);
            Assertions.assertThrows(NumberFormatException.class, () -> tot.setVIBSSN(valor), invalido);
            Assertions.assertThrows(NumberFormatException.class, () -> tot.setVCBSSN(valor), invalido);
        }
    }

    @Test
    public void deveGerarCAtivSNDepoisDoIndicadorBemMovelUsado() {
        final NFNotaInfoItemProduto produto = FabricaDeObjetosFake.getNFNotaInfoItemProduto();
        produto.setIndicadorBemMovelUsado("1");
        produto.setCodigoAtividadeSimplesNacional(NFCodigoAtividadeSimplesNacional.OPERACOES_NAO_TRIBUTAVEIS);
        final String xml = produto.toString();
        Assertions.assertTrue(xml.contains("<indBemMovelUsado>1</indBemMovelUsado><cAtivSN>90</cAtivSN>"), xml);
    }

    @Test
    public void deveGerarTpRegimeIBSCBSDepoisDoCRT() {
        final NFNotaInfoEmitente emitente = FabricaDeObjetosFake.getNFNotaInfoEmitente();
        emitente.setRegimeTributario(NFRegimeTributario.NORMAL);
        emitente.setTipoRegimeIBSCBS(NFTipoRegimeIBSCBS.NORMAL_OPCAO_PENDENTE_SIMPLES_NACIONAL_REGIME_REGULAR);
        Assertions.assertTrue(emitente.toString().endsWith("<CRT>3</CRT><tpRegimeIBSCBS>4</tpRegimeIBSCBS></NFNotaInfoEmitente>"), emitente.toString());
    }

    @Test
    public void naoDeveGerarTpRegimeIBSCBSNemCAtivSNQuandoNaoInformados() {
        Assertions.assertFalse(FabricaDeObjetosFake.getNFNotaInfoEmitente().toString().contains("tpRegimeIBSCBS"));
        Assertions.assertFalse(FabricaDeObjetosFake.getNFNotaInfoItemProduto().toString().contains("cAtivSN"));
    }
}

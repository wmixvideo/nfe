package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class NFNotaInfoCanaTest {

    @Test
    public void devePermitirListaDeducoesVazia() {
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setSafra("2014");
        infoCana.setReferencia("06/2013");
        infoCana.setValorFornecimento(new BigDecimal("900"));
        infoCana.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCana.setValorTotalDeducao(new BigDecimal("2000.70"));
        infoCana.setQuantidadeTotalAnterior(new BigDecimal("10"));
        infoCana.setQuantidadeTotalGeral(new BigDecimal("80"));
        infoCana.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirListaFornecimentoDiarioVazio() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<>());
        infoCana.setSafra("2014");
        infoCana.setReferencia("06/2013");
        infoCana.setValorFornecimento(new BigDecimal("900"));
        infoCana.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCana.setValorTotalDeducao(new BigDecimal("2000.70"));
        infoCana.setQuantidadeTotalAnterior(new BigDecimal("10"));
        infoCana.setQuantidadeTotalGeral(new BigDecimal("80"));
        infoCana.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSafraNulo() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setReferencia("06/2013");
        infoCana.setValorFornecimento(new BigDecimal("900"));
        infoCana.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCana.setValorTotalDeducao(new BigDecimal("2000.70"));
        infoCana.setQuantidadeTotalAnterior(new BigDecimal("10"));
        infoCana.setQuantidadeTotalGeral(new BigDecimal("80"));
        infoCana.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirReferenciaNulo() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setSafra("2013/2014");
        infoCana.setValorFornecimento(new BigDecimal("900"));
        infoCana.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCana.setValorTotalDeducao(new BigDecimal("2000.70"));
        infoCana.setQuantidadeTotalAnterior(new BigDecimal("10"));
        infoCana.setQuantidadeTotalGeral(new BigDecimal("80"));
        infoCana.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTotalDeducaoNulo() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setSafra("2013/2014");
        infoCana.setValorFornecimento(new BigDecimal("900"));
        infoCana.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCana.setQuantidadeTotalAnterior(new BigDecimal("10"));
        infoCana.setQuantidadeTotalGeral(new BigDecimal("80"));
        infoCana.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLiquidoFornecimentoNulo() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setSafra("2013/2014");
        infoCana.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        infoCana.setValorFornecimento(new BigDecimal("900"));
        infoCana.setValorTotalDeducao(new BigDecimal("2000.70"));
        infoCana.setQuantidadeTotalAnterior(new BigDecimal("10"));
        infoCana.setQuantidadeTotalGeral(new BigDecimal("80"));
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFornecimentoNulo() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setSafra("2013/2014");
        infoCana.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        infoCana.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCana.setValorTotalDeducao(new BigDecimal("2000.70"));
        infoCana.setQuantidadeTotalAnterior(new BigDecimal("10"));
        infoCana.setQuantidadeTotalGeral(new BigDecimal("80"));
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalAnteriorNulo() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setSafra("2013/2014");
        infoCana.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        infoCana.setValorFornecimento(new BigDecimal("900"));
        infoCana.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCana.setValorTotalDeducao(new BigDecimal("2000.70"));
        infoCana.setQuantidadeTotalGeral(new BigDecimal("80"));
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalGeralNulo() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setSafra("2013/2014");
        infoCana.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        infoCana.setValorFornecimento(new BigDecimal("900"));
        infoCana.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCana.setValorTotalDeducao(new BigDecimal("2000.70"));
        infoCana.setQuantidadeTotalAnterior(new BigDecimal("10"));
        infoCana.toString();

    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalMesNulo() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setSafra("2013/2014");
        infoCana.setValorFornecimento(new BigDecimal("900"));
        infoCana.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCana.setValorTotalDeducao(new BigDecimal("2000.70"));
        infoCana.setQuantidadeTotalAnterior(new BigDecimal("10"));
        infoCana.setQuantidadeTotalGeral(new BigDecimal("80"));
        infoCana.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSafraDeFormatoDiferente() {
        new NFNotaInfoCana().setSafra("2014-2015");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSafraComTamanhoDiferenteQue9() {
        try {
            new NFNotaInfoCana().setSafra("2013/201");
            Assert.fail("Validacao da safra falhou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoCana().setSafra("2013/20140");
        }
        Assert.fail("Validacao da safra falhou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSafraComTamanhoDiferenteQue4() {
        try {
            new NFNotaInfoCana().setSafra("201");
            Assert.fail("Validacao da safra falhou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoCana().setSafra("2014/");
        }
        Assert.fail("Validacao da safra falhou");
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCana><safra>2013/2014</safra><ref>06/2013</ref><forDia dia=\"15\"><qtde>3</qtde></forDia><qTotMes>30.0000001</qTotMes><qTotAnt>10</qTotAnt><qTotGer>80</qTotGer><vFor>900.00</vFor><vTotDed>2000.70</vTotDed><vLiqFor>980.00</vLiqFor></NFNotaInfoCana>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCana().toString());
    }

}
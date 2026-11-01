package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    public void naoDevePermitirListaFornecimentoDiarioVazio() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirSafraNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirReferenciaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirTotalDeducaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirLiquidoFornecimentoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirFornecimentoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirQtdTotalAnteriorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirQtdTotalGeralNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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

        });
    }

    @Test
    public void naoDevePermitirQtdTotalMesNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        });
    }

    @Test
    public void naoDevePermitirSafraDeFormatoDiferente() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoCana().setSafra("2014-2015"));
    }

    @Test
    public void naoDevePermitirSafraComTamanhoDiferenteQue9() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoCana().setSafra("2013/201");
                Assertions.fail("Validacao da safra falhou");
            } catch (final IllegalStateException e) {
                new NFNotaInfoCana().setSafra("2013/20140");
            }
            Assertions.fail("Validacao da safra falhou");
        });
    }

    @Test
    public void naoDevePermitirSafraComTamanhoDiferenteQue4() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoCana().setSafra("201");
                Assertions.fail("Validacao da safra falhou");
            } catch (final IllegalStateException e) {
                new NFNotaInfoCana().setSafra("2014/");
            }
            Assertions.fail("Validacao da safra falhou");
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCana><safra>2013/2014</safra><ref>06/2013</ref><forDia dia=\"15\"><qtde>3</qtde></forDia><qTotMes>30.0000001</qTotMes><qTotAnt>10</qTotAnt><qTotGer>80</qTotGer><vFor>900.00</vFor><vTotDed>2000.70</vTotDed><vLiqFor>980.00</vLiqFor></NFNotaInfoCana>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCana().toString());
    }

}
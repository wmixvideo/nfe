package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoSituacaoTributariaIPI;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoIPITributadoTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorlTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIPITributado().setValorTributo(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIPITributado().setPercentualAliquota(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIPITributado().setValorBaseCalculo(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeComTamanhoInvalido() {
        new NFNotaInfoItemImpostoIPITributado().setQuantidade(new BigDecimal("9999999999999"));
    }

    @Test
    public void naoDevePermitirSetarQuantidadeCasoPercentualAliquotaOuValorBaseCalculoEstejaSetado() {
        final NFNotaInfoItemImpostoIPITributado impostoTributado1 = new NFNotaInfoItemImpostoIPITributado();
        impostoTributado1.setPercentualAliquota(BigDecimal.ONE);
        try {
            impostoTributado1.setQuantidade(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar valor base calculo se quantidade foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoIPITributado impostoIPITributado2 = new NFNotaInfoItemImpostoIPITributado();
        impostoIPITributado2.setValorBaseCalculo(BigDecimal.ONE);
        try {
            impostoIPITributado2.setQuantidade(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar valor base calculo se valor unidade tributavel foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarValorUnidadeTributavelCasoPercentualAliquotaOuValorBaseCalculoEstejaSetado() {
        final NFNotaInfoItemImpostoIPITributado impostoTributado1 = new NFNotaInfoItemImpostoIPITributado();
        impostoTributado1.setPercentualAliquota(BigDecimal.ONE);
        try {
            impostoTributado1.setValorUnidadeTributavel(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar valor base calculo se quantidade foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoIPITributado impostoIPITributado2 = new NFNotaInfoItemImpostoIPITributado();
        impostoIPITributado2.setValorBaseCalculo(BigDecimal.ONE);
        try {
            impostoIPITributado2.setValorUnidadeTributavel(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar valor base calculo se valor unidade tributavel foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarPercentualAliquotaCasoQuantidadeOuValorUnidadeTributavelEstejaSetado() {
        final NFNotaInfoItemImpostoIPITributado impostoTributado1 = new NFNotaInfoItemImpostoIPITributado();
        impostoTributado1.setQuantidade(BigDecimal.ONE);
        try {
            impostoTributado1.setPercentualAliquota(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar valor base calculo se quantidade foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoIPITributado impostoIPITributado2 = new NFNotaInfoItemImpostoIPITributado();
        impostoIPITributado2.setValorUnidadeTributavel(BigDecimal.ONE);
        try {
            impostoIPITributado2.setPercentualAliquota(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar valor base calculo se valor unidade tributavel foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarValorBaseCalculoCasoQuantidadeOuValorUnidadeTributavelEstejaSetado() {
        final NFNotaInfoItemImpostoIPITributado impostoTributado1 = new NFNotaInfoItemImpostoIPITributado();
        impostoTributado1.setQuantidade(BigDecimal.ONE);
        try {
            impostoTributado1.setValorBaseCalculo(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar valor base calculo se quantidade foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoIPITributado impostoIPITributado2 = new NFNotaInfoItemImpostoIPITributado();
        impostoIPITributado2.setValorUnidadeTributavel(BigDecimal.ONE);
        try {
            impostoIPITributado2.setValorBaseCalculo(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar valor base calculo se valor unidade tributavel foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoQuantidadeValorUnidadeTributavel() {
        final NFNotaInfoItemImpostoIPITributado ipiTributado = new NFNotaInfoItemImpostoIPITributado();
        ipiTributado.setSituacaoTributaria(NFNotaInfoSituacaoTributariaIPI.OUTRAS_ENTRADAS);
        ipiTributado.setQuantidade(new BigDecimal("99999999999.9999"));
        ipiTributado.setValorUnidadeTributavel(new BigDecimal("9999999999.9999"));
        ipiTributado.setValorTributo(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoIPITributado><CST>49</CST><qUnid>99999999999.9999</qUnid><vUnid>9999999999.9999</vUnid><vIPI>999999999999.99</vIPI></NFNotaInfoItemImpostoIPITributado>";
        Assert.assertEquals(xmlEsperado, ipiTributado.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoPercentualAliquotaBaseCalculo() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIPITributado><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></NFNotaInfoItemImpostoIPITributado>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado().toString());
    }
}
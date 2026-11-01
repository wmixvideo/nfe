package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaIPI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoIPITributadoTest {

    @Test
    public void naoDevePermitirValorlTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIPITributado().setValorTributo(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIPITributado().setPercentualAliquota(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIPITributado().setValorBaseCalculo(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirQuantidadeComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIPITributado().setQuantidade(new BigDecimal("9999999999999")));
    }

    @Test
    public void naoDevePermitirSetarQuantidadeCasoPercentualAliquotaOuValorBaseCalculoEstejaSetado() {
        final NFNotaInfoItemImpostoIPITributado impostoTributado1 = new NFNotaInfoItemImpostoIPITributado();
        impostoTributado1.setPercentualAliquota(BigDecimal.ONE);
        try {
            impostoTributado1.setQuantidade(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar valor base calculo se quantidade foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoIPITributado impostoIPITributado2 = new NFNotaInfoItemImpostoIPITributado();
        impostoIPITributado2.setValorBaseCalculo(BigDecimal.ONE);
        try {
            impostoIPITributado2.setQuantidade(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar valor base calculo se valor unidade tributavel foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarValorUnidadeTributavelCasoPercentualAliquotaOuValorBaseCalculoEstejaSetado() {
        final NFNotaInfoItemImpostoIPITributado impostoTributado1 = new NFNotaInfoItemImpostoIPITributado();
        impostoTributado1.setPercentualAliquota(BigDecimal.ONE);
        try {
            impostoTributado1.setValorUnidadeTributavel(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar valor base calculo se quantidade foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoIPITributado impostoIPITributado2 = new NFNotaInfoItemImpostoIPITributado();
        impostoIPITributado2.setValorBaseCalculo(BigDecimal.ONE);
        try {
            impostoIPITributado2.setValorUnidadeTributavel(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar valor base calculo se valor unidade tributavel foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarPercentualAliquotaCasoQuantidadeOuValorUnidadeTributavelEstejaSetado() {
        final NFNotaInfoItemImpostoIPITributado impostoTributado1 = new NFNotaInfoItemImpostoIPITributado();
        impostoTributado1.setQuantidade(BigDecimal.ONE);
        try {
            impostoTributado1.setPercentualAliquota(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar valor base calculo se quantidade foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoIPITributado impostoIPITributado2 = new NFNotaInfoItemImpostoIPITributado();
        impostoIPITributado2.setValorUnidadeTributavel(BigDecimal.ONE);
        try {
            impostoIPITributado2.setPercentualAliquota(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar valor base calculo se valor unidade tributavel foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarValorBaseCalculoCasoQuantidadeOuValorUnidadeTributavelEstejaSetado() {
        final NFNotaInfoItemImpostoIPITributado impostoTributado1 = new NFNotaInfoItemImpostoIPITributado();
        impostoTributado1.setQuantidade(BigDecimal.ONE);
        try {
            impostoTributado1.setValorBaseCalculo(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar valor base calculo se quantidade foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoIPITributado impostoIPITributado2 = new NFNotaInfoItemImpostoIPITributado();
        impostoIPITributado2.setValorUnidadeTributavel(BigDecimal.ONE);
        try {
            impostoIPITributado2.setValorBaseCalculo(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar valor base calculo se valor unidade tributavel foi setado");
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
        Assertions.assertEquals(xmlEsperado, ipiTributado.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoPercentualAliquotaBaseCalculo() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIPITributado><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></NFNotaInfoItemImpostoIPITributado>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado().toString());
    }
}
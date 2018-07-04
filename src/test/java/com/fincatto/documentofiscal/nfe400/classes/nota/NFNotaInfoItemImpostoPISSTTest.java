package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoPISSTTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorlTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISST().setValorTributo(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorlAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISST().setValorAliquota(new BigDecimal("999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISST().setPercentualAliquota(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISST().setValorBaseCalculo(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeVendidaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISST().setQuantidadeVendida(new BigDecimal("9999999999999"));
    }

    @Test
    public void naoDevePermitirSetarQuantidadeVendidaCasoPercentualAliquotaOuValorBaseCalculoEstejaSetado() {
        final NFNotaInfoItemImpostoPISST impostoPISST1 = new NFNotaInfoItemImpostoPISST();
        impostoPISST1.setValorBaseCalculo(BigDecimal.ONE);
        try {
            impostoPISST1.setQuantidadeVendida(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar percentual aliquota se valor aliquota foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoPISST impostoPISST2 = new NFNotaInfoItemImpostoPISST();
        impostoPISST2.setPercentualAliquota(BigDecimal.ONE);
        try {
            impostoPISST2.setQuantidadeVendida(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar percentual aliquota se quantidade vendida foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarValorBaseCalculoCasoValorAliquotaOuQuantidadeVendidaEstejaSetado() {
        final NFNotaInfoItemImpostoPISST impostoPISST1 = new NFNotaInfoItemImpostoPISST();
        impostoPISST1.setQuantidadeVendida(BigDecimal.ONE);
        try {
            impostoPISST1.setValorBaseCalculo(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar percentual aliquota se valor aliquota foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoPISST impostoPISST2 = new NFNotaInfoItemImpostoPISST();
        impostoPISST2.setValorAliquota(BigDecimal.ONE);
        try {
            impostoPISST2.setValorBaseCalculo(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar percentual aliquota se quantidade vendida foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarValorAliquotaCasoPercentualAliquotaOuValorBaseCalculoEstejaSetado() {
        final NFNotaInfoItemImpostoPISST impostoPISST1 = new NFNotaInfoItemImpostoPISST();
        impostoPISST1.setPercentualAliquota(BigDecimal.ONE);
        try {
            impostoPISST1.setValorAliquota(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar percentual aliquota se valor aliquota foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoPISST impostoPISST2 = new NFNotaInfoItemImpostoPISST();
        impostoPISST2.setValorBaseCalculo(BigDecimal.ONE);
        try {
            impostoPISST2.setValorAliquota(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar percentual aliquota se quantidade vendida foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarPercentualAliquotaCasoValorAliquotaOuQuantidadeVendidaEstejaSetado() {
        final NFNotaInfoItemImpostoPISST impostoPISST1 = new NFNotaInfoItemImpostoPISST();
        impostoPISST1.setValorAliquota(BigDecimal.ONE);
        try {
            impostoPISST1.setPercentualAliquota(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar percentual aliquota se valor aliquota foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoPISST impostoPISST2 = new NFNotaInfoItemImpostoPISST();
        impostoPISST2.setQuantidadeVendida(BigDecimal.ONE);
        try {
            impostoPISST2.setPercentualAliquota(BigDecimal.ONE);
            Assert.fail("Nao deve permitir setar percentual aliquota se quantidade vendida foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoBCAliquotaPercentual() {
        final NFNotaInfoItemImpostoPISST impostoPISST = new NFNotaInfoItemImpostoPISST();
        impostoPISST.setPercentualAliquota(new BigDecimal("99.99"));
        impostoPISST.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoPISST.setValorTributo(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoPISST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></NFNotaInfoItemImpostoPISST>";
        Assert.assertEquals(xmlEsperado, impostoPISST.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoQuantidadeVendaAliquota() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPISST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></NFNotaInfoItemImpostoPISST>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISST().toString());
    }
}
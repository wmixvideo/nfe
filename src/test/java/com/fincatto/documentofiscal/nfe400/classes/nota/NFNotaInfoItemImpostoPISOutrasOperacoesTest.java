package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoSituacaoTributariaPIS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoPISOutrasOperacoesTest {

    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoPISOutrasOperacoes pisOutrasOperacoes = new NFNotaInfoItemImpostoPISOutrasOperacoes();
            pisOutrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
            pisOutrasOperacoes.setValorAliquota(new BigDecimal("9999999999.9999"));
            pisOutrasOperacoes.setValorTributo(new BigDecimal("999999999999.99"));
            pisOutrasOperacoes.toString();
        });
    }

    @Test
    public void naoDevePermitirValorlTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISOutrasOperacoes().setValorTributo(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirValorlAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISOutrasOperacoes().setValorAliquota(new BigDecimal("999999999999")));
    }

    @Test
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISOutrasOperacoes().setPercentualAliquota(new BigDecimal("9999")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISOutrasOperacoes().setValorBaseCalculo(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirQuantidadeVendidaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISOutrasOperacoes().setQuantidadeVendida(new BigDecimal("9999999999999")));
    }

    @Test
    public void naoDevePermitirSetarQuantidadeVendidaCasoPercentualAliquotaOuValorBaseCalculoEstejaSetado() {
        final NFNotaInfoItemImpostoPISOutrasOperacoes impostoOutrasOperacoes1 = new NFNotaInfoItemImpostoPISOutrasOperacoes();
        impostoOutrasOperacoes1.setValorBaseCalculo(BigDecimal.ONE);
        try {
            impostoOutrasOperacoes1.setQuantidadeVendida(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar percentual aliquota se valor aliquota foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoPISOutrasOperacoes impostoOutrasOperacoes2 = new NFNotaInfoItemImpostoPISOutrasOperacoes();
        impostoOutrasOperacoes2.setPercentualAliquota(BigDecimal.ONE);
        try {
            impostoOutrasOperacoes2.setQuantidadeVendida(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar percentual aliquota se quantidade vendida foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarValorBaseCalculoCasoValorAliquotaOuQuantidadeVendidaEstejaSetado() {
        final NFNotaInfoItemImpostoPISOutrasOperacoes impostoOutrasOperacoes1 = new NFNotaInfoItemImpostoPISOutrasOperacoes();
        impostoOutrasOperacoes1.setQuantidadeVendida(BigDecimal.ONE);
        try {
            impostoOutrasOperacoes1.setValorBaseCalculo(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar percentual aliquota se valor aliquota foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoPISOutrasOperacoes impostoOutrasOperacoes2 = new NFNotaInfoItemImpostoPISOutrasOperacoes();
        impostoOutrasOperacoes2.setValorAliquota(BigDecimal.ONE);
        try {
            impostoOutrasOperacoes2.setValorBaseCalculo(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar percentual aliquota se quantidade vendida foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarValorAliquotaCasoPercentualAliquotaOuValorBaseCalculoEstejaSetado() {
        final NFNotaInfoItemImpostoPISOutrasOperacoes impostoOutrasOperacoes1 = new NFNotaInfoItemImpostoPISOutrasOperacoes();
        impostoOutrasOperacoes1.setPercentualAliquota(BigDecimal.ONE);
        try {
            impostoOutrasOperacoes1.setValorAliquota(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar percentual aliquota se valor aliquota foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoPISOutrasOperacoes impostoOutrasOperacoes2 = new NFNotaInfoItemImpostoPISOutrasOperacoes();
        impostoOutrasOperacoes2.setValorBaseCalculo(BigDecimal.ONE);
        try {
            impostoOutrasOperacoes2.setValorAliquota(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar percentual aliquota se quantidade vendida foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void naoDevePermitirSetarPercentualAliquotaCasoValorAliquotaOuQuantidadeVendidaEstejaSetado() {
        final NFNotaInfoItemImpostoPISOutrasOperacoes impostoOutrasOperacoes1 = new NFNotaInfoItemImpostoPISOutrasOperacoes();
        impostoOutrasOperacoes1.setValorAliquota(BigDecimal.ONE);
        try {
            impostoOutrasOperacoes1.setPercentualAliquota(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar percentual aliquota se valor aliquota foi setado");
        } catch (final IllegalStateException ignored) {
        }

        final NFNotaInfoItemImpostoPISOutrasOperacoes impostoOutrasOperacoes2 = new NFNotaInfoItemImpostoPISOutrasOperacoes();
        impostoOutrasOperacoes2.setQuantidadeVendida(BigDecimal.ONE);
        try {
            impostoOutrasOperacoes2.setPercentualAliquota(BigDecimal.ONE);
            Assertions.fail("Nao deve permitir setar percentual aliquota se quantidade vendida foi setado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoBCAliquotaPercentual() {
        final NFNotaInfoItemImpostoPISOutrasOperacoes pisOutrasOperacoes = new NFNotaInfoItemImpostoPISOutrasOperacoes();
        pisOutrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CST_49);
        pisOutrasOperacoes.setPercentualAliquota(new BigDecimal("99.99"));
        pisOutrasOperacoes.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        pisOutrasOperacoes.setValorTributo(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoPISOutrasOperacoes><CST>49</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></NFNotaInfoItemImpostoPISOutrasOperacoes>";
        Assertions.assertEquals(xmlEsperado, pisOutrasOperacoes.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoQuantidadeVendaAliquota() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPISOutrasOperacoes><CST>49</CST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></NFNotaInfoItemImpostoPISOutrasOperacoes>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISOutrasOperacoes().toString());
    }
}
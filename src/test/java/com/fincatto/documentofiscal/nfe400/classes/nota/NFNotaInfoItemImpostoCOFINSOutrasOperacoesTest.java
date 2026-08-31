package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoSituacaoTributariaCOFINS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoCOFINSOutrasOperacoesTest {

    @Test
    public void naoDevePermitirPercentualCOFINSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSOutrasOperacoes().setPercentualCOFINS(new BigDecimal("999999")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSOutrasOperacoes().setValorBaseCalculo(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirQuantidadeVendidaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSOutrasOperacoes().setQuantidadeVendida(new BigDecimal("9999999999999")));
    }

    @Test
    public void naoDevePermitirValorCOFINSComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSOutrasOperacoes().setValorCOFINS(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirValorAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoCOFINSOutrasOperacoes().setValorAliquota(new BigDecimal("999999999999")));
    }

    @Test
    public void devePermitirPercentualCOFINSNulo() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CST_49);
        outrasOperacoes.setValorAliquota(new BigDecimal("99999999999"));
        outrasOperacoes.setValorBaseCalculo(new BigDecimal("99999999999"));
        outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
        outrasOperacoes.toString();
    }

    @Test
    public void devePermitirQuantidadeVendidaNulo() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CST_49);
        outrasOperacoes.setValorAliquota(new BigDecimal("99999999999"));
        outrasOperacoes.setValorBaseCalculo(new BigDecimal("99999999999"));
        outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
        outrasOperacoes.toString();
    }

    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
            outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
            outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
            outrasOperacoes.setValorAliquota(new BigDecimal("99999999999"));
            outrasOperacoes.setValorBaseCalculo(new BigDecimal("99999999999"));
            outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
            outrasOperacoes.toString();
        });
    }

    @Test
    public void devePermitirValorAliquotaNulo() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
        outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CST_49);
        outrasOperacoes.setValorBaseCalculo(new BigDecimal("999999999999"));
        outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
        outrasOperacoes.toString();
    }

    @Test
    public void devePermitirBaseCalculoNulo() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
        outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CST_49);
        outrasOperacoes.setValorAliquota(new BigDecimal("99999999999"));
        outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
        outrasOperacoes.toString();
    }

    @Test
    public void naoDevePermitirValorCOFINS() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
        outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CST_49);
        outrasOperacoes.setValorAliquota(new BigDecimal("99999999999"));
        outrasOperacoes.setValorBaseCalculo(new BigDecimal("9999999999999"));
        outrasOperacoes.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSOutrasOperacoes><CST>49</CST><vBC>999999999999.00</vBC><pCOFINS>99.99</pCOFINS><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.0000</vAliqProd><vCOFINS>999999999999.00</vCOFINS></NFNotaInfoItemImpostoCOFINSOutrasOperacoes>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes().toString());
    }
}
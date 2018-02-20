package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoSituacaoTributariaCOFINS;

public class NFNotaInfoItemImpostoCOFINSOutrasOperacoesTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualCOFINSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSOutrasOperacoes().setPercentualCOFINS(new BigDecimal("999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSOutrasOperacoes().setValorBaseCalculo(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeVendidaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSOutrasOperacoes().setQuantidadeVendida(new BigDecimal("9999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorCOFINSComTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSOutrasOperacoes().setValorCOFINS(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSOutrasOperacoes().setValorAliquota(new BigDecimal("999999999999"));
    }

    @Test
    public void devePermitirPercentualCOFINSNulo() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.OUTRAS_OPERACOES_SAIDA);
        outrasOperacoes.setValorAliquota(new BigDecimal("99999999999"));
        outrasOperacoes.setValorBaseCalculo(new BigDecimal("99999999999"));
        outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
        outrasOperacoes.toString();
    }

    @Test
    public void devePermitirQuantidadeVendidaNulo() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.OUTRAS_OPERACOES_SAIDA);
        outrasOperacoes.setValorAliquota(new BigDecimal("99999999999"));
        outrasOperacoes.setValorBaseCalculo(new BigDecimal("99999999999"));
        outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
        outrasOperacoes.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
        outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        outrasOperacoes.setValorAliquota(new BigDecimal("99999999999"));
        outrasOperacoes.setValorBaseCalculo(new BigDecimal("99999999999"));
        outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
        outrasOperacoes.toString();
    }

    @Test
    public void devePermitirValorAliquotaNulo() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
        outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.OUTRAS_OPERACOES_SAIDA);
        outrasOperacoes.setValorBaseCalculo(new BigDecimal("999999999999"));
        outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
        outrasOperacoes.toString();
    }

    @Test
    public void devePermitirBaseCalculoNulo() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
        outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.OUTRAS_OPERACOES_SAIDA);
        outrasOperacoes.setValorAliquota(new BigDecimal("99999999999"));
        outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
        outrasOperacoes.toString();
    }

    @Test
    public void naoDevePermitirValorCOFINS() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
        outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.OUTRAS_OPERACOES_SAIDA);
        outrasOperacoes.setValorAliquota(new BigDecimal("99999999999"));
        outrasOperacoes.setValorBaseCalculo(new BigDecimal("9999999999999"));
        outrasOperacoes.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSOutrasOperacoes><CST>49</CST><vBC>999999999999.00</vBC><pCOFINS>99.99</pCOFINS><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.0000</vAliqProd><vCOFINS>999999999999.00</vCOFINS></NFNotaInfoItemImpostoCOFINSOutrasOperacoes>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes().toString());
    }
}
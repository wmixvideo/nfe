package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;
import com.fincatto.nfe200.classes.NFNotaInfoImpostoTributacaoISSQN;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemImpostoISSQN;

public class NFNotaInfoItemImpostoISSQNTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirItemListaServicosComTamanhoInvalido() {
        try {
            new NFNotaInfoItemImpostoISSQN().setItemListaServicos(99);
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemImpostoISSQN().setItemListaServicos(10000);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoMunicipioComTamanhoInvalido() {
        try {
            new NFNotaInfoItemImpostoISSQN().setCodigoMunicipio(999999);
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemImpostoISSQN().setCodigoMunicipio(10000000);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAliquotaISSQNComTamanhoNulo() {
        new NFNotaInfoItemImpostoISSQN().setValorAliquota(new BigDecimal("100000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoISSQN().setValorBaseCalculo(new BigDecimal("1000000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorComTamanhoInvalido() {
        new NFNotaInfoItemImpostoISSQN().setValor(new BigDecimal("1000000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoMunicipioNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoTributacao(NFNotaInfoImpostoTributacaoISSQN.ISENTA);
        impostoISSQN.setItemListaServicos(9999);
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoTributacaoNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setItemListaServicos(4001);
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirItemListaServicosNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setCodigoTributacao(NFNotaInfoImpostoTributacaoISSQN.ISENTA);
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setCodigoTributacao(NFNotaInfoImpostoTributacaoISSQN.ISENTA);
        impostoISSQN.setItemListaServicos(4001);
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorAliquotaNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setCodigoTributacao(NFNotaInfoImpostoTributacaoISSQN.ISENTA);
        impostoISSQN.setItemListaServicos(4001);
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        impostoISSQN.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBaseCalculoNulo() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setCodigoTributacao(NFNotaInfoImpostoTributacaoISSQN.ISENTA);
        impostoISSQN.setItemListaServicos(4001);
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoISSQN><vBC>999999999999.99</vBC><vAliq>99.99</vAliq><vISSQN>999999999999.99</vISSQN><cMunFG>9999999</cMunFG><cListServ>2501</cListServ><cSitTrib>I</cSitTrib></NFNotaInfoItemImpostoISSQN>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoISSQN().toString());
    }
}
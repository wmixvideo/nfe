package com.fincatto.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFakeNFe;
import com.fincatto.nfe310.classes.nota.NFNotaInfoItemImpostoCOFINS;

public class NFNotaInfoItemImpostoCOFINSTest {

    @Test
    public void devePermitirApenasUmQuantidade() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setQuantidade(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSQuantidade());
        try {
            cofins.setAliquota(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSAliquota());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            cofins.setNaoTributavel(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            cofins.setOutrasOperacoes(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void devePermitirApenasUmAliquota() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setAliquota(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSAliquota());
        try {
            cofins.setQuantidade(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSQuantidade());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            cofins.setNaoTributavel(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            cofins.setOutrasOperacoes(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void devePermitirApenasUmNaoTributavel() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setNaoTributavel(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
        try {
            cofins.setQuantidade(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSQuantidade());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            cofins.setAliquota(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSAliquota());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            cofins.setOutrasOperacoes(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void devePermitirApenasUmOutrasOperacoes() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setNaoTributavel(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
        try {
            cofins.setQuantidade(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSQuantidade());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            cofins.setAliquota(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSAliquota());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            cofins.setOutrasOperacoes(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINS><COFINSAliq><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></COFINSAliq></NFNotaInfoItemImpostoCOFINS>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoCOFINS().toString());
    }
}
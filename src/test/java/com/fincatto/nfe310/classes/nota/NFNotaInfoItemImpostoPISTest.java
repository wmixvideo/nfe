package com.fincatto.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFakeNFe;
import com.fincatto.nfe310.classes.nota.NFNotaInfoItemImpostoPIS;

public class NFNotaInfoItemImpostoPISTest {

    @Test
    public void devePermitirApenasUmAliquota() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setAliquota(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISAliquota());

        try {
            pis.setNaoTributado(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISNaoTributado());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            pis.setOutrasOperacoes(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISOutrasOperacoes());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            pis.setQuantidade(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISQuantidade());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void devePermitirApenasUmNaoTributado() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setNaoTributado(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISNaoTributado());

        try {
            pis.setAliquota(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISAliquota());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            pis.setOutrasOperacoes(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISOutrasOperacoes());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            pis.setQuantidade(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISQuantidade());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void devePermitirApenasUmOutrasOperacoes() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setOutrasOperacoes(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISOutrasOperacoes());

        try {
            pis.setAliquota(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISAliquota());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            pis.setNaoTributado(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISNaoTributado());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            pis.setQuantidade(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISQuantidade());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void devePermitirApenasUmQuantidade() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setQuantidade(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISQuantidade());

        try {
            pis.setAliquota(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISAliquota());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            pis.setNaoTributado(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISNaoTributado());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
        try {
            pis.setOutrasOperacoes(FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPISOutrasOperacoes());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
        }
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq></NFNotaInfoItemImpostoPIS>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFakeNFe.getNFNotaInfoItemImpostoPIS().toString());
    }
}
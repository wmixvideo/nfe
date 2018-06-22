package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemImpostoPISTest {

    @Test
    public void devePermitirApenasUmAliquota() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISAliquota());

        try {
            pis.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISNaoTributado());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            pis.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISOutrasOperacoes());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            pis.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISQuantidade());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void devePermitirApenasUmNaoTributado() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISNaoTributado());

        try {
            pis.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISAliquota());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            pis.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISOutrasOperacoes());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            pis.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISQuantidade());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void devePermitirApenasUmOutrasOperacoes() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISOutrasOperacoes());

        try {
            pis.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISAliquota());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            pis.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISNaoTributado());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            pis.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISQuantidade());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void devePermitirApenasUmQuantidade() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISQuantidade());

        try {
            pis.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISAliquota());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            pis.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISNaoTributado());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
        try {
            pis.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISOutrasOperacoes());
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPIS><PISAliq><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></PISAliq></NFNotaInfoItemImpostoPIS>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoPIS().toString());
    }
}
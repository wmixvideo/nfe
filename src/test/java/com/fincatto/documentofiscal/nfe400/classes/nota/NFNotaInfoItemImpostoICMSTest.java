package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemImpostoICMSTest {

    @Test
    public void deveObterIcms00ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMS00 icms00 = FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS00();
        icms.setIcms00(icms00);
        Assert.assertEquals(icms00, icms.getIcms00());
    }

    @Test
    public void deveObterIcms10ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMS10 icms10 = new NFNotaInfoItemImpostoICMS10();
        icms.setIcms10(icms10);
        Assert.assertEquals(icms10, icms.getIcms10());
    }

    @Test
    public void deveObterIcms20ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMS20 icms20 = new NFNotaInfoItemImpostoICMS20();
        icms.setIcms20(icms20);
        Assert.assertEquals(icms20, icms.getIcms20());
    }

    @Test
    public void deveObterIcms30ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMS30 icmsSetado = new NFNotaInfoItemImpostoICMS30();
        icms.setIcms30(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcms30());
    }

    @Test
    public void deveObterIcms40ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMS40 icmsSetado = new NFNotaInfoItemImpostoICMS40();
        icms.setIcms40(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcms40());
    }

    @Test
    public void deveObterIcms51ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMS51 icmsSetado = new NFNotaInfoItemImpostoICMS51();
        icms.setIcms51(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcms51());
    }

    @Test
    public void deveObterIcms60ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMS60 icmsSetado = new NFNotaInfoItemImpostoICMS60();
        icms.setIcms60(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcms60());
    }

    @Test
    public void deveObterIcms70ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMS70 icmsSetado = new NFNotaInfoItemImpostoICMS70();
        icms.setIcms70(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcms70());
    }

    @Test
    public void deveObterIcms90ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMS90 icmsSetado = new NFNotaInfoItemImpostoICMS90();
        icms.setIcms90(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcms90());
    }

    @Test
    public void deveObterIcmsPartilhadoComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMSPartilhado icmsSetado = new NFNotaInfoItemImpostoICMSPartilhado();
        icms.setIcmsPartilhado(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcmsPartilhado());
    }

    @Test
    public void deveObterIcmsSN101ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMSSN101 icmsSetado = new NFNotaInfoItemImpostoICMSSN101();
        icms.setIcmssn101(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcmssn101());
    }

    @Test
    public void deveObterIcmsSN102ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMSSN102 icmsSetado = new NFNotaInfoItemImpostoICMSSN102();
        icms.setIcmssn102(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcmssn102());
    }

    @Test
    public void deveObterIcmsSN201ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMSSN201 icmsSetado = new NFNotaInfoItemImpostoICMSSN201();
        icms.setIcmssn201(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcmssn201());
    }

    @Test
    public void deveObterIcmsSN202ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMSSN202 icmsSetado = new NFNotaInfoItemImpostoICMSSN202();
        icms.setIcmssn202(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcmssn202());
    }

    @Test
    public void deveObterIcmsSN500ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMSSN500 icmsSetado = new NFNotaInfoItemImpostoICMSSN500();
        icms.setIcmssn500(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcmssn500());
    }

    @Test
    public void deveObterIcmsSN900ComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMSSN900 icmsSetado = new NFNotaInfoItemImpostoICMSSN900();
        icms.setIcmssn900(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcmssn900());
    }

    @Test
    public void deveObterIcmsSTComoFoiSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        final NFNotaInfoItemImpostoICMSST icmsSetado = new NFNotaInfoItemImpostoICMSST();
        icms.setIcmsst(icmsSetado);
        Assert.assertEquals(icmsSetado, icms.getIcmsst());
    }

    @Test
    public void devePermitirApenasUmICMSSelecionado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        icms.setIcms00(new NFNotaInfoItemImpostoICMS00());

        try {
            icms.setIcms02(new NFNotaInfoItemImpostoICMS02());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms10(new NFNotaInfoItemImpostoICMS10());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms15(new NFNotaInfoItemImpostoICMS15());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms20(new NFNotaInfoItemImpostoICMS20());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms30(new NFNotaInfoItemImpostoICMS30());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms40(new NFNotaInfoItemImpostoICMS40());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms51(new NFNotaInfoItemImpostoICMS51());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms53(new NFNotaInfoItemImpostoICMS53());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms60(new NFNotaInfoItemImpostoICMS60());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms61(new NFNotaInfoItemImpostoICMS61());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms70(new NFNotaInfoItemImpostoICMS70());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcms90(new NFNotaInfoItemImpostoICMS90());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcmsPartilhado(new NFNotaInfoItemImpostoICMSPartilhado());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcmssn101(new NFNotaInfoItemImpostoICMSSN101());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcmssn102(new NFNotaInfoItemImpostoICMSSN102());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcmssn201(new NFNotaInfoItemImpostoICMSSN201());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcmssn202(new NFNotaInfoItemImpostoICMSSN202());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcmssn500(new NFNotaInfoItemImpostoICMSSN500());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
        try {
            icms.setIcmssn900(new NFNotaInfoItemImpostoICMSSN900());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException ignored) {
        }
    }

    @Test
    public void deveEstarSelecionadoCasoTenhaUmICMSSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        icms.setIcms00(new NFNotaInfoItemImpostoICMS00());
        Assert.assertTrue(icms.isSelecionado());
    }

    @Test
    public void naoDeveEstarSelecionadoCasoNaoTenhaICMSSetado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        Assert.assertFalse(icms.isSelecionado());
    }
}
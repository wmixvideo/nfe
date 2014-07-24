package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;
import com.fincatto.nfe.NFUnidadeFederativa;

public class NFNotaInfoReboqueTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVagaoComTamanhoInvalido() {
        try {
            new NFNotaInfoReboque().setVagao("");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoReboque().setVagao("8fFAKefiBQIDTkCCSQk31");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPlacaVeiculoInvalido() {
        try {
            new NFNotaInfoReboque().setPlacaVeiculo("");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoReboque().setPlacaVeiculo("MKZY0123");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUFNulo() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");
        reboque.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPlacaNulo() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setUf(NFUnidadeFederativa.SC);
        reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");
        reboque.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSetarVagaoERNTCCasoBalsaEstejaSetado() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setBalsa("lfciRECVL2wtomTP35xm");
        try {
            reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            reboque.setVagao("8fFAKefiBQIDTkCCSQk3");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSetarBalsaVagaoCasoERNTCEstejaSetado() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");
        try {
            reboque.setBalsa("lfciRECVL2wtomTP35xm");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            reboque.setVagao("8fFAKefiBQIDTkCCSQk3");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSetarBalsaERNTCCasoVagaoEstejaSetado() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setVagao("8fFAKefiBQIDTkCCSQk3");
        try {
            reboque.setBalsa("lfciRECVL2wtomTP35xm");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test
    public void devePermitirVagaoNulo() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setUf(NFUnidadeFederativa.SC);
        reboque.setBalsa("8fFAKefiBQIDTkCCSQk3");
        reboque.toString();
    }

    @Test
    public void devePermitirBalsaNulo() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setUf(NFUnidadeFederativa.SC);
        reboque.setVagao("8fFAKefiBQIDTkCCSQk3");
        reboque.toString();
    }

    @Test
    public void devePermitirRegistroNacionaltransportadorCargaNulo() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setUf(NFUnidadeFederativa.SC);
        reboque.setBalsa("8fFAKefiBQIDTkCCSQk3");
        reboque.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComRNTC() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setUf(NFUnidadeFederativa.SC);
        reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");

        final String xmlEsperado = "<NFNotaInfoReboque><placa>MKZ4891</placa><UF>42</UF><RNTC>8fFAKefiBQIDTkCCSQk3</RNTC></NFNotaInfoReboque>";
        Assert.assertEquals(xmlEsperado, reboque.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComBalsa() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setUf(NFUnidadeFederativa.SC);
        reboque.setBalsa("8fFAKefiBQIDTkCCSQk3");

        final String xmlEsperado = "<NFNotaInfoReboque><placa>MKZ4891</placa><UF>42</UF><balsa>8fFAKefiBQIDTkCCSQk3</balsa></NFNotaInfoReboque>";
        Assert.assertEquals(xmlEsperado, reboque.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComVagao() {
        final String xmlEsperado = "<NFNotaInfoReboque><placa>MKZ4891</placa><UF>42</UF><vagao>8fFAKefiBQIDTkCCSQk3</vagao></NFNotaInfoReboque>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoReboque().toString());
    }
}
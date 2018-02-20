package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFNotaInfoVeiculoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPlacaFormatoInvalido() {
        try {
            new NFNotaInfoVeiculo().setPlacaVeiculo("MK881");
            Assert.fail("Validacao nao funfou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoVeiculo().setPlacaVeiculo("MKZT8859");
        }
        Assert.fail("Validacao nao funfou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirRNCTComTamanhoInvalido() {
        try {
            new NFNotaInfoVeiculo().setRegistroNacionalTransportadorCarga("");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoVeiculo().setRegistroNacionalTransportadorCarga("8Io5YKSKW1qy3v7zGwLx1");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test
    public void devePermitirRNCTNulo() {
        final NFNotaInfoVeiculo veiculo = new NFNotaInfoVeiculo();
        veiculo.setPlacaVeiculo("MKZ8159");
        veiculo.setUf(DFUnidadeFederativa.SP);
        veiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUFNulo() {
        final NFNotaInfoVeiculo veiculo = new NFNotaInfoVeiculo();
        veiculo.setPlacaVeiculo("MKZ8159");
        veiculo.setRegistroNacionalTransportadorCarga("8Io5YKSKW1qy3v7zGwLx");
        veiculo.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPlacaNulo() {
        final NFNotaInfoVeiculo veiculo = new NFNotaInfoVeiculo();
        veiculo.setRegistroNacionalTransportadorCarga("8Io5YKSKW1qy3v7zGwLx");
        veiculo.setUf(DFUnidadeFederativa.SP);
        veiculo.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEspeardo = "<NFNotaInfoVeiculo><placa>MKZ8159</placa><UF>SP</UF><RNTC>8Io5YKSKW1qy3v7zGwLx</RNTC></NFNotaInfoVeiculo>";
        Assert.assertEquals(xmlEspeardo, FabricaDeObjetosFake.getNFNotaInfoVeiculo().toString());
    }
}
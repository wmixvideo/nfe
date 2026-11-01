package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoVeiculoTest {

    @Test
    public void naoDevePermitirPlacaFormatoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoVeiculo().setPlacaVeiculo("MK881");
                Assertions.fail("Validacao nao funfou");
            } catch (final IllegalStateException e) {
                new NFNotaInfoVeiculo().setPlacaVeiculo("MKZT8859");
            }
            Assertions.fail("Validacao nao funfou");
        });
    }

    @Test
    public void naoDevePermitirRNCTComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoVeiculo().setRegistroNacionalTransportadorCarga("");
                Assertions.fail("Validacao nao funcionou");
            } catch (final IllegalStateException e) {
                new NFNotaInfoVeiculo().setRegistroNacionalTransportadorCarga("8Io5YKSKW1qy3v7zGwLx1");
            }
            Assertions.fail("Validacao nao funcionou");
        });
    }

    @Test
    public void devePermitirRNCTNulo() {
        final NFNotaInfoVeiculo veiculo = new NFNotaInfoVeiculo();
        veiculo.setPlacaVeiculo("MKZ8159");
        veiculo.setUf(DFUnidadeFederativa.SP);
        veiculo.toString();
    }

    @Test
    public void naoDevePermitirUFNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoVeiculo veiculo = new NFNotaInfoVeiculo();
            veiculo.setPlacaVeiculo("MKZ8159");
            veiculo.setRegistroNacionalTransportadorCarga("8Io5YKSKW1qy3v7zGwLx");
            veiculo.toString();
        });
    }

    @Test
    public void naoDevePermitirPlacaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoVeiculo veiculo = new NFNotaInfoVeiculo();
            veiculo.setRegistroNacionalTransportadorCarga("8Io5YKSKW1qy3v7zGwLx");
            veiculo.setUf(DFUnidadeFederativa.SP);
            veiculo.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEspeardo = "<NFNotaInfoVeiculo><placa>MKZ8159</placa><UF>SP</UF><RNTC>8Io5YKSKW1qy3v7zGwLx</RNTC></NFNotaInfoVeiculo>";
        Assertions.assertEquals(xmlEspeardo, FabricaDeObjetosFake.getNFNotaInfoVeiculo().toString());
    }
}
package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoReboqueTest {

    @Test
    public void naoDevePermitirPlacaVeiculoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoReboque().setPlacaVeiculo("");
                Assertions.fail("Validacao nao funcionou");
            } catch (final IllegalStateException e) {
                new NFNotaInfoReboque().setPlacaVeiculo("MKZY0123");
            }
            Assertions.fail("Validacao nao funcionou");
        });
    }

    @Test
    public void naoDevePermitirUFNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
            reboque.setPlacaVeiculo("MKZ4891");
            reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");
            reboque.toString();
        });
    }

    @Test
    public void naoDevePermitirPlacaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
            reboque.setUf(DFUnidadeFederativa.SC);
            reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");
            reboque.toString();
        });
    }

    @Test
    public void devePermitirRegistroNacionaltransportadorCargaNulo() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setUf(DFUnidadeFederativa.SC);
        reboque.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComRNTC() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setUf(DFUnidadeFederativa.SC);
        reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");

        final String xmlEsperado = "<NFNotaInfoReboque><placa>MKZ4891</placa><UF>SC</UF><RNTC>8fFAKefiBQIDTkCCSQk3</RNTC></NFNotaInfoReboque>";
        Assertions.assertEquals(xmlEsperado, reboque.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComVagao() {
        final String xmlEsperado = "<NFNotaInfoReboque><placa>MKZ4891</placa><UF>SC</UF></NFNotaInfoReboque>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoReboque().toString());
    }
}
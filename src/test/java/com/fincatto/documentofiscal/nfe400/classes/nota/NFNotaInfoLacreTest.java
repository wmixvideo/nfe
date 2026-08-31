package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoLacreTest {

    @Test
    public void naoDevePermitirNumeroLacreNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoLacre().toString());
    }

    @Test
    public void naoDevePermitirNumeroLacreComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoLacre().setNumeroLacre("");
                Assertions.fail("Validacao falhou");
            } catch (final IllegalStateException e) {
                new NFNotaInfoLacre().setNumeroLacre("su0ue1tNrrSACxDPXEYVFAqtc2IsnlONmb5AIAv24XjKALlpJ8h5HpUviB3p1");
            }
            Assertions.fail("Validacao falhou");
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoLacre lacre = new NFNotaInfoLacre();
        lacre.setNumeroLacre("su0ue1tNrrSACxDPXEYVFAqtc2IsnlONmb5AIAv24XjKALlpJ8h5HpUviB3p");
        final String xmlEsperado = "<NFNotaInfoLacre><nLacre>su0ue1tNrrSACxDPXEYVFAqtc2IsnlONmb5AIAv24XjKALlpJ8h5HpUviB3p</nLacre></NFNotaInfoLacre>";

        Assertions.assertEquals(xmlEsperado, lacre.toString());
    }
}
package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoLacre;

public class NFNotaInfoLacreTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroLacreNulo() {
        new NFNotaInfoLacre().toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroLacreComTamanhoInvalido() {
        try {
            new NFNotaInfoLacre().setNumeroLacre("");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoLacre().setNumeroLacre("su0ue1tNrrSACxDPXEYVFAqtc2IsnlONmb5AIAv24XjKALlpJ8h5HpUviB3p1");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoLacre lacre = new NFNotaInfoLacre();
        lacre.setNumeroLacre("su0ue1tNrrSACxDPXEYVFAqtc2IsnlONmb5AIAv24XjKALlpJ8h5HpUviB3p");
        final String xmlEsperado = "<NFNotaInfoLacre><nLacre>su0ue1tNrrSACxDPXEYVFAqtc2IsnlONmb5AIAv24XjKALlpJ8h5HpUviB3p</nLacre></NFNotaInfoLacre>";

        Assert.assertEquals(xmlEsperado, lacre.toString());
    }
}
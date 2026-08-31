package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NFNotaInfoDuplicataTest {

    @Test
    public void naoDevePermitirNumeroDuplicataTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoDuplicata().setNumeroDuplicata("TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z1"));
    }

    @Test
    public void naoDevePermitirValorDuplicataNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoDuplicata duplicata = new NFNotaInfoDuplicata();
            duplicata.setDataVencimento(LocalDate.of(2014, 7, 10));
            duplicata.setNumeroDuplicata("TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z");
            duplicata.toString();
        });
    }

    @Test
    public void devePermitirNumeroDuplicataNulo() {
        final NFNotaInfoDuplicata duplicata = new NFNotaInfoDuplicata();
        duplicata.setDataVencimento(LocalDate.of(2014, 7, 10));
        duplicata.setValorDuplicata(new BigDecimal("999999.99"));
        duplicata.toString();
    }

    @Test
    public void devePermitirDataVencimentoNulo() {
        final NFNotaInfoDuplicata duplicata = new NFNotaInfoDuplicata();
        duplicata.setNumeroDuplicata("TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z");
        duplicata.setValorDuplicata(new BigDecimal("999999.99"));
        duplicata.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoDuplicata><nDup>TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z</nDup><dVenc>2014-07-10</dVenc><vDup>999999.99</vDup></NFNotaInfoDuplicata>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoDuplicata().toString());
    }
}
package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NFNotaInfoParcelaTest {

    @Test
    public void naoDevePermitirNumeroDuplicataTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoParcela().setNumeroParcela("TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z1"));
    }

    @Test
    public void naoDevePermitirValorDuplicataNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoParcela duplicata = new NFNotaInfoParcela();
            duplicata.setDataVencimento(LocalDate.of(2014, 7, 10));
            duplicata.setNumeroParcela("TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z");
            duplicata.toString();
        });
    }

    @Test
    public void devePermitirNumeroDuplicataNulo() {
        final NFNotaInfoParcela duplicata = new NFNotaInfoParcela();
        duplicata.setDataVencimento(LocalDate.of(2014, 7, 10));
        duplicata.setValorParcela(new BigDecimal("999999.99"));
        duplicata.toString();
    }

    @Test
    public void devePermitirDataVencimentoNulo() {
        final NFNotaInfoParcela duplicata = new NFNotaInfoParcela();
        duplicata.setNumeroParcela("TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z");
        duplicata.setValorParcela(new BigDecimal("999999.99"));
        duplicata.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<dup><nDup>TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z</nDup><dVenc>2014-07-10</dVenc><vDup>999999.99</vDup></dup>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoDuplicata().toString());
    }
}
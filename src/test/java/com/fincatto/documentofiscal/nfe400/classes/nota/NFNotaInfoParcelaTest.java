package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFNotaInfoParcelaTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroDuplicataTamanhoInvalido() {
        new NFNotaInfoParcela().setNumeroParcela("TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z1");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorDuplicataNulo() {
        final NFNotaInfoParcela duplicata = new NFNotaInfoParcela();
        duplicata.setDataVencimento(LocalDate.of(2014, 7, 10));
        duplicata.setNumeroParcela("TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z");
        duplicata.toString();
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
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoDuplicata().toString());
    }
}
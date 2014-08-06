package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;

public class NFInfoReferenciadaTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChaveAcessoComTamanhoInvalido() {
        try {
            new NFInfoReferenciada().setChaveAcesso("Vrf4YXN3J1cZJpTrnKt1uOAO80JBm6aO4r1zT7Q94Qk");
        } catch (final IllegalStateException e) {
            new NFInfoReferenciada().setChaveAcesso("Vrf4YXN3J1cZJpTrnKt1uOAO80JBm6aO4r1zT7Q94Qkt1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModelo1por1ReferenciadaNulo() {
        final NFInfoReferenciada referenciada = new NFInfoReferenciada();
        referenciada.setChaveAcesso("Vrf4YXN3J1cZJpTrnKt1uOAO80JBm6aO4r1zT7Q94Qkt");
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChaveAcessoNulo() {
        final NFInfoReferenciada referenciada = new NFInfoReferenciada();
        referenciada.setModelo1por1Referenciada(FabricaDeObjetosFake.getNFInfoModelo1Por1AReferenciada());
        referenciada.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFInfoReferenciada referenciada = new NFInfoReferenciada();
        referenciada.setChaveAcesso("Vrf4YXN3J1cZJpTrnKt1uOAO80JBm6aO4r1zT7Q94Qkt");
        referenciada.setModelo1por1Referenciada(FabricaDeObjetosFake.getNFInfoModelo1Por1AReferenciada());

        final String xmlEsperado = "<NFInfoReferenciada><refNFe>Vrf4YXN3J1cZJpTrnKt1uOAO80JBm6aO4r1zT7Q94Qkt</refNFe><refNF><cUF>42</cUF><AAMM>1408</AAMM><CNPJ>12345678901234</CNPJ><mod>A1</mod><serie>999</serie><nNF>999999999</nNF><refNFP><cUF>42</cUF><AAMM>1402</AAMM><CNPJ>12345678901234</CNPJ><IE>ISENTO</IE><mod>IE</mod><serie>999</serie><nNF>999999</nNF><refCTe>y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L</refCTe></refNFP><refECF><mod>A2</mod><nECF>a71</nECF><nCOO>NUQvJH</nCOO></refECF></refNF></NFInfoReferenciada>";
        Assert.assertEquals(xmlEsperado, referenciada.toString());
    }
}
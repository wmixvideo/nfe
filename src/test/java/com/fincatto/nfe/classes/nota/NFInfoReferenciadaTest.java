package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;

public class NFInfoReferenciadaTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSetarModelo1por1ReferenciadaCasoChaveAcessoEstejaSetado() {
        final NFInfoReferenciada referenciada = new NFInfoReferenciada();
        referenciada.setChaveAcesso("97649154542619956204618059353096005113462909");
        referenciada.setModelo1por1Referenciada(FabricaDeObjetosFake.getNFInfoModelo1Por1AReferenciada());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSetarChaveAcessoCasoModelo1por1ReferenciadaEstejaSetado() {
        final NFInfoReferenciada referenciada = new NFInfoReferenciada();
        referenciada.setModelo1por1Referenciada(FabricaDeObjetosFake.getNFInfoModelo1Por1AReferenciada());
        referenciada.setChaveAcesso("97649154542619956204618059353096005113462909");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChaveAcessoComTamanhoInvalido() {
        try {
            new NFInfoReferenciada().setChaveAcesso("9764915454261995620461805935309600511346290");
        } catch (final IllegalStateException e) {
            new NFInfoReferenciada().setChaveAcesso("976491545426199562046180593530960051134629091");
        }
    }

    @Test
    public void devePermitirModelo1por1ReferenciadaNulo() {
        final NFInfoReferenciada referenciada = new NFInfoReferenciada();
        referenciada.setChaveAcesso("97649154542619956204618059353096005113462909");
        referenciada.toString();
    }

    @Test
    public void devePermitirChaveAcessoNulo() {
        final NFInfoReferenciada referenciada = new NFInfoReferenciada();
        referenciada.setModelo1por1Referenciada(FabricaDeObjetosFake.getNFInfoModelo1Por1AReferenciada());
        referenciada.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFInfoReferenciada referenciada = new NFInfoReferenciada();
        referenciada.setModelo1por1Referenciada(FabricaDeObjetosFake.getNFInfoModelo1Por1AReferenciada());

        final String xmlEsperado = "<NFInfoReferenciada><refNF><cUF>42</cUF><AAMM>1408</AAMM><CNPJ>12345678901234</CNPJ><mod>01</mod><serie>999</serie><nNF>999999999</nNF><refNFP><cUF>42</cUF><AAMM>1402</AAMM><CNPJ>12345678901234</CNPJ><IE>ISENTO</IE><mod>IE</mod><serie>999</serie><nNF>999999</nNF><refCTe>19506188293993666630760813709064781438945816</refCTe></refNFP><refECF><mod>55</mod><nECF>a71</nECF><nCOO>NUQvJH</nCOO></refECF></refNF></NFInfoReferenciada>";
        Assert.assertEquals(xmlEsperado, referenciada.toString());
    }
}
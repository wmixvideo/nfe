package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFInfoModelo1Por1AReferenciada;

public class NFInfoModelo1Por1AReferenciadaTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJComTamanhoInvalido() {
        try {
            new NFInfoModelo1Por1AReferenciada().setCnpj("1234567890123");
        } catch (final IllegalStateException e) {
            new NFInfoModelo1Por1AReferenciada().setCnpj("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloDocumentoFiscalComTamanhoInvalido() {
        try {
            new NFInfoModelo1Por1AReferenciada().setModeloDocumentoFiscal("t");
        } catch (final IllegalStateException e) {
            new NFInfoModelo1Por1AReferenciada().setModeloDocumentoFiscal("tk1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroDocumentoFiscalComTamanhoInvalido() {
        new NFInfoModelo1Por1AReferenciada().setNumeroDocumentoFiscal("1000000000");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirSerieComTamanhoInvalido() {
        new NFInfoModelo1Por1AReferenciada().setSerie(1000);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAnoMesEmissaoNFeNulo() {
        final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
        referenciada.setCnpj("12345678901234");
        referenciada.setModeloDocumentoFiscal("A1");
        referenciada.setNumeroDocumentoFiscal("999999999");
        referenciada.setSerie(999);
        referenciada.setUf(DFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCnpjNulo() {
        final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
        referenciada.setAnoMesEmissaoNFe("1408");
        referenciada.setModeloDocumentoFiscal("A1");
        referenciada.setNumeroDocumentoFiscal("999999999");
        referenciada.setSerie(999);
        referenciada.setUf(DFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloDocumentoFiscalNulo() {
        final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
        referenciada.setAnoMesEmissaoNFe("1408");
        referenciada.setCnpj("12345678901234");
        referenciada.setNumeroDocumentoFiscal("999999999");
        referenciada.setSerie(999);
        referenciada.setUf(DFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test
    public void devePermitirNumeroDocumentoFiscalNulo() {
        final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
        referenciada.setAnoMesEmissaoNFe("1408");
        referenciada.setCnpj("12345678901234");
        referenciada.setModeloDocumentoFiscal("A1");
        referenciada.setSerie(999);
        referenciada.setUf(DFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSerieNulo() {
        final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
        referenciada.setAnoMesEmissaoNFe("1408");
        referenciada.setCnpj("12345678901234");
        referenciada.setModeloDocumentoFiscal("A1");
        referenciada.setNumeroDocumentoFiscal("999999999");
        referenciada.setUf(DFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUfNulo() {
        final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
        referenciada.setAnoMesEmissaoNFe("1408");
        referenciada.setCnpj("12345678901234");
        referenciada.setModeloDocumentoFiscal("A1");
        referenciada.setNumeroDocumentoFiscal("999999999");
        referenciada.setSerie(999);
        referenciada.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoModelo1Por1AReferenciada><cUF>43</cUF><AAMM>1408</AAMM><CNPJ>12345678901234</CNPJ><mod>01</mod><serie>999</serie><nNF>999999999</nNF></NFInfoModelo1Por1AReferenciada>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoModelo1Por1AReferenciada().toString());
    }
}
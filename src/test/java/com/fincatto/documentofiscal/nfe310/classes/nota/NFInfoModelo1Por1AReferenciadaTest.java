package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFInfoModelo1Por1AReferenciadaTest {

    @Test
    public void naoDevePermitirCNPJComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFInfoModelo1Por1AReferenciada().setCnpj("1234567890123");
            } catch (final IllegalStateException e) {
                new NFInfoModelo1Por1AReferenciada().setCnpj("123456789012345");
            }
        });
    }

    @Test
    public void naoDevePermitirModeloDocumentoFiscalComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFInfoModelo1Por1AReferenciada().setModeloDocumentoFiscal("t");
            } catch (final IllegalStateException e) {
                new NFInfoModelo1Por1AReferenciada().setModeloDocumentoFiscal("tk1");
            }
        });
    }

    @Test
    public void naoDevePermitirNumeroDocumentoFiscalComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoModelo1Por1AReferenciada().setNumeroDocumentoFiscal("1000000000"));
    }

    @Test
    public void naoDevePermitirSerieComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFInfoModelo1Por1AReferenciada().setSerie(1000));
    }

    @Test
    public void naoDevePermitirAnoMesEmissaoNFeNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
            referenciada.setCnpj("12345678901234");
            referenciada.setModeloDocumentoFiscal("A1");
            referenciada.setNumeroDocumentoFiscal("999999999");
            referenciada.setSerie(999);
            referenciada.setUf(DFUnidadeFederativa.SC);
            referenciada.toString();
        });
    }

    @Test
    public void naoDevePermitirCnpjNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
            referenciada.setAnoMesEmissaoNFe("1408");
            referenciada.setModeloDocumentoFiscal("A1");
            referenciada.setNumeroDocumentoFiscal("999999999");
            referenciada.setSerie(999);
            referenciada.setUf(DFUnidadeFederativa.SC);
            referenciada.toString();
        });
    }

    @Test
    public void naoDevePermitirModeloDocumentoFiscalNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
            referenciada.setAnoMesEmissaoNFe("1408");
            referenciada.setCnpj("12345678901234");
            referenciada.setNumeroDocumentoFiscal("999999999");
            referenciada.setSerie(999);
            referenciada.setUf(DFUnidadeFederativa.SC);
            referenciada.toString();
        });
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

    @Test
    public void naoDevePermitirSerieNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
            referenciada.setAnoMesEmissaoNFe("1408");
            referenciada.setCnpj("12345678901234");
            referenciada.setModeloDocumentoFiscal("A1");
            referenciada.setNumeroDocumentoFiscal("999999999");
            referenciada.setUf(DFUnidadeFederativa.SC);
            referenciada.toString();
        });
    }

    @Test
    public void naoDevePermitirUfNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoModelo1Por1AReferenciada referenciada = new NFInfoModelo1Por1AReferenciada();
            referenciada.setAnoMesEmissaoNFe("1408");
            referenciada.setCnpj("12345678901234");
            referenciada.setModeloDocumentoFiscal("A1");
            referenciada.setNumeroDocumentoFiscal("999999999");
            referenciada.setSerie(999);
            referenciada.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoModelo1Por1AReferenciada><cUF>43</cUF><AAMM>1408</AAMM><CNPJ>12345678901234</CNPJ><mod>01</mod><serie>999</serie><nNF>999999999</nNF></NFInfoModelo1Por1AReferenciada>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoModelo1Por1AReferenciada().toString());
    }
}
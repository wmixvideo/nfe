package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.NFUnidadeFederativa;

public class NFInfoProdutorRuralReferenciadaTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJComTamanhoInvalido() {
        try {
            new NFInfoProdutorRuralReferenciada().setCnpjEmitente("1234567890123");
        } catch (final IllegalStateException e) {
            new NFInfoProdutorRuralReferenciada().setCnpjEmitente("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCPFComTamanhoInvalido() {
        try {
            new NFInfoProdutorRuralReferenciada().setCpfEmitente("1234567890");
        } catch (final IllegalStateException e) {
            new NFInfoProdutorRuralReferenciada().setCpfEmitente("123456789012");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSerieDocumentoFiscalComTamanhoInvalido() {
        new NFInfoProdutorRuralReferenciada().setSerieDocumentoFiscal(1000);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroDocumentoFiscalComTamanhoInvalido() {
        new NFInfoProdutorRuralReferenciada().setNumeroDocumentoFiscal(1000000);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloDocumentoFiscalComTamanhoInvalido() {
        try {
            new NFInfoProdutorRuralReferenciada().setModeloDocumentoFiscal("I");
        } catch (final IllegalStateException e) {
            new NFInfoProdutorRuralReferenciada().setModeloDocumentoFiscal("IE1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChaveAcessoCTReferenciadaComTamanhoInvalido() {
        try {
            new NFInfoProdutorRuralReferenciada().setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9");
        } catch (final IllegalStateException e) {
            new NFInfoProdutorRuralReferenciada().setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJSetadoQuandoCPFEstaSetado() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setCpfEmitente("12345678901");
        referenciada.setCnpjEmitente("12345678901234");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCPFSetadoQuandoCNPJEstaSetado() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setCnpjEmitente("12345678901234");
        referenciada.setCpfEmitente("12345678901");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAnoMesEmissaoReferenciadaNulo() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L");
        referenciada.setCnpjEmitente("12345678901234");
        referenciada.setIeEmitente("ISENTO");
        referenciada.setModeloDocumentoFiscal("IE");
        referenciada.setNumeroDocumentoFiscal(999999);
        referenciada.setSerieDocumentoFiscal(999);
        referenciada.setUfEmitente(NFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChaveAcessoCTReferenciadaNulo() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setAnoMesEmissao("1402");
        referenciada.setCnpjEmitente("12345678901234");
        referenciada.setIeEmitente("ISENTO");
        referenciada.setModeloDocumentoFiscal("IE");
        referenciada.setNumeroDocumentoFiscal(999999);
        referenciada.setSerieDocumentoFiscal(999);
        referenciada.setUfEmitente(NFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test
    public void devePermitirCpfEmitenteNulo() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setAnoMesEmissao("1402");
        referenciada.setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L");
        referenciada.setCnpjEmitente("12345678901234");
        referenciada.setIeEmitente("ISENTO");
        referenciada.setModeloDocumentoFiscal("IE");
        referenciada.setNumeroDocumentoFiscal(999999);
        referenciada.setSerieDocumentoFiscal(999);
        referenciada.setUfEmitente(NFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test
    public void devePermitirCnpjEmitenteNulo() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setAnoMesEmissao("1402");
        referenciada.setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L");
        referenciada.setCpfEmitente("12345678901");
        referenciada.setIeEmitente("ISENTO");
        referenciada.setModeloDocumentoFiscal("IE");
        referenciada.setNumeroDocumentoFiscal(999999);
        referenciada.setSerieDocumentoFiscal(999);
        referenciada.setUfEmitente(NFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIeEmitenteNulo() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setAnoMesEmissao("1402");
        referenciada.setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L");
        referenciada.setCnpjEmitente("12345678901234");
        referenciada.setModeloDocumentoFiscal("IE");
        referenciada.setNumeroDocumentoFiscal(999999);
        referenciada.setSerieDocumentoFiscal(999);
        referenciada.setUfEmitente(NFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloDocumentoFiscalNulo() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setAnoMesEmissao("1402");
        referenciada.setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L");
        referenciada.setCnpjEmitente("12345678901234");
        referenciada.setIeEmitente("ISENTO");
        referenciada.setNumeroDocumentoFiscal(999999);
        referenciada.setSerieDocumentoFiscal(999);
        referenciada.setUfEmitente(NFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroDocumentoFiscalNulo() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setAnoMesEmissao("1402");
        referenciada.setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L");
        referenciada.setCnpjEmitente("12345678901234");
        referenciada.setIeEmitente("ISENTO");
        referenciada.setModeloDocumentoFiscal("IE");
        referenciada.setSerieDocumentoFiscal(999);
        referenciada.setUfEmitente(NFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSerieDocumentoFiscalNulo() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setAnoMesEmissao("1402");
        referenciada.setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L");
        referenciada.setCnpjEmitente("12345678901234");
        referenciada.setIeEmitente("ISENTO");
        referenciada.setModeloDocumentoFiscal("IE");
        referenciada.setNumeroDocumentoFiscal(999999);
        referenciada.setUfEmitente(NFUnidadeFederativa.SC);
        referenciada.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUfEmitenteNulo() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setAnoMesEmissao("1402");
        referenciada.setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L");
        referenciada.setCnpjEmitente("12345678901234");
        referenciada.setIeEmitente("ISENTO");
        referenciada.setModeloDocumentoFiscal("IE");
        referenciada.setNumeroDocumentoFiscal(999999);
        referenciada.setSerieDocumentoFiscal(999);
        referenciada.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFInfoProdutorRuralReferenciada referenciada = new NFInfoProdutorRuralReferenciada();
        referenciada.setAnoMesEmissao("1402");
        referenciada.setChaveAcessoCTReferenciada("y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L");
        referenciada.setCnpjEmitente("12345678901234");
        referenciada.setIeEmitente("ISENTO");
        referenciada.setModeloDocumentoFiscal("IE");
        referenciada.setNumeroDocumentoFiscal(999999);
        referenciada.setSerieDocumentoFiscal(999);
        referenciada.setUfEmitente(NFUnidadeFederativa.SC);

        final String xmlEsperado = "<NFInfoProdutorRuralReferenciada><cUF>42</cUF><AAMM>1402</AAMM><CNPJ>12345678901234</CNPJ><IE>ISENTO</IE><mod>IE</mod><serie>999</serie><nNF>999999</nNF><refCTe>y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L</refCTe></NFInfoProdutorRuralReferenciada>";
        Assert.assertEquals(xmlEsperado, referenciada.toString());
    }
}
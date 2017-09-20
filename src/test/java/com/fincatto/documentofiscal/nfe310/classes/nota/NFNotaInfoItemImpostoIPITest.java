package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItemImpostoIPI;

public class NFNotaInfoItemImpostoIPITest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirClasseEnquadramentoTamanhoInvalido() {
        new NFNotaInfoItemImpostoIPI().setClasseEnquadramento("NEFiL1");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoEnquadramentoTamanhoInvalido() {
        new NFNotaInfoItemImpostoIPI().setCodigoEnquadramento("iNEF");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoSeloTamanhoInvalido() {
        new NFNotaInfoItemImpostoIPI().setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc51");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeSeloTamanhoInvalido() {
        new NFNotaInfoItemImpostoIPI().setQuantidadeSelo(new BigInteger("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSetarNaoTributadoCasoTributadoEstejaSetado() {
        final NFNotaInfoItemImpostoIPI impostoIPI = new NFNotaInfoItemImpostoIPI();
        impostoIPI.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
        impostoIPI.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSetarTributadoCasoNaoTributadoEstejaSetado() {
        final NFNotaInfoItemImpostoIPI impostoIPI = new NFNotaInfoItemImpostoIPI();
        impostoIPI.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
        impostoIPI.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
    }

    @Test
    public void devePermitirClasseEnquadramentoNulo() {
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setCnpjProdutor("12345678901234");
        ipi.setCodigoEnquadramento("aT2");
        ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
        ipi.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
        ipi.setQuantidadeSelo(new BigInteger("999999999999"));
        ipi.toString();
    }

    @Test
    public void devePermitirCnojProdutorNulo() {
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setClasseEnquadramento("157br");
        ipi.setCodigoEnquadramento("aT2");
        ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
        ipi.setQuantidadeSelo(new BigInteger("999999999999"));
        ipi.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
        ipi.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoEnquadramentoNulo() {
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setClasseEnquadramento("157br");
        ipi.setCnpjProdutor("12345678901234");
        ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
        ipi.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
        ipi.setQuantidadeSelo(new BigInteger("999999999999"));
        ipi.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
        ipi.toString();
    }

    @Test
    public void devePermitirCodigoSeloNulo() {
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setClasseEnquadramento("157br");
        ipi.setCnpjProdutor("12345678901234");
        ipi.setCodigoEnquadramento("aT2");
        ipi.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
        ipi.setQuantidadeSelo(new BigInteger("999999999999"));
        ipi.toString();
    }

    @Test
    public void devePermitirNaoTributadoNulo() {
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setClasseEnquadramento("157br");
        ipi.setCnpjProdutor("12345678901234");
        ipi.setCodigoEnquadramento("aT2");
        ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
        ipi.setQuantidadeSelo(new BigInteger("999999999999"));
        ipi.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
        ipi.toString();
    }

    @Test
    public void devePermitirQuantidadeSeloNulo() {
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setClasseEnquadramento("157br");
        ipi.setCnpjProdutor("12345678901234");
        ipi.setCodigoEnquadramento("aT2");
        ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
        ipi.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
        ipi.toString();
    }

    @Test
    public void devePermitirTributadoNulo() {
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setClasseEnquadramento("157br");
        ipi.setCnpjProdutor("12345678901234");
        ipi.setCodigoEnquadramento("aT2");
        ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
        ipi.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
        ipi.setQuantidadeSelo(new BigInteger("999999999999"));
        ipi.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIPI><clEnq>157br</clEnq><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>49</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib></NFNotaInfoItemImpostoIPI>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI().toString());
    }
}
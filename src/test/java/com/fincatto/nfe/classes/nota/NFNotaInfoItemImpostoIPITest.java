package com.fincatto.nfe.classes.nota;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;

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

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeSeloTamanhoInvalido() {
        new NFNotaInfoItemImpostoIPI().setQuantidadeSelo(new BigInteger("1000000000000"));
    }

    @Test
    public void devePermitirClasseEnquadramentoNulo() {
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setCnpjProdutor("12345678901234");
        ipi.setCodigoEnquadramento("aT2");
        ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
        ipi.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
        ipi.setQuantidadeSelo(new BigInteger("999999999999"));
        ipi.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
        ipi.toString();
    }

    @Test
    public void devePermitirCnojProdutorNulo() {
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setClasseEnquadramento("157br");
        ipi.setCodigoEnquadramento("aT2");
        ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
        ipi.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
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
        ipi.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
        ipi.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNaoTributadoNulo() {
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
        ipi.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
        ipi.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTributadoNulo() {
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
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setClasseEnquadramento("157br");
        ipi.setCnpjProdutor("12345678901234");
        ipi.setCodigoEnquadramento("aT2");
        ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
        ipi.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
        ipi.setQuantidadeSelo(new BigInteger("999999999999"));
        ipi.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());

        final String xmlEsperado = "<NFNotaInfoItemImpostoIPI><clEnq>157br</clEnq><CNPJProd>12345678901234</CNPJProd><cSelo>iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5</cSelo><qSelo>999999999999</qSelo><cEnq>aT2</cEnq><IPITrib><CST>52</CST><vBC>999999999999.99</vBC><pIPI>99.99</pIPI><vIPI>999999999999.99</vIPI></IPITrib><IPINT><CST>52</CST></IPINT></NFNotaInfoItemImpostoIPI>";
        Assert.assertEquals(xmlEsperado, ipi.toString());
    }
}
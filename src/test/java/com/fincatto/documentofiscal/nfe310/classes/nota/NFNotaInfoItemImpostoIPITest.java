package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class NFNotaInfoItemImpostoIPITest {

    @Test
    public void naoDevePermitirClasseEnquadramentoTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoIPI().setClasseEnquadramento("NEFiL1"));
    }

    @Test
    public void naoDevePermitirCodigoEnquadramentoTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoIPI().setCodigoEnquadramento("iNEF"));
    }

    @Test
    public void naoDevePermitirCodigoSeloTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoIPI().setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc51"));
    }

    @Test
    public void naoDevePermitirQuantidadeSeloTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoIPI().setQuantidadeSelo(new BigInteger("1000000000000")));
    }

    @Test
    public void naoDevePermitirSetarNaoTributadoCasoTributadoEstejaSetado() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoIPI impostoIPI = new NFNotaInfoItemImpostoIPI();
            impostoIPI.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
            impostoIPI.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
        });
    }

    @Test
    public void naoDevePermitirSetarTributadoCasoNaoTributadoEstejaSetado() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoIPI impostoIPI = new NFNotaInfoItemImpostoIPI();
            impostoIPI.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
            impostoIPI.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
        });
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

    @Test
    public void naoDevePermitirCodigoEnquadramentoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
            ipi.setClasseEnquadramento("157br");
            ipi.setCnpjProdutor("12345678901234");
            ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
            ipi.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
            ipi.setQuantidadeSelo(new BigInteger("999999999999"));
            ipi.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
            ipi.toString();
        });
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
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPI().toString());
    }
}
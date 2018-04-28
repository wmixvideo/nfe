package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFPessoaAutorizadaDownloadNFeTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJComTamanhoInvalido() {
        try {
            new NFPessoaAutorizadaDownloadNFe().setCnpj("1234567890123");
        } catch (final IllegalStateException e) {
            new NFPessoaAutorizadaDownloadNFe().setCnpj("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCPFComTamanhoInvalido() {
        try {
            new NFPessoaAutorizadaDownloadNFe().setCpf("1234567890");
        } catch (final IllegalStateException e) {
            new NFPessoaAutorizadaDownloadNFe().setCpf("123456789012");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCNPJSetadoQuandoCPFEstaSetado() {
        final NFPessoaAutorizadaDownloadNFe autorizadaDownloadNFe = new NFPessoaAutorizadaDownloadNFe();
        autorizadaDownloadNFe.setCpf("12345678901");
        autorizadaDownloadNFe.setCnpj("12345678901234");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCPFSetadoQuandoCNPJEstaSetado() {
        final NFPessoaAutorizadaDownloadNFe autorizadaDownloadNFe = new NFPessoaAutorizadaDownloadNFe();
        autorizadaDownloadNFe.setCnpj("12345678901234");
        autorizadaDownloadNFe.setCpf("12345678901");
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFPessoaAutorizadaDownloadNFe autorizadaDownloadNFe = new NFPessoaAutorizadaDownloadNFe();
        autorizadaDownloadNFe.setCnpj("12345678901234");

        final String xmlEsperado = "<NFPessoaAutorizadaDownloadNFe><CNPJ>12345678901234</CNPJ></NFPessoaAutorizadaDownloadNFe>";
        Assert.assertEquals(xmlEsperado, autorizadaDownloadNFe.toString());
    }
}
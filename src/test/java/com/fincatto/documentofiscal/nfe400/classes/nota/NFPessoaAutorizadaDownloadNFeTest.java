package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFPessoaAutorizadaDownloadNFeTest {

    @Test
    public void naoDevePermitirCNPJComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFPessoaAutorizadaDownloadNFe().setCnpj("1234567890123");
            } catch (final IllegalStateException e) {
                new NFPessoaAutorizadaDownloadNFe().setCnpj("123456789012345");
            }
        });
    }

    @Test
    public void naoDevePermitirCPFComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFPessoaAutorizadaDownloadNFe().setCpf("1234567890");
            } catch (final IllegalStateException e) {
                new NFPessoaAutorizadaDownloadNFe().setCpf("123456789012");
            }
        });
    }

    @Test
    public void naoDevePermitirCNPJSetadoQuandoCPFEstaSetado() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFPessoaAutorizadaDownloadNFe autorizadaDownloadNFe = new NFPessoaAutorizadaDownloadNFe();
            autorizadaDownloadNFe.setCpf("12345678901");
            autorizadaDownloadNFe.setCnpj("12345678901234");
        });
    }

    @Test
    public void naoDevePermitirCPFSetadoQuandoCNPJEstaSetado() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFPessoaAutorizadaDownloadNFe autorizadaDownloadNFe = new NFPessoaAutorizadaDownloadNFe();
            autorizadaDownloadNFe.setCnpj("12345678901234");
            autorizadaDownloadNFe.setCpf("12345678901");
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFPessoaAutorizadaDownloadNFe autorizadaDownloadNFe = new NFPessoaAutorizadaDownloadNFe();
        autorizadaDownloadNFe.setCnpj("12345678901234");

        final String xmlEsperado = "<NFPessoaAutorizadaDownloadNFe><CNPJ>12345678901234</CNPJ></NFPessoaAutorizadaDownloadNFe>";
        Assertions.assertEquals(xmlEsperado, autorizadaDownloadNFe.toString());
    }
}
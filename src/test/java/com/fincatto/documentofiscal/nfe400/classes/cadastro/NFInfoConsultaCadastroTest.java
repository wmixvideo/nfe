package com.fincatto.documentofiscal.nfe400.classes.cadastro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFInfoConsultaCadastroTest {

    @Test
    public void naoDevePermitirUfNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
            infoConsultaCadastro.setCnpj("56138725000103");
            infoConsultaCadastro.setInscricaoEstadual("90321");
            infoConsultaCadastro.setServico("CONS-CAD");
            infoConsultaCadastro.toString();
        });
    }

    @Test
    public void naoDevePermitirServicoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
            infoConsultaCadastro.setCnpj("56138725000103");
            infoConsultaCadastro.setInscricaoEstadual("90321");
            infoConsultaCadastro.setUf("SC");
            infoConsultaCadastro.toString();
        });
    }

    // @Test(expected = IllegalStateException.class)
    // public void naoDevePermitirIENulo() {
    // final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
    // infoConsultaCadastro.setCnpj("56138725000103");
    // infoConsultaCadastro.setServico("CONS-CAD");
    // infoConsultaCadastro.setUf("SC");
    // infoConsultaCadastro.toString();
    // }

    @Test
    public void devePermitirCnpjNulo() {
        final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
        infoConsultaCadastro.setCnpj("56138725000103");
        infoConsultaCadastro.setServico("CONS-CAD");
        infoConsultaCadastro.setUf("SC");
        infoConsultaCadastro.setInscricaoEstadual("90321");
        infoConsultaCadastro.toString();
    }

    @Test
    public void devePermitirCpfNulo() {
        final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
        infoConsultaCadastro.setCnpj("56138725000103");
        infoConsultaCadastro.setServico("CONS-CAD");
        infoConsultaCadastro.setUf("SC");
        infoConsultaCadastro.setInscricaoEstadual("90321");
        infoConsultaCadastro.toString();
    }

    @Test
    public void deveObterOqueUFFoiSetado() {
        final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
        infoConsultaCadastro.setUf("SC");
        Assertions.assertEquals("SC", infoConsultaCadastro.getUf());
    }

    @Test
    public void deveObterOqueServicoFoiSetado() {
        final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
        infoConsultaCadastro.setServico("CONS-CAD");
        Assertions.assertEquals("CONS-CAD", infoConsultaCadastro.getServico());
    }

    @Test
    public void deveObterOqueIEFoiSetado() {
        final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
        infoConsultaCadastro.setInscricaoEstadual("90321");
        Assertions.assertEquals("90321", infoConsultaCadastro.getInscricaoEstadual());
    }

    @Test
    public void deveObterOqueCpfFoiSetado() {
        final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
        infoConsultaCadastro.setCpf("56138725000");
        Assertions.assertEquals("56138725000", infoConsultaCadastro.getCpf());
    }

    @Test
    public void deveObterOqueCnpjFoiSetado() {
        final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
        infoConsultaCadastro.setCnpj("56138725000103");
        Assertions.assertEquals("56138725000103", infoConsultaCadastro.getCnpj());
    }

    @Test
    public void naoDevePermitirCNPJSetadoQuandoCPFEstaSetado() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoConsultaCadastro referenciada = new NFInfoConsultaCadastro();
            referenciada.setCpf("12345678901");
            referenciada.setCnpj("12345678901234");
        });
    }

    @Test
    public void naoDevePermitirCPFSetadoQuandoCNPJEstaSetado() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoConsultaCadastro referenciada = new NFInfoConsultaCadastro();
            referenciada.setCnpj("12345678901234");
            referenciada.setCpf("12345678901");
        });
    }
}
package com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFRetornoCancelamentoTest {

    @Test
    public void deveObterInfoCancelamentoComoFoiSetado() {
        final NFRetornoCancelamento cancelamento = new NFRetornoCancelamento();
        final NFRetornoInfoCancelamento infoCancelamento = new NFRetornoInfoCancelamento();
        cancelamento.setInfoCancelamento(infoCancelamento);

        Assertions.assertEquals(infoCancelamento, cancelamento.getInfoCancelamento());
    }

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFRetornoCancelamento cancelamento = new NFRetornoCancelamento();
        final String versao = "3.10";
        cancelamento.setVersao(versao);
        Assertions.assertEquals("3.10", cancelamento.getVersao());
    }
}
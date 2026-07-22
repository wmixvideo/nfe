package com.fincatto.documentofiscal.nfe400.classes.nota.listagemchaves;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class NFCeListagemChavesTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFCeListagemChaves listagemChaves = new NFCeListagemChaves();
        listagemChaves.setVersao(new BigDecimal("1.00"));
        Assert.assertEquals("1.00", listagemChaves.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFCeListagemChaves listagemChaves = new NFCeListagemChaves();
        listagemChaves.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, listagemChaves.getAmbiente());
    }

    @Test
    public void deveFormatarDataHoraInicialSemSegundos() {
        final NFCeListagemChaves listagemChaves = new NFCeListagemChaves();
        listagemChaves.setDataHoraInicial(LocalDateTime.of(2026, 7, 21, 15, 30, 0));
        Assert.assertEquals("2026-07-21T15:30", listagemChaves.getDataHoraInicial());
    }

    @Test
    public void deveFormatarDataHoraFinalSemSegundos() {
        final NFCeListagemChaves listagemChaves = new NFCeListagemChaves();
        listagemChaves.setDataHoraFinal(LocalDateTime.of(2026, 7, 21, 23, 59, 0));
        Assert.assertEquals("2026-07-21T23:59", listagemChaves.getDataHoraFinal());
    }

    @Test
    public void devePermitirDataHoraFinalNula() {
        final NFCeListagemChaves listagemChaves = new NFCeListagemChaves();
        listagemChaves.setDataHoraFinal(null);
        Assert.assertNull(listagemChaves.getDataHoraFinal());
    }
}

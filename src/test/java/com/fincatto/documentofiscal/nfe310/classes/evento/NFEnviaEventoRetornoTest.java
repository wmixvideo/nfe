package com.fincatto.documentofiscal.nfe310.classes.evento;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NFEnviaEventoRetornoTest {

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFEnviaEventoRetorno eventoRetorno = new NFEnviaEventoRetorno();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        eventoRetorno.setAmbiente(ambiente);
        Assertions.assertEquals(ambiente, eventoRetorno.getAmbiente());
    }

    @Test
    public void deveObterCodigoStatusRepostaComoFoiSetado() {
        final NFEnviaEventoRetorno eventoRetorno = new NFEnviaEventoRetorno();
        final int codigoStatusReposta = 900;
        eventoRetorno.setCodigoStatusReposta(codigoStatusReposta);
        Assertions.assertEquals(codigoStatusReposta, eventoRetorno.getCodigoStatusReposta(), 0);
    }

    @Test
    public void deveObterEventoRetornoComoFoiSetado() {
        final NFEnviaEventoRetorno eventoRetorno = new NFEnviaEventoRetorno();
        final ArrayList<NFEventoRetorno> eventosRetorno = new ArrayList<>();
        eventoRetorno.setEventoRetorno(eventosRetorno);
        Assertions.assertEquals(eventosRetorno, eventoRetorno.getEventoRetorno());
    }

    @Test
    public void deveObterIdLoteComoFoiSetado() {
        final NFEnviaEventoRetorno eventoRetorno = new NFEnviaEventoRetorno();
        final String idLote = "99";
        eventoRetorno.setIdLote(idLote);
        Assertions.assertEquals(idLote, eventoRetorno.getIdLote());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFEnviaEventoRetorno eventoRetorno = new NFEnviaEventoRetorno();
        final String motivo = "Motivo turpe";
        eventoRetorno.setMotivo(motivo);
        Assertions.assertEquals(motivo, eventoRetorno.getMotivo());
    }

    @Test
    public void deveObterOrgaoComoFoiSetado() {
        final NFEnviaEventoRetorno eventoRetorno = new NFEnviaEventoRetorno();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.SC;
        eventoRetorno.setOrgao(unidadeFederativa);
        Assertions.assertEquals(unidadeFederativa, eventoRetorno.getOrgao());
    }

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFEnviaEventoRetorno eventoRetorno = new NFEnviaEventoRetorno();
        final String versao = "3.10";
        eventoRetorno.setVersao(versao);
        Assertions.assertEquals(versao, eventoRetorno.getVersao());
    }

    @Test
    public void deveObterVersaoAplicativoComoFoiSetado() {
        final NFEnviaEventoRetorno eventoRetorno = new NFEnviaEventoRetorno();
        final String versaoAplicativo = "v10.0";
        eventoRetorno.setVersaoAplicativo(versaoAplicativo);
        Assertions.assertEquals(versaoAplicativo, eventoRetorno.getVersaoAplicativo());
    }
}
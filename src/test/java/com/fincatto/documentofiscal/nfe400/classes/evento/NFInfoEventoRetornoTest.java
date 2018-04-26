package com.fincatto.documentofiscal.nfe400.classes.evento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;

public class NFInfoEventoRetornoTest {

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        eventoRetorno.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, eventoRetorno.getAmbiente());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final String chave = "27453083767543876731879602388114613152665633";
        eventoRetorno.setChave(chave);
        Assert.assertEquals(chave, eventoRetorno.getChave());
    }

    @Test
    public void deveObterCodigoStatusComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final int codigoStatus = 100;
        eventoRetorno.setCodigoStatus(codigoStatus);
        Assert.assertEquals(codigoStatus, eventoRetorno.getCodigoStatus(), 0);
    }

    @Test
    public void deveObterCPFComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final String cpf = "23999597116";
        eventoRetorno.setCpf(cpf);
        Assert.assertEquals(cpf, eventoRetorno.getCpf());
    }

    @Test
    public void deveObterCNPJComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final String cnpj = "55745965229517";
        eventoRetorno.setCpnj(cnpj);
        Assert.assertEquals(cnpj, eventoRetorno.getCpnj());
    }

    @Test
    public void deveObterDataHoraRegistroComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final LocalDateTime dataHoraRegistro = LocalDateTime.parse("2010-10-10 10:10:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        eventoRetorno.setDataHoraRegistro(dataHoraRegistro);
        Assert.assertEquals(dataHoraRegistro, eventoRetorno.getDataHoraRegistro());
    }

    @Test
    public void deveObterDescricaoEventoComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final String descricaoEvento = "Carta de correcao";
        eventoRetorno.setDescricaoEvento(descricaoEvento);
        Assert.assertEquals(descricaoEvento, eventoRetorno.getDescricaoEvento());
    }

    @Test
    public void deveObterEmailComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final String email = "teste@teste.com";
        eventoRetorno.setEmail(email);
        Assert.assertEquals(email, eventoRetorno.getEmail());
    }

    @Test
    public void deveObterIdComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final String id = "identificador";
        eventoRetorno.setId(id);
        Assert.assertEquals(id, eventoRetorno.getId());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final String motivo = "motivo de teste";
        eventoRetorno.setMotivo(motivo);
        Assert.assertEquals(motivo, eventoRetorno.getMotivo());
    }

    @Test
    public void deveObterNumeroProtocoloComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final String numeroProtocolo = "132456789";
        eventoRetorno.setNumeroProtocolo(numeroProtocolo);
        Assert.assertEquals(numeroProtocolo, eventoRetorno.getNumeroProtocolo());
    }

    @Test
    public void deveObterNumeroSequencialEventoComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final int numeroSequencialEvento = 1;
        eventoRetorno.setNumeroSequencialEvento(numeroSequencialEvento);
        Assert.assertEquals(numeroSequencialEvento, eventoRetorno.getNumeroSequencialEvento(), 0);
    }

    @Test
    public void deveObterOrgaoComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.AC;
        eventoRetorno.setOrgao(unidadeFederativa);
        Assert.assertEquals(unidadeFederativa, eventoRetorno.getOrgao());
    }

    @Test
    public void deveObterTipoEventoComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final String tipoEvento = "150";
        eventoRetorno.setTipoEvento(tipoEvento);
        Assert.assertEquals(tipoEvento, eventoRetorno.getTipoEvento());
    }

    @Test
    public void deveObterVersaoAplicacaoComoFoiSetado() {
        final NFInfoEventoRetorno eventoRetorno = new NFInfoEventoRetorno();
        final String versaoAplicativo = "v10.0";
        eventoRetorno.setVersaoAplicativo(versaoAplicativo);
        Assert.assertEquals(versaoAplicativo, eventoRetorno.getVersaoAplicativo());
    }
}
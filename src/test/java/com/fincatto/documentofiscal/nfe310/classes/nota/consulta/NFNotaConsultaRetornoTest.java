package com.fincatto.documentofiscal.nfe310.classes.nota.consulta;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFProtocolo;
import com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento.NFRetornoCancelamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NFNotaConsultaRetornoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final String versao = "3.10";
        consultaRetorno.setVersao(versao);
        Assertions.assertEquals(versao, consultaRetorno.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        consultaRetorno.setAmbiente(ambiente);
        Assertions.assertEquals(ambiente, consultaRetorno.getAmbiente());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final String chave = "70460574637515066066966657989989378421243260";
        consultaRetorno.setChave(chave);
        Assertions.assertEquals(chave, consultaRetorno.getChave());
    }

    @Test
    public void deveObterDataHoraReciboComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final LocalDateTime dataHoraRecibo = LocalDateTime.parse("2010-10-10 10:10:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        consultaRetorno.setDataHoraRecibo(dataHoraRecibo);
        Assertions.assertEquals(dataHoraRecibo, consultaRetorno.getDataHoraRecibo());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final String motivo = "Motivo simples";
        consultaRetorno.setMotivo(motivo);
        Assertions.assertEquals(motivo, consultaRetorno.getMotivo());
    }

    @Test
    public void deveObterProtocoloComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final NFProtocolo protocolo = FabricaDeObjetosFake.getNFProtocolo();
        consultaRetorno.setProtocolo(protocolo);
        Assertions.assertEquals(protocolo, consultaRetorno.getProtocolo());
    }

    @Test
    public void deveObterStatusComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final String status = "190";
        consultaRetorno.setStatus(status);
        Assertions.assertEquals(status, consultaRetorno.getStatus());
    }

    @Test
    public void deveObterUfComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.AL;
        consultaRetorno.setUf(unidadeFederativa);
        Assertions.assertEquals(unidadeFederativa, consultaRetorno.getUf());
    }

    @Test
    public void deveObterVersaoAplicativoComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final String versaoAplicacao = "v10.0";
        consultaRetorno.setVersaoAplicacao(versaoAplicacao);
        Assertions.assertEquals(versaoAplicacao, consultaRetorno.getVersaoAplicacao());
    }

    @Test
    public void deveObterProtocoloCancelamentoComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final NFRetornoCancelamento protocoloCancelamento = new NFRetornoCancelamento();
        consultaRetorno.setProtocoloCancelamento(protocoloCancelamento);
        Assertions.assertEquals(protocoloCancelamento, consultaRetorno.getProtocoloCancelamento());
    }

    @Test
    public void deveObterProtocoloEventoComoFoiSetado() {
        final NFNotaConsultaRetorno consultaRetorno = new NFNotaConsultaRetorno();
        final List<NFProtocoloEvento> protocoloEvento = new ArrayList<>();
        consultaRetorno.setProtocoloEvento(protocoloEvento);
        Assertions.assertEquals(protocoloEvento, consultaRetorno.getProtocoloEvento());
    }
}
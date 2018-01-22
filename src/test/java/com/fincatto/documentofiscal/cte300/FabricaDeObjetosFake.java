package com.fincatto.documentofiscal.cte300;

import java.util.Calendar;
import java.util.Collections;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte300.classes.*;
import com.fincatto.documentofiscal.cte300.classes.nota.*;

public class FabricaDeObjetosFake {

    public static CTeNotaInfo getCTeNotaInfo() {
        final CTeNotaInfo info = new CTeNotaInfo();
        info.setVersao("3.00");
        info.setIdentificador("12345678901234567890123456789012345678901234");
        info.setIdentificacao(FabricaDeObjetosFake.getInfoIdentificador());
        info.setDadosComplementares(FabricaDeObjetosFake.getInfoDadosComplementares());
        return info;
    }

    public static CTeNotaInfoDadosComplementares getInfoDadosComplementares() {
        final CTeNotaInfoDadosComplementares dadosComplementares = new CTeNotaInfoDadosComplementares();
        dadosComplementares.setCaracteristicasTransporte("ENTREGA");
        dadosComplementares.setCaracteristicasServico("ENTREGA");
        dadosComplementares.setFuncionarioEmissor("Joao da Silva");
        dadosComplementares.setFluxo(FabricaDeObjetosFake.getFluxo());
        dadosComplementares.setEntrega(FabricaDeObjetosFake.getEntrega());
        dadosComplementares.setMunicipioOrigem("Florianopolis");
        dadosComplementares.setMunicipioDestino("Florianopolis");
        dadosComplementares.setObservacaoGeral("Observacao geral");
        return dadosComplementares;
    }

    public static CTeNotaInfoDadosComplementaresObservacaoContribuinte getObservacaoContribuinte() {
        final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacaoContribuinte = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
        observacaoContribuinte.setCampo("Observacao geral");
        observacaoContribuinte.setTexto("Texto de informacoes do contribuinte");
        return observacaoContribuinte;
    }

    public static CTeNotaInfoDadosComplementaresEntrega getEntrega() {
        final CTeNotaInfoDadosComplementaresEntrega entrega = new CTeNotaInfoDadosComplementaresEntrega();
        entrega.setEntregaComDataDefinida(FabricaDeObjetosFake.getEntregaComDataDefinida());
        return entrega;
    }

    public static CTeNotaInfoDadosComplementaresEntregaComDataDefinida getEntregaComDataDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaComDataDefinida entregaComDataDefinida = new CTeNotaInfoDadosComplementaresEntregaComDataDefinida();
        entregaComDataDefinida.setDataProgramada(LocalDate.now());
        entregaComDataDefinida.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.NA_DATA);
        return entregaComDataDefinida;
    }

    public static CTeNotaInfoDadosComplementaresEntregaComHoraDefinida getEntregaComHoraDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaComHoraDefinida entregaComHoraDefinida = new CTeNotaInfoDadosComplementaresEntregaComHoraDefinida();
        entregaComHoraDefinida.setHoraProgramada(FabricaDeObjetosFake.getLocalTime());
        entregaComHoraDefinida.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.ATE_A_HORARIO);
        return entregaComHoraDefinida;
    }

    public static CTeNotaInfoDadosComplementaresEntregaIntervalo getEntregaIntervalo() {
        final CTeNotaInfoDadosComplementaresEntregaIntervalo entregaIntervalo = new CTeNotaInfoDadosComplementaresEntregaIntervalo();
        entregaIntervalo.setHoraInicio(FabricaDeObjetosFake.getLocalTime());
        entregaIntervalo.setHoraFim(FabricaDeObjetosFake.getLocalTime());
        entregaIntervalo.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.ATE_A_HORARIO);
        return entregaIntervalo;
    }

    public static CTeNotaInfoDadosComplementaresEntregaSemDataDefinida getEntregaSemDataDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaSemDataDefinida entregaSemDataDefinida = new CTeNotaInfoDadosComplementaresEntregaSemDataDefinida();
        entregaSemDataDefinida.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.A_PARTIR_DA_DATA);
        return entregaSemDataDefinida;
    }

    public static CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida getEntregaSemHoraDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida entregaSemHoraDefinida = new CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida();
        entregaSemHoraDefinida.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.A_PARTIR_DO_HORARIO);
        return entregaSemHoraDefinida;
    }

    public static CTeNotaInfoDadosComplementaresEntregaPeriodo getEntregaPeriodo() {
        final CTeNotaInfoDadosComplementaresEntregaPeriodo entregaPeriodo = new CTeNotaInfoDadosComplementaresEntregaPeriodo();
        entregaPeriodo.setDataInicio(FabricaDeObjetosFake.getLocalDate());
        entregaPeriodo.setDataFim(FabricaDeObjetosFake.getLocalDate());
        entregaPeriodo.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.NO_PERIODO);
        return entregaPeriodo;
    }

    public static CTeNotaInfoDadosComplementaresFluxo getFluxo() {
        final CTeNotaInfoDadosComplementaresFluxo fluxo = new CTeNotaInfoDadosComplementaresFluxo();
        fluxo.setOrigem("Florianopolis");
        fluxo.setPass(Collections.singletonList(FabricaDeObjetosFake.getFluxoPass()));
        fluxo.setDestino("Florianopolis");
        fluxo.setRota("Florianopolis");
        return fluxo;
    }

    public static CTeNotaInfoDadosComplementaresFluxoPass getFluxoPass() {
        final CTeNotaInfoDadosComplementaresFluxoPass fluxoPass = new CTeNotaInfoDadosComplementaresFluxoPass();
        fluxoPass.setPass("IATA");
        return fluxoPass;
    }

    public static CTeNotaInfoIdentificacao getInfoIdentificador() {
        final CTeNotaInfoIdentificacao identificacao = new CTeNotaInfoIdentificacao();
        identificacao.setCodigoUF(DFUnidadeFederativa.SC);
        identificacao.setCodigoNumerico("67890123");
        identificacao.setCfop("5353");
        identificacao.setNaturezaOperacao("Prestacao de servico de transporte a estabelecimento comercial");
        identificacao.setModelo(DFModelo.CTE);
        identificacao.setSerie(1);
        identificacao.setNumero(123);
        identificacao.setDataEmissao(FabricaDeObjetosFake.getLocalDateTime());
        identificacao.setTipoImpressao(CTTipoImpressao.RETRATO);
        identificacao.setTipoEmissao(CTTipoEmissao.EMISSAO_NORMAL);
        identificacao.setDigitoVerificador(4);
        identificacao.setAmbiente(DFAmbiente.HOMOLOGACAO);
        identificacao.setFinalidade(CTFinalidade.NORMAL);
        identificacao.setProcessoEmissao(CTProcessoEmissao.EMISSOR_CONTRIBUINTE);
        identificacao.setVersaoProcessoEmissao("1.00");
        identificacao.setIndicadorGlobalizado(1);
        identificacao.setCodigoMunicipioEnvio("4205407");
        identificacao.setDescricaoMunicipioEnvio("FLORIANOPOLIS");
        identificacao.setSiglaUFEnvio("SC");
        identificacao.setModalidadeFrete(CTModal.RODOVIARIO);
        identificacao.setTipoServico(CTTipoServico.NORMAL);
        identificacao.setCodigoMunicipioInicio("4205407");
        identificacao.setDescricaoMunicipioInicio("FLORIANOPOLIS");
        identificacao.setSiglaUfInicio("SC");
        identificacao.setCodigoMunicipioFim("4205407");
        identificacao.setDescricaoMunicipioFim("FLORIANOPOLIS");
        identificacao.setSiglaUfFim("SC");
        identificacao.setRetira(CTRetirada.NAO);
        identificacao.setDetalheRetira("Nao retira");
        identificacao.setIndIEToma(CTIndicadorTomador.NÃO_CONTRIBUINTE);
        identificacao.setTomadorServico3(FabricaDeObjetosFake.getTomadorServico3());
        identificacao.setDataContingencia(null);
        identificacao.setJustificativa(null);
        return identificacao;
    }

    public static CTeNotaInfoIdentificacaoTomadorServico3 getTomadorServico3() {
        final CTeNotaInfoIdentificacaoTomadorServico3 tomador3 = new CTeNotaInfoIdentificacaoTomadorServico3();
        tomador3.setTomadorServico(CTTomadorServico.RECEBEDOR);
        return tomador3;
    }

    public static CTeNotaInfoIdentificacaoTomadorServico4 getTomadorServico4() {
        final CTeNotaInfoIdentificacaoTomadorServico4 tomador4 = new CTeNotaInfoIdentificacaoTomadorServico4();
        tomador4.setCnpj("12345678901234");
        tomador4.setCpf("00000000000");
        tomador4.setInscricaoEstadual("ISENTO");
        tomador4.setRazaoSocial("RAZAO SOCIAL TOMADOR");
        tomador4.setNomeFantasia("NOME FANTASIA");
        tomador4.setTelefone("4830000000");
        tomador4.setEnderTomadorServico(FabricaDeObjetosFake.getEndereco());
        tomador4.setEmail("teste@teste.com.br");
        return tomador4;
    }

    public static CTeNotaEndereco getEndereco() {
        final CTeNotaEndereco endereco = new CTeNotaEndereco();
        endereco.setLogradouro("RUA ANITA GARIBALDI");
        endereco.setNumero("1");
        endereco.setComplemento("SALA 1");
        endereco.setBairro("CENTRO");
        endereco.setCodigoMunicipio("4205407");
        endereco.setDescricaoMunicipio("FLORIANOPOLIS");
        endereco.setCep("88010500");
        endereco.setSiglaUF("SC");
        endereco.setCodigoPais("1058");
        endereco.setDescricaoPais("BRASIL");
        return endereco;
    }

    public static LocalDateTime getLocalDateTime() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.JANUARY, 22, 10, 10, 10);
        return LocalDateTime.fromCalendarFields(calendar);
    }

    public static LocalDate getLocalDate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.JANUARY, 22, 10, 10, 10);
        return LocalDate.fromCalendarFields(calendar);
    }

    public static LocalTime getLocalTime() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.JANUARY, 22, 10, 10, 10);
        return LocalTime.fromCalendarFields(calendar);
    }
}

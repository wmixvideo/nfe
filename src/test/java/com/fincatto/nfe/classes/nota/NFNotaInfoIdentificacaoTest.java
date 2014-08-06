package com.fincatto.nfe.classes.nota;

import java.util.Arrays;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;
import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.NFUnidadeFederativa;
import com.fincatto.nfe.classes.NFFinalidade;
import com.fincatto.nfe.classes.NFFormaPagamento;
import com.fincatto.nfe.classes.NFProgramaEmissor;
import com.fincatto.nfe.classes.NFTipo;
import com.fincatto.nfe.classes.NFTipoEmissao;
import com.fincatto.nfe.classes.NFTipoImpressao;

public class NFNotaInfoIdentificacaoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVersaoEmissorComTamanhoInvalido() {
        try {
            new NFNotaInfoIdentificacao().setVersaoEmissor("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoIdentificacao().setVersaoEmissor("532ng7VURPgovC5BYaZy1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirJustificativaEntradaContingenciaComTamanhoInvalido() {
        try {
            new NFNotaInfoIdentificacao().setJustificativaEntradaContingencia("b1Aj7VBU5I0LDt");
        } catch (final IllegalStateException e) {
            new NFNotaInfoIdentificacao().setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSerieComTamanhoInvalido() {
        new NFNotaInfoIdentificacao().setSerie(1000);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNotaComTamanhoInvalido() {
        new NFNotaInfoIdentificacao().setNumeroNota(1000000000);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNaturezaOperacaoComTamanhoInvalido() {
        try {
            new NFNotaInfoIdentificacao().setNaturezaOperacao("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoIdentificacao().setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloComTamanhoInvalido() {
        try {
            new NFNotaInfoIdentificacao().setModelo("A");
        } catch (final IllegalStateException e) {
            new NFNotaInfoIdentificacao().setModelo("qGY");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDigitoVerificadorComTamanhoInvalido() {
        new NFNotaInfoIdentificacao().setDigitoVerificador(10);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoRandomicoComTamanhoInvalido() {
        try {
            new NFNotaInfoIdentificacao().setCodigoRandomico("qGYcW8I");
        } catch (final IllegalStateException e) {
            new NFNotaInfoIdentificacao().setCodigoRandomico("qGYcW8I1i");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoMunicipioComTamanhoInvalido() {
        try {
            new NFNotaInfoIdentificacao().setCodigoMunicipio("qGYcW8");
        } catch (final IllegalStateException e) {
            new NFNotaInfoIdentificacao().setCodigoMunicipio("qGYcW8I1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAmbienteNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoMunicipioNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoRandomicoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDataEmissaoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test
    public void devePermitirDataSaidaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDigitoVerificadorNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFinalidadeNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFormaPagamentoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test
    public void devePermitirHoraSaidaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNaturezaOperacaoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNotaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirProgramaEmissorNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test
    public void devePermitirReferenciadasNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSerieNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoEmissaoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoImpressaoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUfNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVersaoEmissorNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test
    public void devePermitirDataHoraContigenciaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.toString();
    }

    @Test
    public void devePermitirJustificativaEntradaContingenciaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("surKkNg");
        identificacao.setCodigoRandomico("xtPxtRjg");
        identificacao.setDataEmissao(new LocalDate(2010, 10, 27));
        identificacao.setDataSaida(new LocalDate(2013, 9, 24));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamento.A_PRAZO);
        identificacao.setHoraSaida(new LocalTime(12, 11, 10));
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota(999999999);
        identificacao.setProgramaEmissor(NFProgramaEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie(999);
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoIdentificacao><cUF>42</cUF><cNF>xtPxtRjg</cNF><natOp>qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ</natOp><indPag>1</indPag><mod>AA</mod><serie>999</serie><nNF>999999999</nNF><dEmi>2010-10-27</dEmi><dSaiEnt>2013-09-24</dSaiEnt><hSaiEnt>12:11:10</hSaiEnt><tpNF>0</tpNF><cMunFG>surKkNg</cMunFG><NFref><refNFe>Vrf4YXN3J1cZJpTrnKt1uOAO80JBm6aO4r1zT7Q94Qkt</refNFe><refNF><cUF>42</cUF><AAMM>1408</AAMM><CNPJ>12345678901234</CNPJ><mod>A1</mod><serie>999</serie><nNF>999999999</nNF><refNFP><cUF>42</cUF><AAMM>1402</AAMM><CNPJ>12345678901234</CNPJ><IE>ISENTO</IE><mod>IE</mod><serie>999</serie><nNF>999999</nNF><refCTe>y6VaIDjj1UClKz2JxTEJy4YhXqA18sNF7T6HxQpnoJ9L</refCTe></refNFP><refECF><mod>A2</mod><nECF>a71</nECF><nCOO>NUQvJH</nCOO></refECF></refNF></NFref><tpImp>2</tpImp><tpEmis>1</tpEmis><cDV>8</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><procEmi>0</procEmi><verProc>532ng7VURPgovC5BYaZy</verProc><dhCont>2014-10-10T10:10:10</dhCont><xJust>b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV</xJust></NFNotaInfoIdentificacao>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoIdentificacao().toString());
    }
}
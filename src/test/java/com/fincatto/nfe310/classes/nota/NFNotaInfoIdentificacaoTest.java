package com.fincatto.nfe310.classes.nota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFFinalidade;
import com.fincatto.nfe310.classes.NFFormaPagamentoPrazo;
import com.fincatto.nfe310.classes.NFProcessoEmissor;
import com.fincatto.nfe310.classes.NFTipo;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFTipoImpressao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public class NFNotaInfoIdentificacaoTest {

    @Test
    public void devePermitirReferenciadasComTamanhoInvalido() {
        final List<NFInfoReferenciada> referenciadas = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            referenciadas.add(new NFInfoReferenciada());
        }
        new NFNotaInfoIdentificacao().setReferenciadas(referenciadas);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirReferenciadasComTamanhoInvalido() {
        final List<NFInfoReferenciada> referenciadas = new ArrayList<>();
        for (int i = 0; i < 501; i++) {
            referenciadas.add(new NFInfoReferenciada());
        }
        new NFNotaInfoIdentificacao().setReferenciadas(referenciadas);
    }

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
        new NFNotaInfoIdentificacao().setSerie("1000");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNotaComTamanhoInvalido() {
        new NFNotaInfoIdentificacao().setNumeroNota("1000000000");
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

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirDigitoVerificadorComTamanhoInvalido() {
        new NFNotaInfoIdentificacao().setDigitoVerificador(10);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoRandomicoComTamanhoInvalido() {
        try {
            new NFNotaInfoIdentificacao().setCodigoRandomico("9999999");
        } catch (final IllegalStateException e) {
            new NFNotaInfoIdentificacao().setCodigoRandomico("100000000");
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
    public void naoDevePermitirIndicadorPresencaCompradorNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOperacaoConsumidorFinalNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdentificadorLocalDestinoOperacaoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirAmbienteNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoMunicipioNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoRandomicoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDataEmissaoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test
    public void devePermitirDataSaidaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDigitoVerificadorNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFinalidadeNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirFormaPagamentoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNaturezaOperacaoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroNotaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirProgramaEmissorNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test
    public void devePermitirReferenciadasNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSerieNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoEmissaoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirTipoImpressaoNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUfNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVersaoEmissorNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test
    public void devePermitirDataHoraContigenciaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test
    public void devePermitirJustificativaEntradaContingenciaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(NFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999999");
        identificacao.setDataHoraEmissao(new LocalDateTime(2010, 10, 27, 10, 10, 10));
        identificacao.setDataHoraSaidaOuEntrada(new LocalDateTime(2013, 9, 24, 10, 10, 10));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setFormaPagamento(NFFormaPagamentoPrazo.A_PRAZO);
        identificacao.setModelo("AA");
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Arrays.asList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(NFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(new LocalDateTime(2014, 10, 10, 10, 10, 10));
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.CONSUMIDOR_FINAL);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoIdentificacao><cUF>43</cUF><cNF>99999999</cNF><natOp>qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ</natOp><indPag>1</indPag><mod>55</mod><serie>999</serie><nNF>999999999</nNF><dhEmi>2010-10-27T10:10:10-02:00</dhEmi><dhSaiEnt>2013-09-24T10:10:10-03:00</dhSaiEnt><tpNF>0</tpNF><idDest>1</idDest><cMunFG>1612675</cMunFG><tpImp>2</tpImp><tpEmis>1</tpEmis><cDV>8</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>0</indPres><procEmi>0</procEmi><verProc>532ng7VURPgovC5BYaZy</verProc><dhCont>2014-10-10T10:10:10-03:00</dhCont><xJust>b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV</xJust><NFref><refCTe>19506188293993666630760813709064781438945816</refCTe></NFref></NFNotaInfoIdentificacao>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoIdentificacao().toString());
    }
}
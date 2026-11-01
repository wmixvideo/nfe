package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFFinalidade;
import com.fincatto.documentofiscal.nfe400.classes.NFProcessoEmissor;
import com.fincatto.documentofiscal.nfe400.classes.NFTipo;
import com.fincatto.documentofiscal.nfe400.classes.NFTipoImpressao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NFNotaInfoIdentificacaoTest {

    @Test
    public void devePermitirReferenciadasComTamanhoInvalido() {
        final List<NFInfoReferenciada> referenciadas = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            referenciadas.add(new NFInfoReferenciada());
        }
        new NFNotaInfoIdentificacao().setReferenciadas(referenciadas);
    }

    @Test
    public void naoDevePermitirReferenciadasComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final List<NFInfoReferenciada> referenciadas = new ArrayList<>();
            for (int i = 0; i < 501; i++) {
                referenciadas.add(new NFInfoReferenciada());
            }
            new NFNotaInfoIdentificacao().setReferenciadas(referenciadas);
        });
    }

    @Test
    public void naoDevePermitirVersaoEmissorComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoIdentificacao().setVersaoEmissor("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoIdentificacao().setVersaoEmissor("532ng7VURPgovC5BYaZy1");
            }
        });
    }

    @Test
    public void naoDevePermitirJustificativaEntradaContingenciaComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoIdentificacao().setJustificativaEntradaContingencia("b1Aj7VBU5I0LDt");
            } catch (final IllegalStateException e) {
                new NFNotaInfoIdentificacao().setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV1");
            }
        });
    }

    @Test
    public void naoDevePermitirSerieComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoIdentificacao().setSerie("1000"));
    }

    @Test
    public void naoDevePermitirNumeroNotaComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoIdentificacao().setNumeroNota("1000000000"));
    }

    @Test
    public void naoDevePermitirNaturezaOperacaoComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoIdentificacao().setNaturezaOperacao("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoIdentificacao().setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ1");
            }
        });
    }

    @Test
    public void naoDevePermitirDigitoVerificadorComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoIdentificacao().setDigitoVerificador(10));
    }

    @Test
    public void naoDevePermitirCodigoRandomicoComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoIdentificacao().setCodigoRandomico("9999999");
            } catch (final IllegalStateException e) {
                new NFNotaInfoIdentificacao().setCodigoRandomico("100000000");
            }
        });
    }

    @Test
    public void naoDevePermitirCodigoMunicipioComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoIdentificacao().setCodigoMunicipio("qGYcW8");
            } catch (final IllegalStateException e) {
                new NFNotaInfoIdentificacao().setCodigoMunicipio("qGYcW8I1");
            }
        });
    }

    @Test
    public void naoDevePermitirCodigoRandomicoComValorInvalido() {
        String[] codigosInvalidos = new String[]{"00000000", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999", "12345678", "23456789", "34567890", "45678901", "56789012", "67890123", "78901234", "89012345", "90123456", "01234567"};
        int countExceptions = 0;
        for (String codigo : codigosInvalidos) {
            try {
                new NFNotaInfoIdentificacao().setCodigoRandomico(codigo);
            } catch (final IllegalStateException e) {
                countExceptions += 1;
            }
        }
        Assertions.assertEquals(countExceptions, codigosInvalidos.length);
    }

    @Test
    public void naoDevePermitirCodigoRandomicoENumeroNotaIguais() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            NFNotaInfoIdentificacao nfNotaInfoIdentificacao = new NFNotaInfoIdentificacao();
            try {
                nfNotaInfoIdentificacao.setNumeroNota("000001564");
                nfNotaInfoIdentificacao.setCodigoRandomico("00001564");
            } catch (final IllegalStateException e) {
                nfNotaInfoIdentificacao.setCodigoRandomico("00000001");
                nfNotaInfoIdentificacao.setNumeroNota("000000001");
            }
        });
    }
    
    @Test
    public void devePermitirCodigoRandomicoENumeroNotaDiferentes() {
        NFNotaInfoIdentificacao nfNotaInfoIdentificacao = new NFNotaInfoIdentificacao();
        nfNotaInfoIdentificacao.setNumeroNota("000001563");
        nfNotaInfoIdentificacao.setCodigoRandomico("00001565");
        
        NFNotaInfoIdentificacao nfNotaInfoIdentificacao2 = new NFNotaInfoIdentificacao();
        nfNotaInfoIdentificacao2.setNumeroNota("000001565");
        nfNotaInfoIdentificacao2.setCodigoRandomico("00001563");
    }

    @Test
    public void naoDevePermitirIndicadorPresencaCompradorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirOperacaoConsumidorFinalNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirIdentificadorLocalDestinoOperacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirAmbienteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirCodigoMunicipioNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirCodigoRandomicoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirDataEmissaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void devePermitirDataSaidaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(DFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999998");
        identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setModelo(DFModelo.NFE);
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(DFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test
    public void naoDevePermitirDigitoVerificadorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirFinalidadeNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirModeloNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirNaturezaOperacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirNumeroNotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirProgramaEmissorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void devePermitirReferenciadasNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(DFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999998");
        identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setModelo(DFModelo.NFE);
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(DFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test
    public void naoDevePermitirSerieNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirTipoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirTipoEmissaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirTipoImpressaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirUfNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void naoDevePermitirVersaoEmissorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
            identificacao.setAmbiente(DFAmbiente.PRODUCAO);
            identificacao.setCodigoMunicipio("1612675");
            identificacao.setCodigoRandomico("99999998");
            identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setDigitoVerificador(8);
            identificacao.setFinalidade(NFFinalidade.NORMAL);
            identificacao.setModelo(DFModelo.NFE);
            identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
            identificacao.setNumeroNota("999999999");
            identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
            identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
            identificacao.setSerie("999");
            identificacao.setTipo(NFTipo.ENTRADA);
            identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
            identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
            identificacao.setUf(DFUnidadeFederativa.SC);
            identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
            identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
            identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
            identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
            identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
            identificacao.toString();
        });
    }

    @Test
    public void devePermitirDataHoraContigenciaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(DFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999998");
        identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setModelo(DFModelo.NFE);
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(DFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setJustificativaEntradaContingencia("b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV");
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test
    public void devePermitirJustificativaEntradaContingenciaNulo() {
        final NFNotaInfoIdentificacao identificacao = new NFNotaInfoIdentificacao();
        identificacao.setAmbiente(DFAmbiente.PRODUCAO);
        identificacao.setCodigoMunicipio("1612675");
        identificacao.setCodigoRandomico("99999998");
        identificacao.setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-27 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setDataHoraSaidaOuEntrada(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2013-09-24 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setDigitoVerificador(8);
        identificacao.setFinalidade(NFFinalidade.NORMAL);
        identificacao.setModelo(DFModelo.NFE);
        identificacao.setNaturezaOperacao("qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ");
        identificacao.setNumeroNota("999999999");
        identificacao.setProgramaEmissor(NFProcessoEmissor.CONTRIBUINTE);
        identificacao.setReferenciadas(Collections.singletonList(FabricaDeObjetosFake.getNFInfoReferenciada()));
        identificacao.setSerie("999");
        identificacao.setTipo(NFTipo.ENTRADA);
        identificacao.setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
        identificacao.setTipoImpressao(NFTipoImpressao.DANFE_NORMAL_PAISAGEM);
        identificacao.setUf(DFUnidadeFederativa.SC);
        identificacao.setVersaoEmissor("532ng7VURPgovC5BYaZy");
        identificacao.setDataHoraContigencia(ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setIdentificadorLocalDestinoOperacao(NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
        identificacao.setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
        identificacao.setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
        identificacao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoIdentificacao><cUF>43</cUF><cNF>99999998</cNF><natOp>qGYcW8I1iak14NF7vnfc8XpPYkrHWB5J7Vm3eOAe57azf1fVP7vEOY7TrRVQ</natOp><mod>55</mod><serie>999</serie><nNF>999999999</nNF><dhEmi>2010-10-27T10:10:10-02:00</dhEmi><dhSaiEnt>2013-09-24T10:10:10-03:00</dhSaiEnt><tpNF>0</tpNF><idDest>1</idDest><cMunFG>1612675</cMunFG><tpImp>2</tpImp><tpEmis>1</tpEmis><cDV>8</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>0</indPres><indIntermed>0</indIntermed><procEmi>0</procEmi><verProc>532ng7VURPgovC5BYaZy</verProc><dhCont>2014-10-10T10:10:10-03:00</dhCont><xJust>b1Aj7VBU5I0LDthlrWTk73otsFXSVbiNYyAgGZjLYT0pftpjhGzQEAtnolQoAEB3omnxNq8am4iMqwwviuaXRHjiYWY7YaPITlDN7cDN9obnhEqhDhkgKphRBY5frTfD6unwTB4w7j6hpY2zNNzWwbNJzPGgDmQ8WhBDnpq1fQOilrcDspY7SGkNDfjxpGTQyNSNsmF4B2uHHLhGhhxG2qVq2bFUvHFqSL8atQAuYpyn3wplW21v88N96PnF0MEV</xJust><NFref><refCTe>19506188293993666630760813709064781438945816</refCTe></NFref></NFNotaInfoIdentificacao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoIdentificacao().toString());
    }
}
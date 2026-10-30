package com.fincatto.documentofiscal.nfe400.danfe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Testes das formatacoes do DANFE.
 *
 * @author Marcos Lombardi de Andrade
 */
class DanfeFormatadorTest {

    @Test
    void deveFormatarCnpjECpf() {
        Assertions.assertEquals("11.111.111/0001-91", DanfeFormatador.cnpjOuCpf("11111111000191"));
        Assertions.assertEquals("123.456.789-09", DanfeFormatador.cnpjOuCpf("12345678909"));
        Assertions.assertEquals("123", DanfeFormatador.cnpjOuCpf("123"));
    }

    @Test
    void deveFormatarChaveDeAcessoEmGruposDeQuatro() {
        final String chave = "35170399999999999999550010000000011000000015";
        Assertions.assertEquals("3517 0399 9999 9999 9999 5500 1000 0000 0110 0000 0015", DanfeFormatador.chaveAcesso(chave));
    }

    @Test
    void deveFormatarNumeroESerie() {
        Assertions.assertEquals("N\u00ba 000.000.001", DanfeFormatador.numeroNota("1"));
        Assertions.assertEquals("N\u00ba 123.456.789", DanfeFormatador.numeroNota("123456789"));
        Assertions.assertEquals("001", DanfeFormatador.serie("1"));
    }

    @Test
    void deveCompletarCasasDecimaisMinimasSemCortarAsExistentes() {
        Assertions.assertEquals("50,00", DanfeFormatador.valor("50", 2));
        Assertions.assertEquals("2,00", DanfeFormatador.valor("2", 2));
        Assertions.assertEquals("1.234,50", DanfeFormatador.valor("1234.5", 2));
        Assertions.assertEquals("0,12345", DanfeFormatador.valor("0.12345", 2));
        Assertions.assertEquals("", DanfeFormatador.valor(null, 2));
        Assertions.assertEquals("abc", DanfeFormatador.valor("abc", 2));
    }

    @Test
    void deveFormatarValoresMantendoCasasDoXml() {
        Assertions.assertEquals("1.234,5", DanfeFormatador.valor("1234.5"));
        Assertions.assertEquals("0,00", DanfeFormatador.valor("0.00"));
        Assertions.assertEquals("1.234.567,8900", DanfeFormatador.valor("1234567.8900"));
        Assertions.assertEquals("-1.000,00", DanfeFormatador.valor("-1000.00"));
    }

    @Test
    void deveFormatarDataEHora() {
        final ZonedDateTime data = ZonedDateTime.of(2026, 12, 1, 14, 5, 9, 0, ZoneId.of("America/Sao_Paulo"));
        Assertions.assertEquals("01/12/2026", DanfeFormatador.data(data));
        Assertions.assertEquals("14:05:09", DanfeFormatador.hora(data));
        Assertions.assertEquals("01/12/2026 14:05:09", DanfeFormatador.dataHora(data));
    }

    @Test
    void deveFormatarDataEHoraLocal() {
        Assertions.assertEquals("08/02/2018 10:10:10", DanfeFormatador.dataHoraLocal(java.time.LocalDateTime.of(2018, 2, 8, 10, 10, 10)));
        Assertions.assertEquals("", DanfeFormatador.dataHoraLocal(null));
    }

    @Test
    void devePreservarAcentosECaracteresForaDoLatin1() {
        final String texto = "\u0141\u00f3d\u017a A\u00e7\u00e3o";
        Assertions.assertEquals(texto, DanfeFormatador.semCaracteresDeControle(texto));
    }

    @Test
    void deveSubstituirCaracteresDeControleDoTextoPorEspaco() {
        Assertions.assertEquals("a b c d", DanfeFormatador.semCaracteresDeControle("a\nb\tc\rd"));
    }

    @Test
    void deveRetornarVazioParaNulo() {
        Assertions.assertEquals("", DanfeFormatador.cnpjOuCpf(null));
        Assertions.assertEquals("", DanfeFormatador.chaveAcesso(null));
        Assertions.assertEquals("", DanfeFormatador.numeroNota(null));
        Assertions.assertEquals("", DanfeFormatador.serie(null));
        Assertions.assertEquals("", DanfeFormatador.valor(null));
        Assertions.assertEquals("", DanfeFormatador.data(null));
        Assertions.assertEquals("", DanfeFormatador.hora(null));
        Assertions.assertEquals("", DanfeFormatador.dataHora(null));
        Assertions.assertEquals("", DanfeFormatador.semCaracteresDeControle(null));
    }
}

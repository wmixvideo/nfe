package com.fincatto.documentofiscal.cte400.webservices;

import com.fincatto.documentofiscal.cte400.CTeConfigFake;
import com.fincatto.documentofiscal.cte400.classes.evento.CTeEvento;
import com.fincatto.documentofiscal.cte400.classes.evento.creditopresumido.CTeEnviaEventoApropriacaoCreditoPresumidoTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WSApropriacaoCreditoPresumidoTest {

    private static final String CHAVE_CTE = "42250112345678000190570010000001231678901234";
    private static final String CHAVE_CTE_OS = "42250112345678000190670010000001231678901234";
    private static final String CNPJ_TOMADOR = "98765432000198";

    @Test
    public void deveGerarEventoDoTomadorComCodigo211110ESequencial1() throws Exception {
        final WSApropriacaoCreditoPresumido ws = new WSApropriacaoCreditoPresumido(new CTeConfigFake(), null);
        final CTeEvento evento = ws.gerarDadosApropriacaoCreditoPresumido(CHAVE_CTE, CTeEnviaEventoApropriacaoCreditoPresumidoTest.getApropriacao(), CNPJ_TOMADOR);
        final String xml = evento.toString();
        Assertions.assertTrue(xml.contains("Id=\"ID211110" + CHAVE_CTE + "001\""), xml);
        Assertions.assertTrue(xml.contains("<CNPJ>" + CNPJ_TOMADOR + "</CNPJ>"), xml);
        Assertions.assertTrue(xml.contains("<tpEvento>211110</tpEvento><nSeqEvento>1</nSeqEvento>"), xml);
        Assertions.assertTrue(xml.contains("<evApropriaCredPres><descEvento>Apropriacao Credito Presumido</descEvento>"), xml);
    }

    @Test
    public void deveExigirCpfOuCnpjDoTomador() {
        final WSApropriacaoCreditoPresumido ws = new WSApropriacaoCreditoPresumido(new CTeConfigFake(), null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> ws.gerarDadosApropriacaoCreditoPresumido(CHAVE_CTE, CTeEnviaEventoApropriacaoCreditoPresumidoTest.getApropriacao(), null));
    }

    @Test
    public void naoDevePermitirCTeOS() {
        final WSApropriacaoCreditoPresumido ws = new WSApropriacaoCreditoPresumido(new CTeConfigFake(), null);
        final IllegalArgumentException excecao = Assertions.assertThrows(IllegalArgumentException.class, () -> ws.apropriacaoCreditoPresumidoAssinada(CHAVE_CTE_OS, "<eventoCTe/>"));
        Assertions.assertTrue(excecao.getMessage().contains("não é permitido nesse evento"), excecao.getMessage());
    }
}

package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoPagamentoTest {

    @Test
    public void naoDevePermitirValorPagamentoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoPagamento().setValorPagamento(new BigDecimal("10000000000000")));
    }

    @Test
    public void devePermitirCartaoNulo() {
        final NFNotaInfoPagamento pagamento = new NFNotaInfoPagamento();
        pagamento.setFormaPagamentoMoeda(NFFormaPagamentoMoeda.CARTAO_CREDITO);
        pagamento.setValorPagamento(new BigDecimal("999999999999.99"));
        pagamento.toString();
    }

    @Test
    public void naoDevePermitirValorPagamentoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoPagamento pagamento = new NFNotaInfoPagamento();
            pagamento.setFormaPagamentoMoeda(NFFormaPagamentoMoeda.CARTAO_CREDITO);
            pagamento.setCartao(FabricaDeObjetosFake.getNFNotaInfoCartao());
            pagamento.toString();
        });
    }

    @Test
    public void naoDevePermitirFormaPagamentoMoedaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoPagamento pagamento = new NFNotaInfoPagamento();
            pagamento.setCartao(FabricaDeObjetosFake.getNFNotaInfoCartao());
            pagamento.setValorPagamento(new BigDecimal("999999999999.99"));
            pagamento.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoPagamento><tPag>03</tPag><vPag>999999999999.99</vPag><card><tpIntegra>1</tpIntegra><CNPJ>12345678901234</CNPJ><tBand>02</tBand><cAut>9ItpS1hBk3TyhjUB3I90</cAut></card></NFNotaInfoPagamento>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoPagamento().toString());
    }
}
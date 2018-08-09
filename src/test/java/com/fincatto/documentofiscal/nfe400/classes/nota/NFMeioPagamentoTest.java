package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFMeioPagamentoTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFMeioPagamento.DINHEIRO, NFMeioPagamento.valueOfCodigo("01"));
        Assert.assertEquals(NFMeioPagamento.CHEQUE, NFMeioPagamento.valueOfCodigo("02"));
        Assert.assertEquals(NFMeioPagamento.CARTAO_CREDITO, NFMeioPagamento.valueOfCodigo("03"));
        Assert.assertEquals(NFMeioPagamento.CARTAO_DEBITO, NFMeioPagamento.valueOfCodigo("04"));
        Assert.assertEquals(NFMeioPagamento.CARTAO_LOJA, NFMeioPagamento.valueOfCodigo("05"));
        Assert.assertEquals(NFMeioPagamento.VALE_ALIMENTACAO, NFMeioPagamento.valueOfCodigo("10"));
        Assert.assertEquals(NFMeioPagamento.VALE_REFEICAO, NFMeioPagamento.valueOfCodigo("11"));
        Assert.assertEquals(NFMeioPagamento.VALE_PRESENTE, NFMeioPagamento.valueOfCodigo("12"));
        Assert.assertEquals(NFMeioPagamento.VALE_COMBUSTIVEL, NFMeioPagamento.valueOfCodigo("13"));
        Assert.assertEquals(NFMeioPagamento.BOLETO_BANCARIO, NFMeioPagamento.valueOfCodigo("15"));
        Assert.assertEquals(NFMeioPagamento.SEM_PAGAMENTO, NFMeioPagamento.valueOfCodigo("90"));
        Assert.assertEquals(NFMeioPagamento.OUTRO, NFMeioPagamento.valueOfCodigo("99"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("01", NFMeioPagamento.DINHEIRO.getCodigo());
        Assert.assertEquals("02", NFMeioPagamento.CHEQUE.getCodigo());
        Assert.assertEquals("03", NFMeioPagamento.CARTAO_CREDITO.getCodigo());
        Assert.assertEquals("04", NFMeioPagamento.CARTAO_DEBITO.getCodigo());
        Assert.assertEquals("05", NFMeioPagamento.CARTAO_LOJA.getCodigo());
        Assert.assertEquals("10", NFMeioPagamento.VALE_ALIMENTACAO.getCodigo());
        Assert.assertEquals("11", NFMeioPagamento.VALE_REFEICAO.getCodigo());
        Assert.assertEquals("12", NFMeioPagamento.VALE_PRESENTE.getCodigo());
        Assert.assertEquals("13", NFMeioPagamento.VALE_COMBUSTIVEL.getCodigo());
        Assert.assertEquals("15", NFMeioPagamento.BOLETO_BANCARIO.getCodigo());
        Assert.assertEquals("90", NFMeioPagamento.SEM_PAGAMENTO.getCodigo());
        Assert.assertEquals("99", NFMeioPagamento.OUTRO.getCodigo());
    }
}
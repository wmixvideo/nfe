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
        Assert.assertEquals(NFMeioPagamento.DUPLICATA_MERCANTIL, NFMeioPagamento.valueOfCodigo("14"));
        Assert.assertEquals(NFMeioPagamento.BOLETO_BANCARIO, NFMeioPagamento.valueOfCodigo("15"));
        Assert.assertEquals(NFMeioPagamento.DEPOSITO_BANCARIO, NFMeioPagamento.valueOfCodigo("16"));
        Assert.assertEquals(NFMeioPagamento.PIX_DINAMICO, NFMeioPagamento.valueOfCodigo("17"));
        Assert.assertEquals(NFMeioPagamento.TRANSFERENCIA_BANCARIA, NFMeioPagamento.valueOfCodigo("18"));
        Assert.assertEquals(NFMeioPagamento.FIDELIDADE_CASHBACK, NFMeioPagamento.valueOfCodigo("19"));        
        Assert.assertEquals(NFMeioPagamento.PIX_ESTATICO, NFMeioPagamento.valueOfCodigo("20"));        
        Assert.assertEquals(NFMeioPagamento.CREDITO_EM_LOJA, NFMeioPagamento.valueOfCodigo("21"));        
        Assert.assertEquals(NFMeioPagamento.PAGAMENTO_ELETRONICO_NAO_INFORMADO, NFMeioPagamento.valueOfCodigo("22"));        
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
        Assert.assertEquals("14", NFMeioPagamento.DUPLICATA_MERCANTIL.getCodigo());
        Assert.assertEquals("15", NFMeioPagamento.BOLETO_BANCARIO.getCodigo());
        Assert.assertEquals("16", NFMeioPagamento.DEPOSITO_BANCARIO.getCodigo());
        Assert.assertEquals("17", NFMeioPagamento.PIX_DINAMICO.getCodigo());
        Assert.assertEquals("18", NFMeioPagamento.TRANSFERENCIA_BANCARIA.getCodigo());
        Assert.assertEquals("19", NFMeioPagamento.FIDELIDADE_CASHBACK.getCodigo());        
        Assert.assertEquals("20", NFMeioPagamento.PIX_ESTATICO.getCodigo());        
        Assert.assertEquals("21", NFMeioPagamento.CREDITO_EM_LOJA.getCodigo());        
        Assert.assertEquals("22", NFMeioPagamento.PAGAMENTO_ELETRONICO_NAO_INFORMADO.getCodigo());        
        Assert.assertEquals("90", NFMeioPagamento.SEM_PAGAMENTO.getCodigo());
        Assert.assertEquals("99", NFMeioPagamento.OUTRO.getCodigo());
    }
    
    @Test
    public void deveRepresentarCodigoDescricaoConcatenado() {
        Assert.assertEquals("01 - Dinheiro", NFMeioPagamento.DINHEIRO.toString());
        Assert.assertEquals("02 - Cheque", NFMeioPagamento.CHEQUE.toString());
        Assert.assertEquals("03 - Cartão de Crédito", NFMeioPagamento.CARTAO_CREDITO.toString());
        Assert.assertEquals("04 - Cartão de Débito", NFMeioPagamento.CARTAO_DEBITO.toString());
        Assert.assertEquals("05 - Cartão da Loja (Private Label)", NFMeioPagamento.CARTAO_LOJA.toString());
        Assert.assertEquals("10 - Vale Alimentação", NFMeioPagamento.VALE_ALIMENTACAO.toString());
        Assert.assertEquals("11 - Vale Refeição", NFMeioPagamento.VALE_REFEICAO.toString());
        Assert.assertEquals("12 - Vale Presente", NFMeioPagamento.VALE_PRESENTE.toString());
        Assert.assertEquals("13 - Vale Combustível", NFMeioPagamento.VALE_COMBUSTIVEL.toString());
        Assert.assertEquals("14 - Duplicata Mercantil", NFMeioPagamento.DUPLICATA_MERCANTIL.toString());
        Assert.assertEquals("15 - Boleto Bancário", NFMeioPagamento.BOLETO_BANCARIO.toString());
        Assert.assertEquals("16 - Depósito Bancário", NFMeioPagamento.DEPOSITO_BANCARIO.toString());
        Assert.assertEquals("17 - Pagamento Instantâneo (PIX) - Dinâmico", NFMeioPagamento.PIX_DINAMICO.toString());
        Assert.assertEquals("18 - Transferência Bancária", NFMeioPagamento.TRANSFERENCIA_BANCARIA.toString());
        Assert.assertEquals("19 - Programa de fidelidade (Cashback)", NFMeioPagamento.FIDELIDADE_CASHBACK.toString());        
        Assert.assertEquals("20 - Pagamento Instantâneo (PIX) - Estático", NFMeioPagamento.PIX_ESTATICO.toString());        
        Assert.assertEquals("21 - Crédito em Loja", NFMeioPagamento.CREDITO_EM_LOJA.toString());        
        Assert.assertEquals("22 - Pagamento Eletrônico não Informado", NFMeioPagamento.PAGAMENTO_ELETRONICO_NAO_INFORMADO.toString());        
        Assert.assertEquals("90 - Sem pagamento", NFMeioPagamento.SEM_PAGAMENTO.toString());
        Assert.assertEquals("99 - Outro", NFMeioPagamento.OUTRO.toString());
    }
}

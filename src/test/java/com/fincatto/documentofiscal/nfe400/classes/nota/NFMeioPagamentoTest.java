package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFMeioPagamentoTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFMeioPagamento.DINHEIRO, NFMeioPagamento.valueOfCodigo("01"));
        Assertions.assertEquals(NFMeioPagamento.CHEQUE, NFMeioPagamento.valueOfCodigo("02"));
        Assertions.assertEquals(NFMeioPagamento.CARTAO_CREDITO, NFMeioPagamento.valueOfCodigo("03"));
        Assertions.assertEquals(NFMeioPagamento.CARTAO_DEBITO, NFMeioPagamento.valueOfCodigo("04"));
        Assertions.assertEquals(NFMeioPagamento.CARTAO_LOJA, NFMeioPagamento.valueOfCodigo("05"));
        Assertions.assertEquals(NFMeioPagamento.VALE_ALIMENTACAO, NFMeioPagamento.valueOfCodigo("10"));
        Assertions.assertEquals(NFMeioPagamento.VALE_REFEICAO, NFMeioPagamento.valueOfCodigo("11"));
        Assertions.assertEquals(NFMeioPagamento.VALE_PRESENTE, NFMeioPagamento.valueOfCodigo("12"));
        Assertions.assertEquals(NFMeioPagamento.VALE_COMBUSTIVEL, NFMeioPagamento.valueOfCodigo("13"));
        Assertions.assertEquals(NFMeioPagamento.DUPLICATA_MERCANTIL, NFMeioPagamento.valueOfCodigo("14"));
        Assertions.assertEquals(NFMeioPagamento.BOLETO_BANCARIO, NFMeioPagamento.valueOfCodigo("15"));
        Assertions.assertEquals(NFMeioPagamento.DEPOSITO_BANCARIO, NFMeioPagamento.valueOfCodigo("16"));
        Assertions.assertEquals(NFMeioPagamento.PIX_DINAMICO, NFMeioPagamento.valueOfCodigo("17"));
        Assertions.assertEquals(NFMeioPagamento.TRANSFERENCIA_BANCARIA, NFMeioPagamento.valueOfCodigo("18"));
        Assertions.assertEquals(NFMeioPagamento.FIDELIDADE_CASHBACK, NFMeioPagamento.valueOfCodigo("19"));        
        Assertions.assertEquals(NFMeioPagamento.PIX_ESTATICO, NFMeioPagamento.valueOfCodigo("20"));        
        Assertions.assertEquals(NFMeioPagamento.CREDITO_EM_LOJA, NFMeioPagamento.valueOfCodigo("21"));        
        Assertions.assertEquals(NFMeioPagamento.PAGAMENTO_ELETRONICO_NAO_INFORMADO, NFMeioPagamento.valueOfCodigo("22"));        
        Assertions.assertEquals(NFMeioPagamento.SEM_PAGAMENTO, NFMeioPagamento.valueOfCodigo("90"));
        Assertions.assertEquals(NFMeioPagamento.OUTRO, NFMeioPagamento.valueOfCodigo("99"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("01", NFMeioPagamento.DINHEIRO.getCodigo());
        Assertions.assertEquals("02", NFMeioPagamento.CHEQUE.getCodigo());
        Assertions.assertEquals("03", NFMeioPagamento.CARTAO_CREDITO.getCodigo());
        Assertions.assertEquals("04", NFMeioPagamento.CARTAO_DEBITO.getCodigo());
        Assertions.assertEquals("05", NFMeioPagamento.CARTAO_LOJA.getCodigo());
        Assertions.assertEquals("10", NFMeioPagamento.VALE_ALIMENTACAO.getCodigo());
        Assertions.assertEquals("11", NFMeioPagamento.VALE_REFEICAO.getCodigo());
        Assertions.assertEquals("12", NFMeioPagamento.VALE_PRESENTE.getCodigo());
        Assertions.assertEquals("13", NFMeioPagamento.VALE_COMBUSTIVEL.getCodigo());
        Assertions.assertEquals("14", NFMeioPagamento.DUPLICATA_MERCANTIL.getCodigo());
        Assertions.assertEquals("15", NFMeioPagamento.BOLETO_BANCARIO.getCodigo());
        Assertions.assertEquals("16", NFMeioPagamento.DEPOSITO_BANCARIO.getCodigo());
        Assertions.assertEquals("17", NFMeioPagamento.PIX_DINAMICO.getCodigo());
        Assertions.assertEquals("18", NFMeioPagamento.TRANSFERENCIA_BANCARIA.getCodigo());
        Assertions.assertEquals("19", NFMeioPagamento.FIDELIDADE_CASHBACK.getCodigo());        
        Assertions.assertEquals("20", NFMeioPagamento.PIX_ESTATICO.getCodigo());        
        Assertions.assertEquals("21", NFMeioPagamento.CREDITO_EM_LOJA.getCodigo());        
        Assertions.assertEquals("22", NFMeioPagamento.PAGAMENTO_ELETRONICO_NAO_INFORMADO.getCodigo());        
        Assertions.assertEquals("90", NFMeioPagamento.SEM_PAGAMENTO.getCodigo());
        Assertions.assertEquals("99", NFMeioPagamento.OUTRO.getCodigo());
    }
    
    @Test
    public void deveRepresentarCodigoDescricaoConcatenado() {
        Assertions.assertEquals("01 - Dinheiro", NFMeioPagamento.DINHEIRO.toString());
        Assertions.assertEquals("02 - Cheque", NFMeioPagamento.CHEQUE.toString());
        Assertions.assertEquals("03 - Cartão de Crédito", NFMeioPagamento.CARTAO_CREDITO.toString());
        Assertions.assertEquals("04 - Cartão de Débito", NFMeioPagamento.CARTAO_DEBITO.toString());
        Assertions.assertEquals("05 - Cartão da Loja (Private Label)", NFMeioPagamento.CARTAO_LOJA.toString());
        Assertions.assertEquals("10 - Vale Alimentação", NFMeioPagamento.VALE_ALIMENTACAO.toString());
        Assertions.assertEquals("11 - Vale Refeição", NFMeioPagamento.VALE_REFEICAO.toString());
        Assertions.assertEquals("12 - Vale Presente", NFMeioPagamento.VALE_PRESENTE.toString());
        Assertions.assertEquals("13 - Vale Combustível", NFMeioPagamento.VALE_COMBUSTIVEL.toString());
        Assertions.assertEquals("14 - Duplicata Mercantil", NFMeioPagamento.DUPLICATA_MERCANTIL.toString());
        Assertions.assertEquals("15 - Boleto Bancário", NFMeioPagamento.BOLETO_BANCARIO.toString());
        Assertions.assertEquals("16 - Depósito Bancário", NFMeioPagamento.DEPOSITO_BANCARIO.toString());
        Assertions.assertEquals("17 - Pagamento Instantâneo (PIX) - Dinâmico", NFMeioPagamento.PIX_DINAMICO.toString());
        Assertions.assertEquals("18 - Transferência Bancária", NFMeioPagamento.TRANSFERENCIA_BANCARIA.toString());
        Assertions.assertEquals("19 - Programa de fidelidade (Cashback)", NFMeioPagamento.FIDELIDADE_CASHBACK.toString());        
        Assertions.assertEquals("20 - Pagamento Instantâneo (PIX) - Estático", NFMeioPagamento.PIX_ESTATICO.toString());        
        Assertions.assertEquals("21 - Crédito em Loja", NFMeioPagamento.CREDITO_EM_LOJA.toString());        
        Assertions.assertEquals("22 - Pagamento Eletrônico não Informado", NFMeioPagamento.PAGAMENTO_ELETRONICO_NAO_INFORMADO.toString());        
        Assertions.assertEquals("90 - Sem pagamento", NFMeioPagamento.SEM_PAGAMENTO.toString());
        Assertions.assertEquals("99 - Outro", NFMeioPagamento.OUTRO.toString());
    }
}

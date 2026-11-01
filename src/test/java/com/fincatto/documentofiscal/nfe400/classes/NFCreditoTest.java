package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Marcos Lombardi de Andrade
 */
public class NFCreditoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("01", NFCredito.MULTA_JUROS.getCodigo());
        Assertions.assertEquals("02", NFCredito.APROPRIACAO_CREDITO_PRESUMIDO_IBS_SALDO_DEVEDOR_ZFM.getCodigo());
        Assertions.assertEquals("03", NFCredito.RETORNO_RECUSA_ENTREGA_DESTINATARIO_NAO_LOCALIZADO.getCodigo());
        Assertions.assertEquals("04", NFCredito.REDUCAO_VALORES.getCodigo());
        Assertions.assertEquals("05", NFCredito.TRANSFERENCIA_CREDITO_SUCESSAO.getCodigo());
    }
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFCredito.MULTA_JUROS, NFCredito.valueOfCodigo("01"));
        Assertions.assertEquals(NFCredito.APROPRIACAO_CREDITO_PRESUMIDO_IBS_SALDO_DEVEDOR_ZFM, NFCredito.valueOfCodigo("02"));
        Assertions.assertEquals(NFCredito.RETORNO_RECUSA_ENTREGA_DESTINATARIO_NAO_LOCALIZADO, NFCredito.valueOfCodigo("03"));
        Assertions.assertEquals(NFCredito.REDUCAO_VALORES, NFCredito.valueOfCodigo("04"));
        Assertions.assertEquals(NFCredito.TRANSFERENCIA_CREDITO_SUCESSAO, NFCredito.valueOfCodigo("05"));
    }
    
    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assertions.assertEquals("Multa e juros", NFCredito.MULTA_JUROS.getDescricao());
    	Assertions.assertEquals("Apropriação de crédito presumido de IBS sobre o saldo devedor na ZFM (art. 450, § 1º, LC 214/25)", NFCredito.APROPRIACAO_CREDITO_PRESUMIDO_IBS_SALDO_DEVEDOR_ZFM.getDescricao());
    	Assertions.assertEquals("Retorno por recusa na entrega ou por não localização do destinatário na tentativa de entrega", NFCredito.RETORNO_RECUSA_ENTREGA_DESTINATARIO_NAO_LOCALIZADO.getDescricao());
    	Assertions.assertEquals("Redução de valores", NFCredito.REDUCAO_VALORES.getDescricao());
    	Assertions.assertEquals("Transferência de crédito na sucessão", NFCredito.TRANSFERENCIA_CREDITO_SUCESSAO.getDescricao());
    }
}

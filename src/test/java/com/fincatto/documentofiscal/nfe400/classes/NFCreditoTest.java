package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Marcos Lombardi de Andrade
 */
public class NFCreditoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("01", NFCredito.MULTA_JUROS.getCodigo());
        Assert.assertEquals("02", NFCredito.APROPRIACAO_CREDITO_PRESUMIDO_IBS_SALDO_DEVEDOR_ZFM.getCodigo());
        Assert.assertEquals("03", NFCredito.RETORNO_RECUSA_ENTREGA_DESTINATARIO_NAO_LOCALIZADO.getCodigo());
        Assert.assertEquals("04", NFCredito.REDUCAO_VALORES.getCodigo());
        Assert.assertEquals("05", NFCredito.TRANSFERENCIA_CREDITO_SUCESSAO.getCodigo());
    }
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFCredito.MULTA_JUROS, NFCredito.valueOfCodigo("01"));
        Assert.assertEquals(NFCredito.APROPRIACAO_CREDITO_PRESUMIDO_IBS_SALDO_DEVEDOR_ZFM, NFCredito.valueOfCodigo("02"));
        Assert.assertEquals(NFCredito.RETORNO_RECUSA_ENTREGA_DESTINATARIO_NAO_LOCALIZADO, NFCredito.valueOfCodigo("03"));
        Assert.assertEquals(NFCredito.REDUCAO_VALORES, NFCredito.valueOfCodigo("04"));
        Assert.assertEquals(NFCredito.TRANSFERENCIA_CREDITO_SUCESSAO, NFCredito.valueOfCodigo("05"));
    }
    
    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assert.assertEquals("Multa e juros", NFCredito.MULTA_JUROS.getDescricao());
    	Assert.assertEquals("Apropriação de crédito presumido de IBS sobre o saldo devedor na ZFM (art. 450, § 1º, LC 214/25)", NFCredito.APROPRIACAO_CREDITO_PRESUMIDO_IBS_SALDO_DEVEDOR_ZFM.getDescricao());
    	Assert.assertEquals("Retorno por recusa na entrega ou por não localização do destinatário na tentativa de entrega", NFCredito.RETORNO_RECUSA_ENTREGA_DESTINATARIO_NAO_LOCALIZADO.getDescricao());
    	Assert.assertEquals("Redução de valores", NFCredito.REDUCAO_VALORES.getDescricao());
    	Assert.assertEquals("Transferência de crédito na sucessão", NFCredito.TRANSFERENCIA_CREDITO_SUCESSAO.getDescricao());
    }
}

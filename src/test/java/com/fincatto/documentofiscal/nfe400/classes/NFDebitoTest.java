package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Marcos Lombardi de Andrade
 */
public class NFDebitoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("01", NFDebito.TRANSFERENCIA_CREDITO_COOPERATIVA.getCodigo());
        Assert.assertEquals("02", NFDebito.ANULACAO_CREDITO_SAIDA_IMUNE_ISENTA.getCodigo());
        Assert.assertEquals("03", NFDebito.DEBITO_NOTAS_NAO_PROCESSADAS_APURACAO.getCodigo());
        Assert.assertEquals("04", NFDebito.MULTA_JUROS.getCodigo());
        Assert.assertEquals("05", NFDebito.TRANSFERENCIA_CREDITO_SUCESSAO.getCodigo());
        Assert.assertEquals("06", NFDebito.PAGAMENTO_ANTECIPADO.getCodigo());
        Assert.assertEquals("07", NFDebito.PERDA_ESTOQUE.getCodigo());
        Assert.assertEquals("08", NFDebito.DESENQUADRAMENTO_SN.getCodigo());
    }
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFDebito.TRANSFERENCIA_CREDITO_COOPERATIVA, NFDebito.valueOfCodigo("01"));
        Assert.assertEquals(NFDebito.ANULACAO_CREDITO_SAIDA_IMUNE_ISENTA, NFDebito.valueOfCodigo("02"));
        Assert.assertEquals(NFDebito.DEBITO_NOTAS_NAO_PROCESSADAS_APURACAO, NFDebito.valueOfCodigo("03"));
        Assert.assertEquals(NFDebito.MULTA_JUROS, NFDebito.valueOfCodigo("04"));
        Assert.assertEquals(NFDebito.TRANSFERENCIA_CREDITO_SUCESSAO, NFDebito.valueOfCodigo("05"));
        Assert.assertEquals(NFDebito.PAGAMENTO_ANTECIPADO, NFDebito.valueOfCodigo("06"));
        Assert.assertEquals(NFDebito.PERDA_ESTOQUE, NFDebito.valueOfCodigo("07"));
        Assert.assertEquals(NFDebito.DESENQUADRAMENTO_SN, NFDebito.valueOfCodigo("08"));
    }
    
    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assert.assertEquals("Transferência de créditos para Cooperativas", NFDebito.TRANSFERENCIA_CREDITO_COOPERATIVA.getDescricao());
    	Assert.assertEquals("Anulação de Crédito por Saídas Imunes/Isentas", NFDebito.ANULACAO_CREDITO_SAIDA_IMUNE_ISENTA.getDescricao());
    	Assert.assertEquals("Débitos de notas fiscais não processadas na apuração", NFDebito.DEBITO_NOTAS_NAO_PROCESSADAS_APURACAO.getDescricao());
    	Assert.assertEquals("Multa e juros", NFDebito.MULTA_JUROS.getDescricao());
    	Assert.assertEquals("Transferência de crédito na sucessão", NFDebito.TRANSFERENCIA_CREDITO_SUCESSAO.getDescricao());
    	Assert.assertEquals("Pagamento antecipado", NFDebito.PAGAMENTO_ANTECIPADO.getDescricao());
    	Assert.assertEquals("Perda em estoque", NFDebito.PERDA_ESTOQUE.getDescricao());
    	Assert.assertEquals("Desenquadramento do SN", NFDebito.DESENQUADRAMENTO_SN.getDescricao());
    }
}

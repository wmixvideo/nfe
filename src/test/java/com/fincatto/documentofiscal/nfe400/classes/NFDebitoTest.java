package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Marcos Lombardi de Andrade
 */
public class NFDebitoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("01", NFDebito.TRANSFERENCIA_CREDITO_COOPERATIVA.getCodigo());
        Assertions.assertEquals("02", NFDebito.ANULACAO_CREDITO_SAIDA_IMUNE_ISENTA.getCodigo());
        Assertions.assertEquals("03", NFDebito.DEBITO_NOTAS_NAO_PROCESSADAS_APURACAO.getCodigo());
        Assertions.assertEquals("04", NFDebito.MULTA_JUROS.getCodigo());
        Assertions.assertEquals("05", NFDebito.TRANSFERENCIA_CREDITO_SUCESSAO.getCodigo());
        Assertions.assertEquals("06", NFDebito.PAGAMENTO_ANTECIPADO.getCodigo());
        Assertions.assertEquals("07", NFDebito.PERDA_ESTOQUE.getCodigo());
        Assertions.assertEquals("08", NFDebito.DESENQUADRAMENTO_SN.getCodigo());
    }
    
    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFDebito.TRANSFERENCIA_CREDITO_COOPERATIVA, NFDebito.valueOfCodigo("01"));
        Assertions.assertEquals(NFDebito.ANULACAO_CREDITO_SAIDA_IMUNE_ISENTA, NFDebito.valueOfCodigo("02"));
        Assertions.assertEquals(NFDebito.DEBITO_NOTAS_NAO_PROCESSADAS_APURACAO, NFDebito.valueOfCodigo("03"));
        Assertions.assertEquals(NFDebito.MULTA_JUROS, NFDebito.valueOfCodigo("04"));
        Assertions.assertEquals(NFDebito.TRANSFERENCIA_CREDITO_SUCESSAO, NFDebito.valueOfCodigo("05"));
        Assertions.assertEquals(NFDebito.PAGAMENTO_ANTECIPADO, NFDebito.valueOfCodigo("06"));
        Assertions.assertEquals(NFDebito.PERDA_ESTOQUE, NFDebito.valueOfCodigo("07"));
        Assertions.assertEquals(NFDebito.DESENQUADRAMENTO_SN, NFDebito.valueOfCodigo("08"));
    }
    
    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assertions.assertEquals("Transferência de créditos para Cooperativas", NFDebito.TRANSFERENCIA_CREDITO_COOPERATIVA.getDescricao());
    	Assertions.assertEquals("Anulação de Crédito por Saídas Imunes/Isentas", NFDebito.ANULACAO_CREDITO_SAIDA_IMUNE_ISENTA.getDescricao());
    	Assertions.assertEquals("Débitos de notas fiscais não processadas na apuração", NFDebito.DEBITO_NOTAS_NAO_PROCESSADAS_APURACAO.getDescricao());
    	Assertions.assertEquals("Multa e juros", NFDebito.MULTA_JUROS.getDescricao());
    	Assertions.assertEquals("Transferência de crédito na sucessão", NFDebito.TRANSFERENCIA_CREDITO_SUCESSAO.getDescricao());
    	Assertions.assertEquals("Pagamento antecipado", NFDebito.PAGAMENTO_ANTECIPADO.getDescricao());
    	Assertions.assertEquals("Perda em estoque", NFDebito.PERDA_ESTOQUE.getDescricao());
    	Assertions.assertEquals("Desenquadramento do SN", NFDebito.DESENQUADRAMENTO_SN.getDescricao());
    }
}

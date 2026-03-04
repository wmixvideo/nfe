package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFIndicadorPresencaCompradorTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFIndicadorPresencaComprador.NAO_APLICA, NFIndicadorPresencaComprador.valueOfCodigo("0"));
        Assert.assertEquals(NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL, NFIndicadorPresencaComprador.valueOfCodigo("1"));
        Assert.assertEquals(NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_INTERNET, NFIndicadorPresencaComprador.valueOfCodigo("2"));
        Assert.assertEquals(NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO, NFIndicadorPresencaComprador.valueOfCodigo("3"));
        Assert.assertEquals(NFIndicadorPresencaComprador.NFCE_EM_OPERACAO_COM_ENTREGA_DOMICILIO, NFIndicadorPresencaComprador.valueOfCodigo("4"));
        Assert.assertEquals(NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL_FORA_ESTABELECIMENTO, NFIndicadorPresencaComprador.valueOfCodigo("5"));
        Assert.assertEquals(NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_OUTROS, NFIndicadorPresencaComprador.valueOfCodigo("9"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFIndicadorPresencaComprador.NAO_APLICA.getCodigo());
        Assert.assertEquals("1", NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL.getCodigo());
        Assert.assertEquals("2", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_INTERNET.getCodigo());
        Assert.assertEquals("3", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO.getCodigo());
        Assert.assertEquals("4", NFIndicadorPresencaComprador.NFCE_EM_OPERACAO_COM_ENTREGA_DOMICILIO.getCodigo());
        Assert.assertEquals("5", NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL_FORA_ESTABELECIMENTO.getCodigo());
        Assert.assertEquals("9", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_OUTROS.getCodigo());
    }
    
    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assert.assertEquals("Não se aplica", NFIndicadorPresencaComprador.NAO_APLICA.getDescricao());
    	Assert.assertEquals("Operação presencial", NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL.getDescricao());
    	Assert.assertEquals("Operação não presencial - Internet", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_INTERNET.getDescricao());
    	Assert.assertEquals("Operação não presencial - Teleatendimento", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO.getDescricao());
    	Assert.assertEquals("NFC-e em operação com entrega a domicílio", NFIndicadorPresencaComprador.NFCE_EM_OPERACAO_COM_ENTREGA_DOMICILIO.getDescricao());
    	Assert.assertEquals("Operação presencial, fora do estabelecimento", NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL_FORA_ESTABELECIMENTO.getDescricao());
    	Assert.assertEquals("Operação não presencial - Outros", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_OUTROS.getDescricao());
    }
}

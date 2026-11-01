package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFIndicadorPresencaCompradorTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFIndicadorPresencaComprador.NAO_APLICA, NFIndicadorPresencaComprador.valueOfCodigo("0"));
        Assertions.assertEquals(NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL, NFIndicadorPresencaComprador.valueOfCodigo("1"));
        Assertions.assertEquals(NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_INTERNET, NFIndicadorPresencaComprador.valueOfCodigo("2"));
        Assertions.assertEquals(NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO, NFIndicadorPresencaComprador.valueOfCodigo("3"));
        Assertions.assertEquals(NFIndicadorPresencaComprador.NFCE_EM_OPERACAO_COM_ENTREGA_DOMICILIO, NFIndicadorPresencaComprador.valueOfCodigo("4"));
        Assertions.assertEquals(NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL_FORA_ESTABELECIMENTO, NFIndicadorPresencaComprador.valueOfCodigo("5"));
        Assertions.assertEquals(NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_OUTROS, NFIndicadorPresencaComprador.valueOfCodigo("9"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFIndicadorPresencaComprador.NAO_APLICA.getCodigo());
        Assertions.assertEquals("1", NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL.getCodigo());
        Assertions.assertEquals("2", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_INTERNET.getCodigo());
        Assertions.assertEquals("3", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO.getCodigo());
        Assertions.assertEquals("4", NFIndicadorPresencaComprador.NFCE_EM_OPERACAO_COM_ENTREGA_DOMICILIO.getCodigo());
        Assertions.assertEquals("5", NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL_FORA_ESTABELECIMENTO.getCodigo());
        Assertions.assertEquals("9", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_OUTROS.getCodigo());
    }
    
    @Test
    public void deveRepresentarADescricaoCorretamente() {
    	Assertions.assertEquals("Não se aplica", NFIndicadorPresencaComprador.NAO_APLICA.getDescricao());
    	Assertions.assertEquals("Operação presencial", NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL.getDescricao());
    	Assertions.assertEquals("Operação não presencial - Internet", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_INTERNET.getDescricao());
    	Assertions.assertEquals("Operação não presencial - Teleatendimento", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO.getDescricao());
    	Assertions.assertEquals("NFC-e em operação com entrega a domicílio", NFIndicadorPresencaComprador.NFCE_EM_OPERACAO_COM_ENTREGA_DOMICILIO.getDescricao());
    	Assertions.assertEquals("Operação presencial, fora do estabelecimento", NFIndicadorPresencaComprador.OPERACAO_PRESENCIAL_FORA_ESTABELECIMENTO.getDescricao());
    	Assertions.assertEquals("Operação não presencial - Outros", NFIndicadorPresencaComprador.OPERACAO_NAO_PRESENCIAL_OUTROS.getDescricao());
    }
}

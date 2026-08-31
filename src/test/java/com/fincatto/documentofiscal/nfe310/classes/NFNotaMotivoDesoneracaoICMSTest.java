package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaMotivoDesoneracaoICMSTest {

    @Test
    public void deveObterMotivoDesoneracaoICMSApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.TAXI, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("1"));
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.PRODUTOR_AGROPECUARIO, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("3"));
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.FROTISTA_LOCADORA, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("4"));
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.DIPLOMATICO_CONSULAR, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("5"));
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRE_COMERCIO, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("6"));
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.SUFRAMA, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("7"));
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.VENDA_ORGAOS_PUBLICOS, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("8"));
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.OUTROS, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("9"));
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.DEFICIENTE_CONDUTOR, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("10"));
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.DEFICIENTE_NAO_CONDUTOR, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("11"));
        Assertions.assertEquals(NFNotaMotivoDesoneracaoICMS.ORGAO_DE_FOMENTO_DESENVOLVIMENTO_AGROPECUARIO, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("12"));
        Assertions.assertNull(NFNotaMotivoDesoneracaoICMS.valueOfCodigo("0"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFNotaMotivoDesoneracaoICMS.TAXI.getCodigo());
        Assertions.assertEquals("3", NFNotaMotivoDesoneracaoICMS.PRODUTOR_AGROPECUARIO.getCodigo());
        Assertions.assertEquals("4", NFNotaMotivoDesoneracaoICMS.FROTISTA_LOCADORA.getCodigo());
        Assertions.assertEquals("5", NFNotaMotivoDesoneracaoICMS.DIPLOMATICO_CONSULAR.getCodigo());
        Assertions.assertEquals("6", NFNotaMotivoDesoneracaoICMS.UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRE_COMERCIO.getCodigo());
        Assertions.assertEquals("7", NFNotaMotivoDesoneracaoICMS.SUFRAMA.getCodigo());
        Assertions.assertEquals("8", NFNotaMotivoDesoneracaoICMS.VENDA_ORGAOS_PUBLICOS.getCodigo());
        Assertions.assertEquals("9", NFNotaMotivoDesoneracaoICMS.OUTROS.getCodigo());
        Assertions.assertEquals("10", NFNotaMotivoDesoneracaoICMS.DEFICIENTE_CONDUTOR.getCodigo());
        Assertions.assertEquals("11", NFNotaMotivoDesoneracaoICMS.DEFICIENTE_NAO_CONDUTOR.getCodigo());
        Assertions.assertEquals("12", NFNotaMotivoDesoneracaoICMS.ORGAO_DE_FOMENTO_DESENVOLVIMENTO_AGROPECUARIO.getCodigo());
    }
}
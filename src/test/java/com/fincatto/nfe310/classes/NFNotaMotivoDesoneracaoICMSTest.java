package com.fincatto.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.classes.NFNotaMotivoDesoneracaoICMS;

public class NFNotaMotivoDesoneracaoICMSTest {

    @Test
    public void deveObterMotivoDesoneracaoICMSApartirDoSeuCodigo() {
        Assert.assertEquals(NFNotaMotivoDesoneracaoICMS.TAXI, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("1"));
        Assert.assertEquals(NFNotaMotivoDesoneracaoICMS.PRODUTOR_AGROPECUARIO, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("3"));
        Assert.assertEquals(NFNotaMotivoDesoneracaoICMS.FROTISTA_LOCADORA, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("4"));
        Assert.assertEquals(NFNotaMotivoDesoneracaoICMS.DIPLOMATICO_CONSULAR, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("5"));
        Assert.assertEquals(NFNotaMotivoDesoneracaoICMS.UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRE_COMERCIO, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("6"));
        Assert.assertEquals(NFNotaMotivoDesoneracaoICMS.SUFRAMA, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("7"));
        Assert.assertEquals(NFNotaMotivoDesoneracaoICMS.VENDA_ORGAOS_PUBLICOS, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("8"));
        Assert.assertEquals(NFNotaMotivoDesoneracaoICMS.OUTROS, NFNotaMotivoDesoneracaoICMS.valueOfCodigo("9"));
        Assert.assertNull(NFNotaMotivoDesoneracaoICMS.valueOfCodigo("0"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFNotaMotivoDesoneracaoICMS.TAXI.getCodigo());
        Assert.assertEquals("3", NFNotaMotivoDesoneracaoICMS.PRODUTOR_AGROPECUARIO.getCodigo());
        Assert.assertEquals("4", NFNotaMotivoDesoneracaoICMS.FROTISTA_LOCADORA.getCodigo());
        Assert.assertEquals("5", NFNotaMotivoDesoneracaoICMS.DIPLOMATICO_CONSULAR.getCodigo());
        Assert.assertEquals("6", NFNotaMotivoDesoneracaoICMS.UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRE_COMERCIO.getCodigo());
        Assert.assertEquals("7", NFNotaMotivoDesoneracaoICMS.SUFRAMA.getCodigo());
        Assert.assertEquals("8", NFNotaMotivoDesoneracaoICMS.VENDA_ORGAOS_PUBLICOS.getCodigo());
        Assert.assertEquals("9", NFNotaMotivoDesoneracaoICMS.OUTROS.getCodigo());
        Assert.assertEquals("10", NFNotaMotivoDesoneracaoICMS.DEFICIENTE_CONDUTOR.getCodigo());
        Assert.assertEquals("11", NFNotaMotivoDesoneracaoICMS.DEFICIENTE_NAO_CONDUTOR.getCodigo());
    }
}
package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaMotivoDesoneracaoICMSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals(1, NFNotaMotivoDesoneracaoICMS.TAXI.getCodigo());
        Assert.assertEquals(2, NFNotaMotivoDesoneracaoICMS.DEFICIENTE_FISICO.getCodigo());
        Assert.assertEquals(3, NFNotaMotivoDesoneracaoICMS.PRODUTOR_AGROPECUARIO.getCodigo());
        Assert.assertEquals(4, NFNotaMotivoDesoneracaoICMS.FROTISTA_LOCADORA.getCodigo());
        Assert.assertEquals(5, NFNotaMotivoDesoneracaoICMS.DIPLOMATICO_CONSULAR.getCodigo());
        Assert.assertEquals(6, NFNotaMotivoDesoneracaoICMS.UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRE_COMERCIO.getCodigo());
        Assert.assertEquals(7, NFNotaMotivoDesoneracaoICMS.SUFRAMA.getCodigo());
        Assert.assertEquals(8, NFNotaMotivoDesoneracaoICMS.VENDA_ORGAOS_PUBLICOS.getCodigo());
        Assert.assertEquals(9, NFNotaMotivoDesoneracaoICMS.OUTROS.getCodigo());
    }
}
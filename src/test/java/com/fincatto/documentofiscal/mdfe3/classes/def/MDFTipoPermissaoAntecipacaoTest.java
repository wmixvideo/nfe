package com.fincatto.documentofiscal.mdfe3.classes.def;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MDFTipoPermissaoAntecipacaoTest {

    @Test
    public void testGetCodigo() {
        Assertions.assertEquals("0", MDFTipoPermissaoAntecipacao.NAO_PERMITE_ANTECIPAR.getCodigo());
        Assertions.assertEquals("1", MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR.getCodigo());
        Assertions.assertEquals("2", MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR_COM_CONFIRMACAO.getCodigo());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("0 - Não permite antecipar", MDFTipoPermissaoAntecipacao.NAO_PERMITE_ANTECIPAR.toString());
        Assertions.assertEquals("1 - Permite antecipar as parcelas", MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR.toString());
        Assertions.assertEquals("2 - Permite antecipar as parcelas mediante confirmação", MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR_COM_CONFIRMACAO.toString());
    }

    @Test
    public void testValueOfCodigo() {
        Assertions.assertEquals(MDFTipoPermissaoAntecipacao.NAO_PERMITE_ANTECIPAR, MDFTipoPermissaoAntecipacao.valueOfCodigo("0"));
        Assertions.assertEquals(MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR, MDFTipoPermissaoAntecipacao.valueOfCodigo("1"));
        Assertions.assertEquals(MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR_COM_CONFIRMACAO, MDFTipoPermissaoAntecipacao.valueOfCodigo("2"));
        Assertions.assertNull(MDFTipoPermissaoAntecipacao.valueOfCodigo("3"));
        Assertions.assertNull(MDFTipoPermissaoAntecipacao.valueOfCodigo(null));
    }
}
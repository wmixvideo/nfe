package com.fincatto.documentofiscal.mdfe3.classes.def;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MDFTipoPermissaoAntecipacaoTest {

    @Test
    public void testGetCodigo() {
        assertEquals("0", MDFTipoPermissaoAntecipacao.NAO_PERMITE_ANTECIPAR.getCodigo());
        assertEquals("1", MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR.getCodigo());
        assertEquals("2", MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR_COM_CONFIRMACAO.getCodigo());
    }

    @Test
    public void testToString() {
        assertEquals("0 - Não permite antecipar", MDFTipoPermissaoAntecipacao.NAO_PERMITE_ANTECIPAR.toString());
        assertEquals("1 - Permite antecipar as parcelas", MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR.toString());
        assertEquals("2 - Permite antecipar as parcelas mediante confirmação", MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR_COM_CONFIRMACAO.toString());
    }

    @Test
    public void testValueOfCodigo() {
        assertEquals(MDFTipoPermissaoAntecipacao.NAO_PERMITE_ANTECIPAR, MDFTipoPermissaoAntecipacao.valueOfCodigo("0"));
        assertEquals(MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR, MDFTipoPermissaoAntecipacao.valueOfCodigo("1"));
        assertEquals(MDFTipoPermissaoAntecipacao.PERMITE_ANTECIPAR_COM_CONFIRMACAO, MDFTipoPermissaoAntecipacao.valueOfCodigo("2"));
        assertNull(MDFTipoPermissaoAntecipacao.valueOfCodigo("3"));
        assertNull(MDFTipoPermissaoAntecipacao.valueOfCodigo(null));
    }
}
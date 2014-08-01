package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemImpostoICMSTest {

    @Test
    public void devePermitirApenasUmICMSSelecionado() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        icms.setIcms00(new NFNotaInfoItemImpostoICMS00());

        try {
            icms.setIcms10(new NFNotaInfoItemImpostoICMS10());
            Assert.fail("So pode permitir um icms cadastrado");
        } catch (final IllegalStateException e) {
        }
    }
}
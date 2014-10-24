package com.fincatto.nfe200.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemImpostoCOFINSNaoTributavel;

public class NFNotaInfoItemImpostoCOFINSNaoTributavelTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        new NFNotaInfoItemImpostoCOFINSNaoTributavel().toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSNaoTributavel><CST>04</CST></NFNotaInfoItemImpostoCOFINSNaoTributavel>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSNaoTributavel().toString());
    }
}
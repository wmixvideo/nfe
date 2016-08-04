package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

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
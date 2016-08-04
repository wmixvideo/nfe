package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemImpostoPISNaoTributadoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        new NFNotaInfoItemImpostoPISNaoTributado().toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPISNaoTributado><CST>04</CST></NFNotaInfoItemImpostoPISNaoTributado>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISNaoTributado().toString());
    }
}
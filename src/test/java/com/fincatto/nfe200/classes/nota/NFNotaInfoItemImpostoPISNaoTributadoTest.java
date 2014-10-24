package com.fincatto.nfe200.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemImpostoPISNaoTributado;

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
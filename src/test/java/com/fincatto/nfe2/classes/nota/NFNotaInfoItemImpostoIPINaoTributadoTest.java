package com.fincatto.nfe2.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe2.FabricaDeObjetosFake;
import com.fincatto.nfe2.classes.nota.NFNotaInfoItemImpostoIPINaoTributado;

public class NFNotaInfoItemImpostoIPINaoTributadoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaNulo() {
        new NFNotaInfoItemImpostoIPINaoTributado().toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIPINaoTributado><CST>52</CST></NFNotaInfoItemImpostoIPINaoTributado>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado().toString());
    }
}
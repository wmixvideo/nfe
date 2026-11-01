package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemImpostoPISNaoTributadoTest {

    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoPISNaoTributado().toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPISNaoTributado><CST>04</CST></NFNotaInfoItemImpostoPISNaoTributado>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISNaoTributado().toString());
    }
}
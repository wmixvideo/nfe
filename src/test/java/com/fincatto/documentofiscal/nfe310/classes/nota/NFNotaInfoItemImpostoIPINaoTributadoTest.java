package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemImpostoIPINaoTributadoTest {

    @Test
    public void naoDevePermitirSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoIPINaoTributado().toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoIPINaoTributado><CST>52</CST></NFNotaInfoItemImpostoIPINaoTributado>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado().toString());
    }
}
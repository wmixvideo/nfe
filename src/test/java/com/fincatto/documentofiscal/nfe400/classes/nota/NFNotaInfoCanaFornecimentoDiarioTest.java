package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoCanaFornecimentoDiarioTest {

    @Test
    public void naoDevePermitirDiaAcima31() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoCanaFornecimentoDiario().setDia(32));
    }

    @Test
    public void naoDevePermitirDiaMenor1() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoCanaFornecimentoDiario().setDia(0));
    }

    @Test
    public void devePermitirDiaValido() {
        new NFNotaInfoCanaFornecimentoDiario().setDia(1);
        new NFNotaInfoCanaFornecimentoDiario().setDia(30);
    }

    @Test
    public void naoDevePermitirQuantidadeNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = new NFNotaInfoCanaFornecimentoDiario();
            canaFornecimentoDiario.setDia(15);
            canaFornecimentoDiario.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCanaFornecimentoDiario dia=\"15\"><qtde>3</qtde></NFNotaInfoCanaFornecimentoDiario>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario().toString());
    }
}
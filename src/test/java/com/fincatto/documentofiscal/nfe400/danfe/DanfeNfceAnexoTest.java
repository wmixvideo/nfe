package com.fincatto.documentofiscal.nfe400.danfe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testes de {@link DanfeNfceAnexo}: titulo e texto, validacao e atalhos.
 *
 * @author Marcos Lombardi de Andrade
 */
class DanfeNfceAnexoTest {

    @Test
    void deveGuardarTituloETexto() {
        final DanfeNfceAnexo anexo = new DanfeNfceAnexo("TITULO", "texto\nem linhas");
        Assertions.assertEquals("TITULO", anexo.getTitulo());
        Assertions.assertEquals("texto\nem linhas", anexo.getTexto());
    }

    @Test
    void devePermitirAnexoSemTitulo() {
        Assertions.assertNull(new DanfeNfceAnexo(null, "texto").getTitulo());
    }

    @Test
    void deveRejeitarTextoNuloOuEmBranco() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new DanfeNfceAnexo("T", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new DanfeNfceAnexo("T", ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new DanfeNfceAnexo("T", " \r\n  "));
    }

    @Test
    void deveCriarOsAtalhosComOsTitulosPadrao() {
        Assertions.assertEquals("COMPROVANTE TEF – VIA DO ESTABELECIMENTO", DanfeNfceAnexo.viaEstabelecimento("a").getTitulo());
        Assertions.assertEquals("COMPROVANTE TEF – VIA DO CLIENTE", DanfeNfceAnexo.viaCliente("b").getTitulo());
        Assertions.assertEquals("CONFISSÃO DE DÍVIDA", DanfeNfceAnexo.confissaoDeDivida("c").getTitulo());
        Assertions.assertEquals("b", DanfeNfceAnexo.viaCliente("b").getTexto());
    }
}

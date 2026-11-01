package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoCompraTest {

    @Test
    public void naoDevePermitirPedidoComTamanhoNaoPermitido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoCompra().setPedido("");
                Assertions.fail("Validacao nao esta funcionando corretamente");
            } catch (final IllegalStateException e) {
                new NFNotaInfoCompra().setPedido("9tQtearTIcXmO9vxNr3TPhSaItw5mk3zyTVlf2aIFXqqvtXrHoa0qPWKzUzca");
            }
            Assertions.fail("Validacao nao esta funcionando corretamente");
        });
    }

    @Test
    public void naoDevePermitirNotaDeEmpenhoComTamanhoNaoPermitido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoCompra().setNotaDeEmpenho("");
                Assertions.fail("Validacao nao esta funcionando corretamente");
            } catch (final IllegalStateException e) {
                new NFNotaInfoCompra().setNotaDeEmpenho("uCJhbWe0g8OQ8KtSKlkXpRC");
            }
            Assertions.fail("Validacao nao esta funcionando corretamente");
        });
    }

    @Test
    public void naoDevePermitirContratoComTamanhoNaoPermitido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoCompra().setContrato("");
                Assertions.fail("Validacao nao esta funcionando corretamente");
            } catch (final IllegalStateException e) {
                new NFNotaInfoCompra().setContrato("9tQtearTIcXmO9vxNr3TPhSaItw5mk3zyTVlf2aIFXqqvtXrHoa0qPWKzUzca");
            }
            Assertions.fail("Validacao nao esta funcionando corretamente");
        });
    }

    @Test
    public void deveGerarXMLSemContrato() {
        final NFNotaInfoCompra compra = new NFNotaInfoCompra();
        compra.setNotaDeEmpenho("abcefghijklmnopqrstuvx");
        compra.setPedido("1kG8gghJ0YTrUZnt00BJlOsFCtj43eV5mEHHXUzp3rD6QwwUwX4GPavXkMB1");
        compra.toString();
    }

    @Test
    public void deveGerarXMLSemPedido() {
        final NFNotaInfoCompra compra = new NFNotaInfoCompra();
        compra.setContrato("9tQtearTIcXmO9vxNr3TPhSaItw5mk3zyTVlf2aIFXqqvtXrHoa0qPWKzUzc");
        compra.setNotaDeEmpenho("abcefghijklmnopqrstuvx");
        compra.toString();
    }

    @Test
    public void deveGerarXMLSemNotaDeEmpenho() {
        final NFNotaInfoCompra compra = new NFNotaInfoCompra();
        compra.setContrato("9tQtearTIcXmO9vxNr3TPhSaItw5mk3zyTVlf2aIFXqqvtXrHoa0qPWKzUzc");
        compra.setPedido("1kG8gghJ0YTrUZnt00BJlOsFCtj43eV5mEHHXUzp3rD6QwwUwX4GPavXkMB1");
        compra.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCompra><xNEmp>abcefghijklmnopqrstuvx</xNEmp><xPed>1kG8gghJ0YTrUZnt00BJlOsFCtj43eV5mEHHXUzp3rD6QwwUwX4GPavXkMB1</xPed><xCont>9tQtearTIcXmO9vxNr3TPhSaItw5mk3zyTVlf2aIFXqqvtXrHoa0qPWKzUzc</xCont></NFNotaInfoCompra>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCompra().toString());
    }
}
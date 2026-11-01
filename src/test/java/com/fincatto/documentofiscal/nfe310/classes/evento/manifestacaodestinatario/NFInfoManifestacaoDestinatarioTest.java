package com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFInfoManifestacaoDestinatarioTest {

    @Test
    public void naoDevePermitirSetarCondicaoDeUso() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> new NFInfoManifestacaoDestinatario().setCondicaoUso(""));
    }

    @Test
    public void naoDevePermitirSetarTextoCorrecao() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> new NFInfoManifestacaoDestinatario().setTextoCorrecao(""));
    }

    @Test
    public void deveObterJustificativaComoFoiSetado() {
        final NFInfoManifestacaoDestinatario infoManifestacaoDestinatario = new NFInfoManifestacaoDestinatario();
        final String justificativa = "oHhcRAPtxH7erRCHOgSe3l2qtqwzZDkJZRSYRS5ZW1CH6LifprUDIvMngr49r9Ms0BLl8hlC8maNnVZTNJnmgkUH47rZN9WNQZpD5T4Q1Uc2JTxnHiwAKjlAlwyP5ciZ0xgc2sYaf52ECQlm299JafuEwKiqk7Z2zTyhGwBmeizzo3wX9miZ1M1Cy8B0WclQIIJYI2MgTI0F43ag7qV4p1xfVTvGvMc6W3Urg5AhZZFfgmaOSW4Bx1TYrooGFAC1";
        infoManifestacaoDestinatario.setJustificativa(justificativa);
        Assertions.assertEquals(justificativa, infoManifestacaoDestinatario.getJustificativa());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoManifestacaoDestinatario versao=\"3.10\"><descEvento>Operacao nao Realizada</descEvento><xJust>Justificativa qualquer coisa</xJust></NFInfoManifestacaoDestinatario>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoManifestacaoDestinatario().toString());
    }
}
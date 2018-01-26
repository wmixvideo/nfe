package com.fincatto.documentofiscal.nfe400.classes.evento.manifestacaodestinatario;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFInfoManifestacaoDestinatarioTest {

    @Test(expected = UnsupportedOperationException.class)
    public void naoDevePermitirSetarCondicaoDeUso() {
        new NFInfoManifestacaoDestinatario().setCondicaoUso("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void naoDevePermitirSetarTextoCorrecao() {
        new NFInfoManifestacaoDestinatario().setTextoCorrecao("");
    }

    @Test
    public void deveObterJustificativaComoFoiSetado() {
        final NFInfoManifestacaoDestinatario infoManifestacaoDestinatario = new NFInfoManifestacaoDestinatario();
        final String justificativa = "oHhcRAPtxH7erRCHOgSe3l2qtqwzZDkJZRSYRS5ZW1CH6LifprUDIvMngr49r9Ms0BLl8hlC8maNnVZTNJnmgkUH47rZN9WNQZpD5T4Q1Uc2JTxnHiwAKjlAlwyP5ciZ0xgc2sYaf52ECQlm299JafuEwKiqk7Z2zTyhGwBmeizzo3wX9miZ1M1Cy8B0WclQIIJYI2MgTI0F43ag7qV4p1xfVTvGvMc6W3Urg5AhZZFfgmaOSW4Bx1TYrooGFAC1";
        infoManifestacaoDestinatario.setJustificativa(justificativa);
        Assert.assertEquals(justificativa, infoManifestacaoDestinatario.getJustificativa());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoManifestacaoDestinatario versao=\"4.00\"><descEvento>Operacao nao Realizada</descEvento><xJust>Justificativa qualquer coisa</xJust></NFInfoManifestacaoDestinatario>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoManifestacaoDestinatario().toString());
    }
}
package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaIPI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemImpostoIPINTTest {

    @Test
    public void deveObterNFNotaInfoSituacaoTributariaIPIComoFoiSetado() {
        final NFNotaInfoItemImpostoIPINT itemImpostoIPINT = new NFNotaInfoItemImpostoIPINT();
        final NFNotaInfoSituacaoTributariaIPI entradaIsenta = NFNotaInfoSituacaoTributariaIPI.ENTRADA_ISENTA;
        itemImpostoIPINT.setSituacaoTributariaIPI(entradaIsenta);
        Assertions.assertEquals(entradaIsenta, itemImpostoIPINT.getSituacaoTributariaIPI());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoIPINT itemImpostoIPINT = new NFNotaInfoItemImpostoIPINT();
        itemImpostoIPINT.setSituacaoTributariaIPI(NFNotaInfoSituacaoTributariaIPI.ENTRADA_ISENTA);

        final String xmlEsperado = "<NFNotaInfoItemImpostoIPINT><IPINT>02</IPINT></NFNotaInfoItemImpostoIPINT>";
        Assertions.assertEquals(xmlEsperado, itemImpostoIPINT.toString());
    }
}
package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaIPI;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItemImpostoIPINT;

public class NFNotaInfoItemImpostoIPINTTest {

    @Test
    public void deveObterNFNotaInfoSituacaoTributariaIPIComoFoiSetado() {
        final NFNotaInfoItemImpostoIPINT itemImpostoIPINT = new NFNotaInfoItemImpostoIPINT();
        final NFNotaInfoSituacaoTributariaIPI entradaIsenta = NFNotaInfoSituacaoTributariaIPI.ENTRADA_ISENTA;
        itemImpostoIPINT.setSituacaoTributariaIPI(entradaIsenta);
        Assert.assertEquals(entradaIsenta, itemImpostoIPINT.getSituacaoTributariaIPI());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoIPINT itemImpostoIPINT = new NFNotaInfoItemImpostoIPINT();
        itemImpostoIPINT.setSituacaoTributariaIPI(NFNotaInfoSituacaoTributariaIPI.ENTRADA_ISENTA);

        final String xmlEsperado = "<NFNotaInfoItemImpostoIPINT><IPINT>02</IPINT></NFNotaInfoItemImpostoIPINT>";
        Assert.assertEquals(xmlEsperado, itemImpostoIPINT.toString());
    }
}
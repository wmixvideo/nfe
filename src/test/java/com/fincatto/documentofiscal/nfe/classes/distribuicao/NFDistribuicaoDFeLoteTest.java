package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class NFDistribuicaoDFeLoteTest {

    @Test
    public void deveTerMaisDeUm() {
        final NFDistribuicaoDFeLote lote = new NFDistribuicaoDFeLote();
        lote.setDocZip(Collections.singletonList(new NFDistribuicaoDocumentoZip().setNsu("000000000000000").setValue("Azascwglsdkvnldjfvbpreapsodfdsfklvdsfig").setSchema("3.00")));
        Assert.assertTrue(lote.getDocZip().size() > 0);
    }

    @Test
    public void deveGerarXmlCorretamente() {
        final NFDistribuicaoDFeLote lote = new NFDistribuicaoDFeLote();
        lote.setDocZip(Collections.singletonList(new NFDistribuicaoDocumentoZip().setNsu("000000000000000").setValue("Azascwglsdkvnldjfvbpreapsodfdsfklvdsfig").setSchema("3.00")));
        final String retorno = "<NFDistribuicaoDFeLote><docZip NSU=\"000000000000000\" schema=\"3.00\">Azascwglsdkvnldjfvbpreapsodfdsfklvdsfig</docZip></NFDistribuicaoDFeLote>";
        Assert.assertEquals(retorno, lote.toString());
    }

}

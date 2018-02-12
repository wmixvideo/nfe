package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.junit.Assert;
import org.junit.Test;

public class NFDistribuicaoDocumentoZipTest {

    @Test
    public void deveGerarXmlCorretamente() {
        final NFDistribuicaoDocumentoZip documentoZip = new NFDistribuicaoDocumentoZip();
        documentoZip.setNsu("000000000000001");
        documentoZip.setSchema("procNFe_v3.00.xsd");
        documentoZip.setValue("ZpfDxesvlFiwpvFpoSJOsPWkIhH");
        final String retorno = "<docZip NSU=\"000000000000001\" schema=\"procNFe_v3.00.xsd\">ZpfDxesvlFiwpvFpoSJOsPWkIhH</docZip>";
        Assert.assertEquals(retorno, documentoZip.toString());
    }

}

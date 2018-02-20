package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.junit.Assert;
import org.junit.Test;

public class NFDistribuicaoDocumentoZipTest {

    @Test
    public void deveInformarNSU() {
        final NFDistribuicaoDocumentoZip documentoZip = new NFDistribuicaoDocumentoZip();
        documentoZip.setNsu("000000000000001");
        Assert.assertEquals("000000000000001", documentoZip.getNsu());
    }

    @Test
    public void deveInformarSchema() {
        final NFDistribuicaoDocumentoZip documentoZip = new NFDistribuicaoDocumentoZip();
        documentoZip.setSchema("NFe-4.00");
        Assert.assertEquals("NFe-4.00", documentoZip.getSchema());
    }

    @Test
    public void deveInformarValue() {
        final NFDistribuicaoDocumentoZip documentoZip = new NFDistribuicaoDocumentoZip();
        documentoZip.setValue("luhdluIGDKygskudyGSDKUFkuyIbgdcuhGCKDSugydskcuy");
        Assert.assertEquals("luhdluIGDKygskudyGSDKUFkuyIbgdcuhGCKDSugydskcuy", documentoZip.getValue());
    }

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

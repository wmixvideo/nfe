package com.fincatto.documentofiscal.transformers;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DFDateFormatTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertNotNull(new DFDateFormatTransformer().read("2015-02-15T10:10:10"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        final String data = "2015-02-15T10:10:10";
        final Date dataEsperada = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(data);
        Assert.assertEquals(dataEsperada, new DFDateFormatTransformer().read(data));
    }
}
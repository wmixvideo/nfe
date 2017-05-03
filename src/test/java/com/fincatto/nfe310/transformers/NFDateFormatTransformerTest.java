package com.fincatto.nfe310.transformers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class NFDateFormatTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertNotNull(new NFDateFormatTransformer().read("2015-02-15T10:10:10"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        final String data = "2015-02-15T10:10:10";
        final Date dataEsperada = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(data);
        Assert.assertEquals(dataEsperada, new NFDateFormatTransformer().read(data));
    }
}
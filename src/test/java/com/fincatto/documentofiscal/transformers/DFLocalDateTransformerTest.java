package com.fincatto.documentofiscal.transformers;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DFLocalDateTransformerTest {

    @Test
    public void deveTransformarDataStringEmLocalDate() throws Exception {
        Assert.assertEquals("2006-02-01", new DFLocalDateTransformer().read("2006-02-01-02:00").toString());
        Assert.assertEquals("2006-02-01", new DFLocalDateTransformer().read("2006-02-01").toString());
        Assert.assertEquals("2006-02-01", new DFLocalDateTransformer().read("01/02/2006").toString());
        Assert.assertEquals("2006-02-01", new DFLocalDateTransformer().read("01/02/2006 12:00:01").toString());
    }

    @Test
    public void deveTransformarLocalDateEmString() throws Exception {
        Assert.assertEquals("2015-10-04", new DFLocalDateTransformer().write(LocalDate.of(2015, 10, 4)));
    }
}
package com.fincatto.documentofiscal.transformers;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.YearMonth;

public class DFYearMonthTransformerTest {

    @Test
    public void deveTransformarDataStringEmLocalDate() throws Exception {
        Assert.assertEquals("2006-02", new DFYearMonthTransformer().read("2006-02-01-02:00").toString());
        Assert.assertEquals("2006-02", new DFYearMonthTransformer().read("2006-02-01").toString());
        Assert.assertEquals("2006-02", new DFYearMonthTransformer().read("01/02/2006").toString());
        Assert.assertEquals("2006-02", new DFYearMonthTransformer().read("01/02/2006 12:00:01").toString());
        Assert.assertEquals("2006-02", new DFYearMonthTransformer().read("2006-02-01T00:00:00-03:00").toString());
    }

    @Test
    public void deveTransformarLocalDateEmString() throws Exception {
        Assert.assertEquals("2015-10", new DFYearMonthTransformer().write(YearMonth.of(2015, 10)));
    }
}
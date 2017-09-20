package com.fincatto.documentofiscal.transformers;

import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

public class DFLocalDateTimeTransformerTest {

    @Test
    public void deveTransformarDataStringEmLocalDateTime() throws Exception {
        Assert.assertEquals("2017-09-18T12:14:41.000", new DFLocalDateTimeTransformer().read("2017-09-18T12:14:41").toString());
    }

    @Test
    public void deveTransformarLocalDateTimeEmString() throws Exception {
        Assert.assertEquals("2017-09-18T12:14:41-03:00", new DFLocalDateTimeTransformer().write(new LocalDateTime(2017, 9, 18, 12, 14, 41, 10)));
    }

}

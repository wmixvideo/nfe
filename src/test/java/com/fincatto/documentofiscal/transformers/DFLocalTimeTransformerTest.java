package com.fincatto.documentofiscal.transformers;

import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

public class DFLocalTimeTransformerTest {

    @Test
    public void deveTransformarTimeStringEmLocalTime() throws Exception {
        Assert.assertEquals("12:14:41.000", new DFLocalTimeTransformer().read("12:14:41").toString());
    }

    @Test
    public void deveTransformarLocalTimeEmString() throws Exception {
        Assert.assertEquals("12:14:41", new DFLocalTimeTransformer().write(new LocalTime(12, 14, 41)));
    }

}

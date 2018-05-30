package com.fincatto.documentofiscal.transformers;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

public class DFLocalTimeTransformerTest {

    @Test
    public void deveTransformarTimeStringEmLocalTime() throws Exception {
        Assert.assertEquals("12:14:41", new DFLocalTimeTransformer().read("12:14:41").toString());
    }

    @Test
    public void deveTransformarLocalTimeEmString() throws Exception {
        Assert.assertEquals("12:14:41", new DFLocalTimeTransformer().write(LocalTime.of(12, 14, 41)));
    }

}

package com.fincatto.documentofiscal.transformers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class DFLocalTimeTransformerTest {

    @Test
    public void deveTransformarTimeStringEmLocalTime() throws Exception {
        Assertions.assertEquals("12:14:41", new DFLocalTimeTransformer().read("12:14:41").toString());
    }

    @Test
    public void deveTransformarLocalTimeEmString() throws Exception {
        Assertions.assertEquals("12:14:41", new DFLocalTimeTransformer().write(LocalTime.of(12, 14, 41)));
    }

}

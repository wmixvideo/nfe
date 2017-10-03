package com.fincatto.documentofiscal.transformers;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

public class DFDateTimeTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertNotNull(new DFDateTimeTransformer().read("2017-09-27T15:03:02-03:00"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        final String data = "2017-09-27T15:03:02-03:00";
        final DateTime dataEsperada = new DateTime(2017, 9, 27, 15, 3, 2);//SimpleDatet("yyyy-MM-dd'T'HH:mm:ssZZ").parse(data);
        Assert.assertEquals(data, new DFDateTimeTransformer().write(dataEsperada));
    }

}

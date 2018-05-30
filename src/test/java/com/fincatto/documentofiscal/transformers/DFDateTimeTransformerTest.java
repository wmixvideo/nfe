package com.fincatto.documentofiscal.transformers;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DFDateTimeTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertNotNull(new DFDateTimeTransformer().read("2017-09-27T15:03:02-03:00"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        final String data = "2017-09-27T15:03:02-03:00";
        final ZonedDateTime dataEsperada = ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2017-09-27 15:03:02")), ZoneId.systemDefault());//SimpleDatet("yyyy-MM-dd'T'HH:mm:ssZZ").parse(data);
        Assert.assertEquals(data, new DFDateTimeTransformer().write(dataEsperada));
    }

}

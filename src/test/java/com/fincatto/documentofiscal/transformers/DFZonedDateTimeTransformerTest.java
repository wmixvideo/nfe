package com.fincatto.documentofiscal.transformers;

import com.fincatto.documentofiscal.DFConfig;
import org.junit.Assert;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DFZonedDateTimeTransformerTest {
    
    @Test
    public void deveTransformarDataStringEmZonedDateTime() {
        final ZonedDateTime expected = ZonedDateTime.of(2017, 9, 18, 12, 14, 41, 0, ZoneId.of("-03:00"));
        final ZonedDateTime read = new DFZonedDateTimeTransformer().read("2017-09-18T12:14:41-03:00");
        Assert.assertEquals(expected, read);
    }

//    @Test
//    public void deveTransformarDataStringEmZonedDateTimeSemInfoZona() {
//        final ZonedDateTime expected = ZonedDateTime.of(2019, 5, 20, 9, 5, 58, 0, DFConfig.TIMEZONE_SP.toZoneId());
//        final ZonedDateTime read = new DFZonedDateTimeTransformer().read("2019-05-20T09:04:58");
//        Assert.assertEquals(expected, read);
//    }

    @Test
    public void deveTransformarZonedDateTimeEmString() {
        final String expected = "2017-09-18T12:14:41-03:00";
        final String write = new DFZonedDateTimeTransformer().write(ZonedDateTime.of(2017, 9, 18, 12, 14, 41, 0, DFConfig.TIMEZONE_SP.toZoneId()));
        Assert.assertEquals(expected, write);
    }
}

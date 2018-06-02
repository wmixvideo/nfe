package com.fincatto.documentofiscal.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DFDateTimeTransformer implements Transform<ZonedDateTime> {

    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

    @Override
    public ZonedDateTime read(final String data) throws Exception {
        return ZonedDateTime.parse(data, format);
    }

    @Override
    public String write(final ZonedDateTime data) throws Exception {
        return format.format(data);
    }
}
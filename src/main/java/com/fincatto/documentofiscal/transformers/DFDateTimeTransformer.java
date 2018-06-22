package com.fincatto.documentofiscal.transformers;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.simpleframework.xml.transform.Transform;

public class DFDateTimeTransformer implements Transform<ZonedDateTime> {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

    @Override
    public ZonedDateTime read(final String data) throws Exception {
        return ZonedDateTime.parse(data, DFDateTimeTransformer.FORMAT);
    }

    @Override
    public String write(final ZonedDateTime data) throws Exception {
        return DFDateTimeTransformer.FORMAT.format(data);
    }
}
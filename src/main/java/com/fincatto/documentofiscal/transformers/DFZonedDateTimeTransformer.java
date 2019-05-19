package com.fincatto.documentofiscal.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DFZonedDateTimeTransformer implements Transform<ZonedDateTime> {
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[XXX]");
    
    @Override
    public ZonedDateTime read(final String data) {
        return ZonedDateTime.parse(data, DFZonedDateTimeTransformer.FORMATTER);
    }
    
    @Override
    public String write(final ZonedDateTime data) {
        return DFZonedDateTimeTransformer.FORMATTER.format(data);
    }
}
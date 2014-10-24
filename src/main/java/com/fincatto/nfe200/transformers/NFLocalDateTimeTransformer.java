package com.fincatto.nfe200.transformers;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.simpleframework.xml.transform.Transform;

class NFLocalDateTimeTransformer implements Transform<LocalDateTime> {

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public LocalDateTime read(final String data) throws Exception {
        return LocalDateTime.parse(data, NFLocalDateTimeTransformer.DATETIME_FORMATTER);
    }

    @Override
    public String write(final LocalDateTime data) throws Exception {
        return NFLocalDateTimeTransformer.DATETIME_FORMATTER.print(data);
    }
}
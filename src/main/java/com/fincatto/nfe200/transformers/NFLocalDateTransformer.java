package com.fincatto.nfe200.transformers;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.simpleframework.xml.transform.Transform;

class NFLocalDateTransformer implements Transform<LocalDate> {

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");

    @Override
    public LocalDate read(final String data) throws Exception {
        return LocalDate.parse(data, NFLocalDateTransformer.DATETIME_FORMATTER);
    }

    @Override
    public String write(final LocalDate data) throws Exception {
        return NFLocalDateTransformer.DATETIME_FORMATTER.print(data);
    }
}
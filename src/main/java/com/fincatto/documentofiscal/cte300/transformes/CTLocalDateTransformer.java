package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class CTLocalDateTransformer implements Transform<LocalDate> {
    private static final DateTimeFormatter SIMPLE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-ddXXX");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate read(final String data) {
        try {
            return LocalDate.parse(data, CTLocalDateTransformer.DATETIME_FORMATTER);
        } catch (final IllegalArgumentException e) {
            return  LocalDate.from(CTLocalDateTransformer.SIMPLE_DATE_FORMATTER.parse(data));
        }
    }

    @Override
    public String write(final LocalDate data) {
        return CTLocalDateTransformer.DATETIME_FORMATTER.format(data);
    }
}
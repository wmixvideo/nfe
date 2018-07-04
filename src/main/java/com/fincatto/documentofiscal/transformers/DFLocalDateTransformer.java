package com.fincatto.documentofiscal.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DFLocalDateTransformer implements Transform<LocalDate> {
    private static final DateTimeFormatter SIMPLE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-ddXXX");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate read(final String data) {
        try {
            return LocalDate.parse(data, DFLocalDateTransformer.DATETIME_FORMATTER);
        } catch (final Exception e) {
            return  LocalDate.from(DFLocalDateTransformer.SIMPLE_DATE_FORMATTER.parse(data));
        }
    }

    @Override
    public String write(final LocalDate data) {
        return DFLocalDateTransformer.DATETIME_FORMATTER.format(data);
    }
}
package com.fincatto.documentofiscal.transformers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.simpleframework.xml.transform.Transform;

public class DFLocalDateTransformer implements Transform<LocalDate> {
    private static final DateTimeFormatter SIMPLE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-ddXXX");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATETIME_FORMATTER_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATETIME_FORMATTER_3 = DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm:ss");

    @Override
    public LocalDate read(final String data) {
        try {
            return LocalDate.parse(data, DFLocalDateTransformer.DATETIME_FORMATTER);
        } catch (final Exception e) {
            try {
                return LocalDate.from(DFLocalDateTransformer.SIMPLE_DATE_FORMATTER.parse(data));
            } catch (final Exception e2) {
                try {
                    return LocalDate.from(DFLocalDateTransformer.DATETIME_FORMATTER_2.parse(data));
                } catch (final Exception e3) {
                    return LocalDate.from(DFLocalDateTransformer.DATETIME_FORMATTER_3.parse(data));
                }
            }
        }
    }

    @Override
    public String write(final LocalDate data) {
        return DFLocalDateTransformer.DATETIME_FORMATTER.format(data);
    }
}
package com.fincatto.documentofiscal.transformers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.simpleframework.xml.transform.Transform;

public class DFLocalDateTransformer implements Transform<LocalDate> {
	
    private static final DateTimeFormatter DATE_TIME_FORMATTER_YYYY_MM_DDXXX = DateTimeFormatter.ofPattern("yyyy-MM-ddXXX");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_DD_MM_YYYY_HH_MM_SS = DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm:ss");

    @Override
    public LocalDate read(final String data) {
        try {
            return LocalDate.parse(data, DFLocalDateTransformer.DATE_TIME_FORMATTER_YYYY_MM_DD);
        } catch (final Exception e) {
            try {
                return LocalDate.from(DFLocalDateTransformer.DATE_TIME_FORMATTER_YYYY_MM_DDXXX.parse(data));
            } catch (final Exception e2) {
                try {
                    return LocalDate.from(DFLocalDateTransformer.DATE_TIME_FORMATTER_DD_MM_YYYY.parse(data));
                } catch (final Exception e3) {
                    return LocalDate.from(DFLocalDateTransformer.DATE_TIME_FORMATTER_DD_MM_YYYY_HH_MM_SS.parse(data));
                }
            }
        }
    }

    @Override
    public String write(final LocalDate data) {
        return DFLocalDateTransformer.DATE_TIME_FORMATTER_YYYY_MM_DDXXX.format(data);
    }
}
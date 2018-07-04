package com.fincatto.documentofiscal.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DFLocalDateTimeTransformer implements Transform<LocalDateTime> {

    private static final DateTimeFormatter SIMPLE_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

    @Override
    public LocalDateTime read(final String data) {
        try {
            return LocalDateTime.parse(data, DFLocalDateTimeTransformer.DATETIME_FORMATTER);
        } catch (final Exception e) {
            return  LocalDateTime.from(DFLocalDateTimeTransformer.SIMPLE_DATETIME_FORMATTER.parse(data))
                    .atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
    }

    @Override
    public String write(final LocalDateTime data) {
        return DFLocalDateTimeTransformer.DATETIME_FORMATTER.format(data.atZone(ZoneId.systemDefault()));
    }
}
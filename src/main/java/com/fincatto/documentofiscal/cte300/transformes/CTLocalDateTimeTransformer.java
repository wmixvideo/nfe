package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

class CTLocalDateTimeTransformer implements Transform<LocalDateTime> {

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

    @Override
    public LocalDateTime read(final String data) {
        return LocalDateTime.from(CTLocalDateTimeTransformer.DATETIME_FORMATTER.parse(data))
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public String write(final LocalDateTime data) {
        return CTLocalDateTimeTransformer.DATETIME_FORMATTER.format(data);
    }
}
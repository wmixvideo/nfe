package com.fincatto.documentofiscal.cte300.transformes;

import java.text.SimpleDateFormat;

import org.joda.time.LocalDateTime;
import org.simpleframework.xml.transform.Transform;

class CTLocalDateTimeTransformer implements Transform<LocalDateTime> {

    private static final SimpleDateFormat DATETIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    @Override
    public LocalDateTime read(final String data) throws Exception {
        return LocalDateTime.fromDateFields(CTLocalDateTimeTransformer.DATETIME_FORMATTER.parse(data));
    }

    @Override
    public String write(final LocalDateTime data) throws Exception {
        return CTLocalDateTimeTransformer.DATETIME_FORMATTER.format(data.toDate());
    }
}
package com.fincatto.documentofiscal.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DFZonedDateTimeTransformer implements Transform<ZonedDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[XXX]");

    @Override
    public ZonedDateTime read(final String data) {
        // o offset e opcional no pattern ([XXX]), mas ZonedDateTime.parse exige zona no resultado:
        // quando a SEFAZ devolve data sem offset, cai no fuso do sistema em vez de lancar excecao
        final TemporalAccessor parsed = DFZonedDateTimeTransformer.FORMATTER.parseBest(data, ZonedDateTime::from, LocalDateTime::from);
        return parsed instanceof ZonedDateTime ? (ZonedDateTime) parsed : ((LocalDateTime) parsed).atZone(ZoneId.systemDefault());
    }
    
    @Override
    public String write(final ZonedDateTime data) {
        return DFZonedDateTimeTransformer.FORMATTER.format(data);
    }
}
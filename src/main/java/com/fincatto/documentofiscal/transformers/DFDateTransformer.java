package com.fincatto.documentofiscal.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class DFDateTransformer implements Transform<Date> {

    // DateTimeFormatter e imutavel/thread-safe, ao contrario do SimpleDateFormat usado antes -
    // instancias de Transform sao compartilhadas entre threads pelo Simple XML
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public Date read(final String value) throws Exception {
        return Date.from(LocalDateTime.parse(value, DFDateTransformer.DATE_FORMAT).atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public String write(final Date value) {
        return DFDateTransformer.DATE_FORMAT.format(LocalDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    }
}

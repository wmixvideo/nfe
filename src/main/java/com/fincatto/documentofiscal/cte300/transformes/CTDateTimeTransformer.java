package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class CTDateTimeTransformer implements Transform<ZonedDateTime> {

	private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

    @Override
    public ZonedDateTime read(final String data) {
    	return ZonedDateTime.parse(data, format.withZone(ZoneId.systemDefault()));
    }

    @Override
    public String write(final ZonedDateTime data) {
        return format.format(data);
    }
}
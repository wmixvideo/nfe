package com.fincatto.documentofiscal.transformers;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.simpleframework.xml.transform.Transform;

public class DFDateTimeTransformer implements Transform<DateTime> {

    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ");

    @Override
    public DateTime read(final String data) throws Exception {
        return DFDateTimeTransformer.format.withOffsetParsed().parseDateTime(data);
    }

    @Override
    public String write(final DateTime data) throws Exception {
        return data.toString(DFDateTimeTransformer.format);
    }
}
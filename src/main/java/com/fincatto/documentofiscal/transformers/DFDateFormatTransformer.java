package com.fincatto.documentofiscal.transformers;

import org.simpleframework.xml.transform.Transform;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class DFDateFormatTransformer implements Transform<Date> {

    private final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());

    @Override
    public Date read(final String value) throws Exception {
        return this.DATE_FORMAT.parse(value);
    }

    @Override
    public String write(final Date value) {
        return this.DATE_FORMAT.format(value);
    }
}
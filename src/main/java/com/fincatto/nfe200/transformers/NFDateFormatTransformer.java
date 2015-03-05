package com.fincatto.nfe200.transformers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.simpleframework.xml.transform.Transform;

class NFDateFormatTransformer implements Transform<Date> {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());

    @Override
    public Date read(final String value) throws Exception {
        return NFDateFormatTransformer.DATE_FORMAT.parse(value);
    }

    @Override
    public String write(final Date value) throws Exception {
        return NFDateFormatTransformer.DATE_FORMAT.format(value);
    }
}
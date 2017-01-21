package com.fincatto.nfe310.transformers;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.simpleframework.xml.transform.Transform;

public class NFLocalTimeTransformer implements Transform<LocalTime> {

    @Override
    public LocalTime read(final String time) throws Exception {
        return DateTimeFormat.forPattern("HH:mm:ss").parseLocalTime(time);
    }

    @Override
    public String write(final LocalTime localTime) throws Exception {
        return DateTimeFormat.forPattern("HH:mm:ss").print(localTime);
    }
}
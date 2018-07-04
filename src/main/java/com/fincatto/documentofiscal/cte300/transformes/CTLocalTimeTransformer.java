package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CTLocalTimeTransformer implements Transform<LocalTime> {

    @Override
    public LocalTime read(final String time) {
        return LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss").parse(time));
    }

    @Override
    public String write(final LocalTime localTime) {
        return DateTimeFormatter.ofPattern("HH:mm:ss").format(localTime);
    }
}
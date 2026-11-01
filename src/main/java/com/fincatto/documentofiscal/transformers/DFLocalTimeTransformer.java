package com.fincatto.documentofiscal.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DFLocalTimeTransformer implements Transform<LocalTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public LocalTime read(final String time) {
        return LocalTime.from(DFLocalTimeTransformer.FORMATTER.parse(time));
    }

    @Override
    public String write(final LocalTime localTime) {
        return DateTimeFormatter.ofPattern("HH:mm:ss").format(localTime);
    }
}
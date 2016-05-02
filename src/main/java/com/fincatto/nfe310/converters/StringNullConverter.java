package com.fincatto.nfe310.converters;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class StringNullConverter implements Converter<String> {

    @Override
    public String read(final InputNode node) throws Exception {
        return node.getValue() == null ? "" : node.getValue();
    }

    @Override
    public void write(final OutputNode node, final String value) throws Exception {
        node.setValue(value);
    }
}
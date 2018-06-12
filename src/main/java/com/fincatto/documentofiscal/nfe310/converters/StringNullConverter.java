package com.fincatto.documentofiscal.nfe310.converters;

import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class StringNullConverter implements Converter<String> {

	@Override
	public String read(final InputNode node) throws Exception {
		return StringUtils.defaultIfBlank(node.getValue(), StringUtils.EMPTY);
	}

	@Override
    public void write(final OutputNode node, final String value) {
		node.setValue(value);
	}
}
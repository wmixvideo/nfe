package com.fincatto.nfe310.converters;

import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class StringNullConverter implements Converter<String> {

	@Override
	public String read(final InputNode node) throws Exception {
		final String value = node.getValue(); //estranhamente, ao pegar a primeira vez, na segunda ele retorna nulo (deixar setando a variavel)
		return StringUtils.isNotBlank(value) ? value : StringUtils.EMPTY;
	}

	@Override
	public void write(final OutputNode node, final String value) throws Exception {
		node.setValue(value);
	}
}
package com.fincatto.nfe310.converters;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import com.fincatto.nfe310.classes.NFAmbiente;

public class NFAmbienteConverter implements Converter<NFAmbiente> {

	@Override
	public NFAmbiente read(InputNode node) throws Exception {
		// TODO Auto-generated method stub
		NFAmbiente nfAmbiente = null;
		for (NFAmbiente nfAmbienteAux : NFAmbiente.values()) {
			nfAmbiente = nfAmbienteAux;
		}
		return nfAmbiente;
	}

	@Override
	public void write(OutputNode node, NFAmbiente value) throws Exception {
		node.setValue(value.toString());
	}
}

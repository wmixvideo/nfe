package com.fincatto.nfe310.converters;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFAmbiente;

public class NFAmbienteConverter implements Transform<NFAmbiente> {

	@Override
	public NFAmbiente read(final String codigo) throws Exception {
		return NFAmbiente.valueOfCodigo(codigo);
	}

	@Override
	public String write(final NFAmbiente tipo) throws Exception {
		return tipo.getCodigo();
	}
}

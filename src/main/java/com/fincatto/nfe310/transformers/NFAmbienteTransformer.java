package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFAmbiente;

class NFAmbienteTransformer implements Transform<NFAmbiente> {
	
	@Override
	public NFAmbiente read(final String codigo) throws Exception {
		return NFAmbiente.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFAmbiente ambiente) throws Exception {
		return ambiente.getCodigo();
	}
}
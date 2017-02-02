package com.fincatto.dfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.dfe.classes.DFAmbiente;

class DFAmbienteTransformer implements Transform<DFAmbiente> {
	
	@Override
	public DFAmbiente read(final String codigo) throws Exception {
		return DFAmbiente.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final DFAmbiente ambiente) throws Exception {
		return ambiente.getCodigo();
	}
}
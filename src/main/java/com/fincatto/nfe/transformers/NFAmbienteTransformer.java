package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.Ambiente;

public class NFAmbienteTransformer implements Transform<Ambiente> {
	
	@Override
	public Ambiente read(final String codigo) throws Exception {
		return Ambiente.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final Ambiente ambiente) throws Exception {
		return ambiente.getCodigo();
	}
}
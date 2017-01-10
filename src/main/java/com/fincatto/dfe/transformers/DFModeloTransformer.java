package com.fincatto.dfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.dfe.classes.DFModelo;

class DFModeloTransformer implements Transform<DFModelo> {
	
	@Override
	public DFModelo read(final String codigo) throws Exception {
		return DFModelo.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final DFModelo tipo) throws Exception {
		return tipo.getCodigo();
	}
}
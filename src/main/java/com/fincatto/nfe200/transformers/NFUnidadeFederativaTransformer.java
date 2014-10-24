package com.fincatto.nfe200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe200.classes.NFUnidadeFederativa;

class NFUnidadeFederativaTransformer implements Transform<NFUnidadeFederativa> {
	
	@Override
	public NFUnidadeFederativa read(final String codigo) throws Exception {
		return NFUnidadeFederativa.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFUnidadeFederativa unidadeFederativa) throws Exception {
		return unidadeFederativa.getCodigoIbge();
	}
}
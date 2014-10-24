package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFUnidadeFederativa;

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
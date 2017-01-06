package com.fincatto.dfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.dfe.classes.DFUnidadeFederativa;

class DFUnidadeFederativaTransformer implements Transform<DFUnidadeFederativa> {

	@Override
	public DFUnidadeFederativa read(final String codigo) throws Exception {
		return DFUnidadeFederativa.valueOfCodigo(codigo);
	}

	@Override
	public String write(final DFUnidadeFederativa unidadeFederativa) throws Exception {
		return unidadeFederativa.getCodigoIbge();
	}
}
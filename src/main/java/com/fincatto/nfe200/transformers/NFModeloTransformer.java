package com.fincatto.nfe200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe200.classes.nota.NFModelo;


class NFModeloTransformer implements Transform<NFModelo> {
	
	@Override
	public NFModelo read(final String codigo) throws Exception {
		return NFModelo.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFModelo Modelo) throws Exception {
		return Modelo.getCodigo();
	}
}
package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFModelo;

class NFModeloTransformer implements Transform<NFModelo> {
	
	@Override
	public NFModelo read(final String codigo) throws Exception {
		return NFModelo.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFModelo tipo) throws Exception {
		return tipo.getCodigo();
	}
}
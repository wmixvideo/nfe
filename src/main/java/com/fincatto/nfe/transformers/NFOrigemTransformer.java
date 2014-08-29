package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.NFOrigem;

class NFOrigemTransformer implements Transform<NFOrigem> {
	
	@Override
	public NFOrigem read(final String codigo) throws Exception {
		return NFOrigem.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFOrigem origem) throws Exception {
		return origem.getCodigo();
	}
}
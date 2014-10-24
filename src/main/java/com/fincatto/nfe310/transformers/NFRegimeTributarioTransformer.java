package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFRegimeTributario;

class NFRegimeTributarioTransformer implements Transform<NFRegimeTributario> {
	
	@Override
	public NFRegimeTributario read(final String codigo) throws Exception {
		return NFRegimeTributario.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFRegimeTributario tipo) throws Exception {
		return tipo.getCodigo();
	}
}
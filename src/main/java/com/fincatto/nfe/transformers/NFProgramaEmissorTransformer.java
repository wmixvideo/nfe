package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.NFProgramaEmissor;

class NFProgramaEmissorTransformer implements Transform<NFProgramaEmissor> {
	
	@Override
	public NFProgramaEmissor read(final String codigo) throws Exception {
		return NFProgramaEmissor.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFProgramaEmissor tipo) throws Exception {
		return tipo.getCodigo();
	}
}
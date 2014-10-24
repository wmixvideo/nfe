package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFFinalidade;

class NFFinalidadeTransformer implements Transform<NFFinalidade> {
	
	@Override
	public NFFinalidade read(final String codigo) throws Exception {
		return NFFinalidade.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFFinalidade tipo) throws Exception {
		return tipo.getCodigo();
	}
}
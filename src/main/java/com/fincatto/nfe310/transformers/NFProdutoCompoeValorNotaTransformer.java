package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFProdutoCompoeValorNota;

class NFProdutoCompoeValorNotaTransformer implements Transform<NFProdutoCompoeValorNota> {
	
	@Override
	public NFProdutoCompoeValorNota read(final String codigo) throws Exception {
		return NFProdutoCompoeValorNota.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFProdutoCompoeValorNota tipo) throws Exception {
		return tipo.getCodigo();
	}
}
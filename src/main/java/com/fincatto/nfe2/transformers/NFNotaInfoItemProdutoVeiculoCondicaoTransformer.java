package com.fincatto.nfe2.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe2.classes.NFNotaInfoItemProdutoVeiculoCondicao;

class NFNotaInfoItemProdutoVeiculoCondicaoTransformer implements Transform<NFNotaInfoItemProdutoVeiculoCondicao> {
	
	@Override
	public NFNotaInfoItemProdutoVeiculoCondicao read(final String codigo) throws Exception {
		return NFNotaInfoItemProdutoVeiculoCondicao.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFNotaInfoItemProdutoVeiculoCondicao tipo) throws Exception {
		return tipo.getCodigo();
	}
}
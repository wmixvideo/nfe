package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFNotaInfoItemProdutoVeiculoTipoOperacao;

class NFNotaInfoItemProdutoVeiculoTipoOperacaoTransformer implements Transform<NFNotaInfoItemProdutoVeiculoTipoOperacao> {
	
	@Override
	public NFNotaInfoItemProdutoVeiculoTipoOperacao read(final String codigo) throws Exception {
		return NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFNotaInfoItemProdutoVeiculoTipoOperacao tipo) throws Exception {
		return tipo.getCodigo();
	}
}
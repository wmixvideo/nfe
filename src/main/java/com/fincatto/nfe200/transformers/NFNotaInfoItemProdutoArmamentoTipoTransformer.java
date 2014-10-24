package com.fincatto.nfe200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe200.classes.NFNotaInfoItemProdutoArmamentoTipo;

class NFNotaInfoItemProdutoArmamentoTipoTransformer implements Transform<NFNotaInfoItemProdutoArmamentoTipo> {
	
	@Override
	public NFNotaInfoItemProdutoArmamentoTipo read(final String codigo) throws Exception {
		return NFNotaInfoItemProdutoArmamentoTipo.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFNotaInfoItemProdutoArmamentoTipo tipo) throws Exception {
		return tipo.getCodigo();
	}
}
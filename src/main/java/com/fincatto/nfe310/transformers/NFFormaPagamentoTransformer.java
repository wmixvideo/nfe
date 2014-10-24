package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFFormaPagamentoPrazo;

class NFFormaPagamentoTransformer implements Transform<NFFormaPagamentoPrazo> {
	
	@Override
	public NFFormaPagamentoPrazo read(final String codigo) throws Exception {
		return NFFormaPagamentoPrazo.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFFormaPagamentoPrazo formaPagamento) throws Exception {
		return formaPagamento.getCodigo();
	}
}

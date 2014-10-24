package com.fincatto.nfe200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe200.classes.NFFormaPagamento;

class NFFormaPagamentoTransformer implements Transform<NFFormaPagamento> {
	
	@Override
	public NFFormaPagamento read(final String codigo) throws Exception {
		return NFFormaPagamento.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFFormaPagamento formaPagamento) throws Exception {
		return formaPagamento.getCodigo();
	}
}

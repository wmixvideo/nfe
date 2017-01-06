package com.fincatto.dfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.dfe.classes.DFTipoEmissao;

class DFTipoEmissaoTransformer implements Transform<DFTipoEmissao> {

	@Override
	public DFTipoEmissao read(final String codigo) throws Exception {
		return DFTipoEmissao.valueOfCodigo(codigo);
	}

	@Override
	public String write(final DFTipoEmissao tipo) throws Exception {
		return tipo.getCodigo();
	}
}
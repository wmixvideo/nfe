package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributaria;

class NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributariaTransformer implements Transform<NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributaria> {
	
	@Override
	public NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributaria read(final String codigo) throws Exception {
		return NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributaria.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributaria modalidade) throws Exception {
		return modalidade.getCodigo();
	}
}
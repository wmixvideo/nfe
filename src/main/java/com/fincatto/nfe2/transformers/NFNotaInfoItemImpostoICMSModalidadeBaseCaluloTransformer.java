package com.fincatto.nfe2.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe2.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;

class NFNotaInfoItemImpostoICMSModalidadeBaseCaluloTransformer implements Transform<NFNotaInfoItemImpostoICMSModalidadeBaseCalulo> {
	
	@Override
	public NFNotaInfoItemImpostoICMSModalidadeBaseCalulo read(final String codigo) throws Exception {
		return NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidade) throws Exception {
		return modalidade.getCodigo();
	}
}
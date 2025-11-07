package com.fincatto.documentofiscal.nfe400.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFIndicadorSomaPISST;

public class NFIndicadorSomaPISSTTransformer implements Transform<NFIndicadorSomaPISST> {

	@Override
	public NFIndicadorSomaPISST read(final String codigo) {
		return NFIndicadorSomaPISST.valueOfCodigo(codigo);
	}

	@Override
	public String write(final NFIndicadorSomaPISST indicadorPresencaComprador) {
		return indicadorPresencaComprador.getCodigo();
	}
}
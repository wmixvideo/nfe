package com.fincatto.documentofiscal.cte.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte.CTTipoEmissao;

public class CTTipoEmissaoTransformer implements Transform<CTTipoEmissao> {
	
	@Override
    public CTTipoEmissao read(final String codigo) {
		return CTTipoEmissao.valueOfCodigo(codigo);
	}
	
	@Override
    public String write(final CTTipoEmissao tipo) {
		return tipo.getCodigo();
	}
}
package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTTipoEmissao;

public class CTTipoEmissaoTransformer implements Transform<CTTipoEmissao> {
	
	@Override
	public CTTipoEmissao read(final String codigo) throws Exception {
		return CTTipoEmissao.valueOfCodigo(codigo);
	}
	
	@Override
	public String write(final CTTipoEmissao tipo) throws Exception {
		return tipo.getCodigo();
	}
}
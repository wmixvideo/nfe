package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTProcessoEmissao;

public class CTProcessoEmissaoTransformer implements Transform<CTProcessoEmissao> {

	@Override
	public CTProcessoEmissao read(String arg0) throws Exception {
		// TODO Auto-generated method stub
		return CTProcessoEmissao.valueOfCodigo(arg0);
	}

	@Override
	public String write(CTProcessoEmissao arg0) throws Exception {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

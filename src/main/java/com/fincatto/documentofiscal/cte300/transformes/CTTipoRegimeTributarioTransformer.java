package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTTipoRegimeTributario;

public class CTTipoRegimeTributarioTransformer implements Transform<CTTipoRegimeTributario> {

	@Override
	public CTTipoRegimeTributario read(String arg0) {
		return CTTipoRegimeTributario.valueOfCodigo(arg0);
	}

	@Override
	public String write(CTTipoRegimeTributario arg0) {
		return arg0.getCodigo();
	}
}

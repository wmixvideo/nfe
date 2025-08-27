package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTIndicadoNegociavel;
import org.simpleframework.xml.transform.Transform;

public class CTIndicadoNegociavelTransformer implements Transform<CTIndicadoNegociavel> {

	@Override
    public CTIndicadoNegociavel read(String arg0) {
		return CTIndicadoNegociavel.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTIndicadoNegociavel arg0) {
		return arg0.getCodigo();
	}
}
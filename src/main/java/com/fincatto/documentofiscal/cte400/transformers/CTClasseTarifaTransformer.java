package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTClasseTarifa;
import org.simpleframework.xml.transform.Transform;

public class CTClasseTarifaTransformer implements Transform<CTClasseTarifa> {

	@Override
    public CTClasseTarifa read(String arg0) {
		return CTClasseTarifa.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTClasseTarifa arg0) {
		return arg0.getCodigo();
	}
}

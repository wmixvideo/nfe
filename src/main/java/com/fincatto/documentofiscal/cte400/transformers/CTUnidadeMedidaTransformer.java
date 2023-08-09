package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTUnidadeMedida;
import org.simpleframework.xml.transform.Transform;

public class CTUnidadeMedidaTransformer implements Transform<CTUnidadeMedida> {

	@Override
    public CTUnidadeMedida read(String arg0) {
		return CTUnidadeMedida.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTUnidadeMedida arg0) {
		return arg0.getCodigo();
	}
}
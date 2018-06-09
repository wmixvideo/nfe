package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTUnidadeMedida;
import org.simpleframework.xml.transform.Transform;

public class CTUnidadeMedidaTransformer implements Transform<CTUnidadeMedida> {

	@Override
    public CTUnidadeMedida read(String arg0) {
		// TODO Auto-generated method stub
		return CTUnidadeMedida.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTUnidadeMedida arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

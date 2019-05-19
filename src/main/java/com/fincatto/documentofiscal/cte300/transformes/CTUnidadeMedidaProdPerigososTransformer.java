package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTUnidadeMedidaProdPerigosos;
import org.simpleframework.xml.transform.Transform;

public class CTUnidadeMedidaProdPerigososTransformer implements Transform<CTUnidadeMedidaProdPerigosos> {

	@Override
    public CTUnidadeMedidaProdPerigosos read(String arg0) {
		return CTUnidadeMedidaProdPerigosos.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTUnidadeMedidaProdPerigosos arg0) {
		return arg0.getCodigo();
	}
}
package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTUnidadeMedidaProdPerigosos;

public class CTUnidadeMedidaProdPerigososTransformer implements Transform<CTUnidadeMedidaProdPerigosos> {

	@Override
	public CTUnidadeMedidaProdPerigosos read(String arg0) throws Exception {
		// TODO Auto-generated method stub
		return CTUnidadeMedidaProdPerigosos.valueOfCodigo(arg0);
	}

	@Override
	public String write(CTUnidadeMedidaProdPerigosos arg0) throws Exception {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

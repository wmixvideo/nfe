package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoDataEntrega;

public class CTTipoPrazoDataEntregaTransformer implements Transform<CTTipoPrazoDataEntrega> {

	@Override
	public CTTipoPrazoDataEntrega read(String arg0) throws Exception {
		// TODO Auto-generated method stub
		return CTTipoPrazoDataEntrega.valueOfCodigo(arg0);
	}

	@Override
	public String write(CTTipoPrazoDataEntrega arg0) throws Exception {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

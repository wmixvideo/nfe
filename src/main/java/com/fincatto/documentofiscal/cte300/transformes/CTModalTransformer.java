package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTModal;

public class CTModalTransformer implements Transform<CTModal> {

	@Override
	public CTModal read(String arg0) throws Exception {
		// TODO Auto-generated method stub
		return CTModal.valueOfCodigo(arg0);
	}

	@Override
	public String write(CTModal arg0) throws Exception {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

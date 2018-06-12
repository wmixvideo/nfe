package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTModal;
import org.simpleframework.xml.transform.Transform;


public class CTModalTransformer implements Transform<CTModal> {

	@Override
    public CTModal read(String arg0) {
		// TODO Auto-generated method stub
		return CTModal.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTModal arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

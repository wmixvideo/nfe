package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTModeloNF;
import org.simpleframework.xml.transform.Transform;

public class CTModeloNFTransformer implements Transform<CTModeloNF> {

	@Override
    public CTModeloNF read(String arg0) {
		// TODO Auto-generated method stub
		return CTModeloNF.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTModeloNF arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

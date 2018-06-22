package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTRetirada;
import org.simpleframework.xml.transform.Transform;

public class CTRetiradaTransformer implements Transform<CTRetirada> {

	@Override
    public CTRetirada read(String arg0) {
		// TODO Auto-generated method stub
		return CTRetirada.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTRetirada arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTFinalidade;
import org.simpleframework.xml.transform.Transform;

public class CTFinalidadeTransformes implements Transform<CTFinalidade> {

	@Override
    public CTFinalidade read(String arg0) {
		// TODO Auto-generated method stub
		return CTFinalidade.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTFinalidade arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

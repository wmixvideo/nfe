package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTTipoFerrovia;
import org.simpleframework.xml.transform.Transform;

public class CTTipoFerroviaTransformer implements Transform<CTTipoFerrovia> {

	@Override
    public CTTipoFerrovia read(String arg0) {
		// TODO Auto-generated method stub
		return CTTipoFerrovia.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTTipoFerrovia arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

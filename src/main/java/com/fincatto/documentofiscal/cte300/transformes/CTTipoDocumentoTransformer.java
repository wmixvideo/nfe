package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTTipoDocumento;
import org.simpleframework.xml.transform.Transform;

public class CTTipoDocumentoTransformer implements Transform<CTTipoDocumento> {

	@Override
    public CTTipoDocumento read(String arg0) {
		// TODO Auto-generated method stub
		return CTTipoDocumento.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTTipoDocumento arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTTipoDocumento;

public class CTTipoDocumentoTransformer implements Transform<CTTipoDocumento> {

	@Override
	public CTTipoDocumento read(String arg0) throws Exception {
		// TODO Auto-generated method stub
		return CTTipoDocumento.valueOfCodigo(arg0);
	}

	@Override
	public String write(CTTipoDocumento arg0) throws Exception {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

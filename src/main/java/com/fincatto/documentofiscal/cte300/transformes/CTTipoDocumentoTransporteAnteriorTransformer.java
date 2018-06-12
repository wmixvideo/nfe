package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTTipoDocumentoTransporteAnterior;
import org.simpleframework.xml.transform.Transform;

public class CTTipoDocumentoTransporteAnteriorTransformer implements Transform<CTTipoDocumentoTransporteAnterior> {

	@Override
    public CTTipoDocumentoTransporteAnterior read(String arg0) {
		// TODO Auto-generated method stub
		return CTTipoDocumentoTransporteAnterior.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTTipoDocumentoTransporteAnterior arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTTipoUnidadeTransporte;
import org.simpleframework.xml.transform.Transform;

public class CTTipoUnidadeTransporteTransformer implements Transform<CTTipoUnidadeTransporte> {

	@Override
    public CTTipoUnidadeTransporte read(String arg0) {
		// TODO Auto-generated method stub
		return CTTipoUnidadeTransporte.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTTipoUnidadeTransporte arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

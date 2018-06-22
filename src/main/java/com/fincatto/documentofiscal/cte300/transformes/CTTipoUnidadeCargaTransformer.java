package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTTipoUnidadeCarga;
import org.simpleframework.xml.transform.Transform;

public class CTTipoUnidadeCargaTransformer implements Transform<CTTipoUnidadeCarga> {

	@Override
    public CTTipoUnidadeCarga read(String arg0) {
		// TODO Auto-generated method stub
		return CTTipoUnidadeCarga.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTTipoUnidadeCarga arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

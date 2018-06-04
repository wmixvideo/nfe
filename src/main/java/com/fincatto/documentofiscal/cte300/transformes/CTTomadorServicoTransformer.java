package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTTomadorServico;
import org.simpleframework.xml.transform.Transform;

public class CTTomadorServicoTransformer implements Transform<CTTomadorServico> {

	@Override
    public CTTomadorServico read(String arg0) {
		// TODO Auto-generated method stub
		return CTTomadorServico.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTTomadorServico arg0) {
		// TODO Auto-generated method stub
		return arg0.getCodigo();
	}

}

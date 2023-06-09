package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTomadorServico;
import org.simpleframework.xml.transform.Transform;

public class CTTomadorServicoTransformer implements Transform<CTTomadorServico> {

	@Override
    public CTTomadorServico read(String arg0) {
		return CTTomadorServico.valueOfCodigo(arg0);
	}

	@Override
    public String write(CTTomadorServico arg0) {
		return arg0.getCodigo();
	}
}
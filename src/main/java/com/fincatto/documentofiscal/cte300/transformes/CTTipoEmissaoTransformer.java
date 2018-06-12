package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTTipoEmissao;
import org.simpleframework.xml.transform.Transform;

public class CTTipoEmissaoTransformer implements Transform<CTTipoEmissao> {
	
	@Override
    public CTTipoEmissao read(final String codigo) {
		return CTTipoEmissao.valueOfCodigo(codigo);
	}
	
	@Override
    public String write(final CTTipoEmissao tipo) {
		return tipo.getCodigo();
	}
}
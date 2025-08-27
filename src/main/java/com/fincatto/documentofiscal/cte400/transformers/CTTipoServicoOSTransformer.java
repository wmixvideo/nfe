package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTipoServicoOS;
import org.simpleframework.xml.transform.Transform;

public class CTTipoServicoOSTransformer implements Transform<CTTipoServicoOS> {

    @Override
    public CTTipoServicoOS read(final String codigo) {
        return CTTipoServicoOS.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoServicoOS tipo) {
        return tipo.getCodigo();
    }

}

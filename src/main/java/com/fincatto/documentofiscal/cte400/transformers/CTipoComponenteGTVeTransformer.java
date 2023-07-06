package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTipoComponenteGTVe;
import org.simpleframework.xml.transform.Transform;

public class CTipoComponenteGTVeTransformer implements Transform<CTipoComponenteGTVe> {

    @Override
    public CTipoComponenteGTVe read(final String codigo) {
        return CTipoComponenteGTVe.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTipoComponenteGTVe tipo) {
        return tipo.getCodigo();
    }

}

package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTipoRegimeIBSCBS;
import org.simpleframework.xml.transform.Transform;

public class CTTipoRegimeIBSCBSTransformer implements Transform<CTTipoRegimeIBSCBS> {

    @Override
    public CTTipoRegimeIBSCBS read(final String codigo) {
        return CTTipoRegimeIBSCBS.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoRegimeIBSCBS tipo) {
        return tipo.getCodigo();
    }
}

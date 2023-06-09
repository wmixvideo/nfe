package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTipoTrafego;
import org.simpleframework.xml.transform.Transform;

public class CTTipoTrafegoTransformer implements Transform<CTTipoTrafego> {
    
    @Override
    public CTTipoTrafego read(String arg0) {
        return CTTipoTrafego.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTTipoTrafego arg0) {
        return arg0.getCodigo();
    }
}
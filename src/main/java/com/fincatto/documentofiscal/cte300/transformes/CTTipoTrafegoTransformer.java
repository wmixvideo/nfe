package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTTipoTrafego;

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
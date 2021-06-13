package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTModeloNF;

public class CTModeloNFTransformer implements Transform<CTModeloNF> {
    
    @Override
    public CTModeloNF read(String arg0) {
        return CTModeloNF.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTModeloNF arg0) {
        return arg0.getCodigo();
    }
}
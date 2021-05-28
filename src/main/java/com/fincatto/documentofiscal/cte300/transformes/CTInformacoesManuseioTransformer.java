package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTInformacoesManuseio;

public class CTInformacoesManuseioTransformer implements Transform<CTInformacoesManuseio> {
    
    @Override
    public CTInformacoesManuseio read(String arg0) {
        return CTInformacoesManuseio.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTInformacoesManuseio arg0) {
        return arg0.getCodigo();
    }
}
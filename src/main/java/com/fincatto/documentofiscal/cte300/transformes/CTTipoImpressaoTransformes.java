package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTTipoImpressao;

public class CTTipoImpressaoTransformes implements Transform<CTTipoImpressao> {
    
    @Override
    public CTTipoImpressao read(String arg0) {
        return CTTipoImpressao.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTTipoImpressao arg0) {
        return arg0.getCodigo();
    }
}
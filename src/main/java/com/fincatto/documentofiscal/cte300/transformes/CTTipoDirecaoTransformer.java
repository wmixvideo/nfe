package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTTipoDirecao;
import org.simpleframework.xml.transform.Transform;

public class CTTipoDirecaoTransformer implements Transform<CTTipoDirecao> {
    
    @Override
    public CTTipoDirecao read(String arg0) {
        return CTTipoDirecao.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTTipoDirecao arg0) {
        return arg0.getCodigo();
    }
}
package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTFinalidade;
import org.simpleframework.xml.transform.Transform;

public class CTFinalidadeTransformes implements Transform<CTFinalidade> {
    
    @Override
    public CTFinalidade read(String arg0) {
        return CTFinalidade.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTFinalidade arg0) {
        return arg0.getCodigo();
    }
}

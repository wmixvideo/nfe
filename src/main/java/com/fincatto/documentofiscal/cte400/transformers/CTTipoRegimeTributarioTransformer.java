package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTipoRegimeTributario;
import org.simpleframework.xml.transform.Transform;

public class CTTipoRegimeTributarioTransformer implements Transform<CTTipoRegimeTributario> {
    
    @Override
    public CTTipoRegimeTributario read(String arg0) {
        return CTTipoRegimeTributario.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTTipoRegimeTributario arg0) {
        return arg0.getCodigo();
    }
}

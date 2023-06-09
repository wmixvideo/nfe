package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTModal;
import org.simpleframework.xml.transform.Transform;

public class CTModalTransformer implements Transform<CTModal> {
    
    @Override
    public CTModal read(String arg0) {
        return CTModal.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTModal arg0) {
        return arg0.getCodigo();
    }
}
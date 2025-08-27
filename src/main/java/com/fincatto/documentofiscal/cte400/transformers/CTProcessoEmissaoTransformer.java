package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTProcessoEmissao;
import org.simpleframework.xml.transform.Transform;

public class CTProcessoEmissaoTransformer implements Transform<CTProcessoEmissao> {
    
    @Override
    public CTProcessoEmissao read(String arg0) {
        return CTProcessoEmissao.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTProcessoEmissao arg0) {
        return arg0.getCodigo();
    }
}
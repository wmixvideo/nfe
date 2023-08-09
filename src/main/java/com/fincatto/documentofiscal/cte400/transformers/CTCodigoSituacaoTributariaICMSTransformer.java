package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTCodigoSituacaoTributariaICMS;
import org.simpleframework.xml.transform.Transform;

public class CTCodigoSituacaoTributariaICMSTransformer implements Transform<CTCodigoSituacaoTributariaICMS> {
    
    @Override
    public CTCodigoSituacaoTributariaICMS read(String arg0) {
        return CTCodigoSituacaoTributariaICMS.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTCodigoSituacaoTributariaICMS arg0) {
        return arg0.getCodigo();
    }
}

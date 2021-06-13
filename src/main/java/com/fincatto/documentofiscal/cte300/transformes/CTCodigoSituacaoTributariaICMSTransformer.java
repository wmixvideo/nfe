package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTCodigoSituacaoTributariaICMS;

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

package com.fincatto.documentofiscal.cte300.transformes;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte300.classes.CTTipoServico;

public class CTTipoServicoTransformer implements Transform<CTTipoServico> {
    
    @Override
    public CTTipoServico read(String arg0) {
        return CTTipoServico.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTTipoServico arg0) {
        return arg0.getCodigo();
    }
}
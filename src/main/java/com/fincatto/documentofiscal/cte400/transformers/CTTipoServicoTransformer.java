package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTipoServico;
import org.simpleframework.xml.transform.Transform;

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
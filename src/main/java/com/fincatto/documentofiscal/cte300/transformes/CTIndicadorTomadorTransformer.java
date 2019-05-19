package com.fincatto.documentofiscal.cte300.transformes;

import com.fincatto.documentofiscal.cte300.classes.CTIndicadorTomador;
import org.simpleframework.xml.transform.Transform;

public class CTIndicadorTomadorTransformer implements Transform<CTIndicadorTomador> {
    
    @Override
    public CTIndicadorTomador read(String arg0) {
        return CTIndicadorTomador.valueOfCodigo(arg0);
    }
    
    @Override
    public String write(CTIndicadorTomador arg0) {
        return arg0.getCodigo();
    }
}

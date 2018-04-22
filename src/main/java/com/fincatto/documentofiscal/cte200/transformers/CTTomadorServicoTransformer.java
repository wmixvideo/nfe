package com.fincatto.documentofiscal.cte200.transformers;

import com.fincatto.documentofiscal.cte200.classes.CTTomadorServico;
import org.simpleframework.xml.transform.Transform;

public class CTTomadorServicoTransformer implements Transform<CTTomadorServico> {

    @Override
    public CTTomadorServico read(final String codigo) throws Exception {
        return CTTomadorServico.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTomadorServico tipo) throws Exception {
        return tipo.getCodigo();
    }
}
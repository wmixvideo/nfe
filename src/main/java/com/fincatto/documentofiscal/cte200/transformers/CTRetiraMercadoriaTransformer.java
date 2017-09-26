package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTRetiraMercadoria;

public class CTRetiraMercadoriaTransformer implements Transform<CTRetiraMercadoria> {

    @Override
    public CTRetiraMercadoria read(final String codigo) throws Exception {
        return CTRetiraMercadoria.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTRetiraMercadoria tipo) throws Exception {
        return tipo.getCodigo();
    }
}
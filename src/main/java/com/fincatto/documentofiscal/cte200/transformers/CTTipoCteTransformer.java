package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTTipoCte;

public class CTTipoCteTransformer implements Transform<CTTipoCte> {

    @Override
    public CTTipoCte read(final String codigo) throws Exception {
        return CTTipoCte.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoCte tipo) throws Exception {
        return tipo.getCodigo();
    }
}
package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTIdentificadorEmissor;

public class CTIdentificadorEmissorTransformer implements Transform<CTIdentificadorEmissor> {

    @Override
    public CTIdentificadorEmissor read(final String codigo) throws Exception {
        return CTIdentificadorEmissor.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTIdentificadorEmissor tipo) throws Exception {
        return tipo.getCodigo();
    }
}
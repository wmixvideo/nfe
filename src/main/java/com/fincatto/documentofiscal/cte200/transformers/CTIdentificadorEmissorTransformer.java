package com.fincatto.documentofiscal.cte200.transformers;

import com.fincatto.documentofiscal.cte200.classes.CTIdentificadorEmissor;
import org.simpleframework.xml.transform.Transform;

public class CTIdentificadorEmissorTransformer implements Transform<CTIdentificadorEmissor> {

    @Override
    public CTIdentificadorEmissor read(final String codigo) {
        return CTIdentificadorEmissor.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTIdentificadorEmissor tipo) {
        return tipo.getCodigo();
    }
}
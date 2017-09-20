package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTUnidadeMedida;

public class CTUnidadeMedidaTransformer implements Transform<CTUnidadeMedida> {

    @Override
    public CTUnidadeMedida read(final String codigo) throws Exception {
        return CTUnidadeMedida.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTUnidadeMedida tipo) throws Exception {
        return tipo.getCodigo();
    }
}
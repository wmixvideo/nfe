package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTTipoUnidadeTransporte;

public class CTTipoUnidadeTransporteTransformer implements Transform<CTTipoUnidadeTransporte> {

    @Override
    public CTTipoUnidadeTransporte read(final String codigo) throws Exception {
        return CTTipoUnidadeTransporte.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoUnidadeTransporte tipo) throws Exception {
        return tipo.getCodigo();
    }
}
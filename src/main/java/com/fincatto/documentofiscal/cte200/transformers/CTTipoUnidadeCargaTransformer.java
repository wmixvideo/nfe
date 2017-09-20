package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTTipoUnidadeCarga;

public class CTTipoUnidadeCargaTransformer implements Transform<CTTipoUnidadeCarga> {

    @Override
    public CTTipoUnidadeCarga read(final String codigo) throws Exception {
        return CTTipoUnidadeCarga.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoUnidadeCarga tipo) throws Exception {
        return tipo.getCodigo();
    }
}
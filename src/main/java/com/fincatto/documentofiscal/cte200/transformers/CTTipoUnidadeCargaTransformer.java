package com.fincatto.documentofiscal.cte200.transformers;

import com.fincatto.documentofiscal.cte200.classes.CTTipoUnidadeCarga;
import org.simpleframework.xml.transform.Transform;

public class CTTipoUnidadeCargaTransformer implements Transform<CTTipoUnidadeCarga> {

    @Override
    public CTTipoUnidadeCarga read(final String codigo) {
        return CTTipoUnidadeCarga.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoUnidadeCarga tipo) {
        return tipo.getCodigo();
    }
}
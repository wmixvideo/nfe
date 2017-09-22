package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTTipoEntregaData;

public class CTTipoEntregaDataTransformer implements Transform<CTTipoEntregaData> {

    @Override
    public CTTipoEntregaData read(final String codigo) throws Exception {
        return CTTipoEntregaData.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoEntregaData tipo) throws Exception {
        return tipo.getCodigo();
    }
}
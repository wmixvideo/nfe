package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTTipoImpressao;

public class CTTipoImpressaoTransformer implements Transform<CTTipoImpressao> {

    @Override
    public CTTipoImpressao read(final String codigo) throws Exception {
        return CTTipoImpressao.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoImpressao tipo) throws Exception {
        return tipo.getCodigo();
    }
}
package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTModal;

public class CTModalTransformer implements Transform<CTModal> {

    @Override
    public CTModal read(final String codigo) throws Exception {
        return CTModal.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTModal tipo) throws Exception {
        return tipo.getCodigo();
    }
}
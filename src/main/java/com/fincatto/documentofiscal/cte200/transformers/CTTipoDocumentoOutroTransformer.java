package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTTipoDocumentoOutro;

public class CTTipoDocumentoOutroTransformer implements Transform<CTTipoDocumentoOutro> {

    @Override
    public CTTipoDocumentoOutro read(final String codigo) throws Exception {
        return CTTipoDocumentoOutro.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoDocumentoOutro tipo) throws Exception {
        return tipo.getCodigo();
    }
}
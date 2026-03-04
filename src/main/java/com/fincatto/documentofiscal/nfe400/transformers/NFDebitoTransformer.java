package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFDebito;
import org.simpleframework.xml.transform.Transform;

public class NFDebitoTransformer implements Transform<NFDebito> {
    @Override
    public NFDebito read(final String codigo) {
        return NFDebito.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFDebito tipo) {
        return tipo.getCodigo();
    }
}

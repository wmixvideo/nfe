package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.simpleframework.xml.transform.Transform;

public class NFOrigemTransformer implements Transform<NFOrigem> {

    @Override
    public NFOrigem read(final String codigo) {
        return NFOrigem.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFOrigem origem) {
        return origem.getCodigo();
    }
}
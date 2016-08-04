package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFOrigem;
import org.simpleframework.xml.transform.Transform;

class NFOrigemTransformer implements Transform<NFOrigem> {

    @Override
    public NFOrigem read(final String codigo) throws Exception {
        return NFOrigem.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFOrigem origem) throws Exception {
        return origem.getCodigo();
    }
}
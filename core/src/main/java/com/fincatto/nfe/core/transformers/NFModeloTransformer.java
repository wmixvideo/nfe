package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFModelo;
import org.simpleframework.xml.transform.Transform;

class NFModeloTransformer implements Transform<NFModelo> {

    @Override
    public NFModelo read(final String codigo) throws Exception {
        return NFModelo.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFModelo tipo) throws Exception {
        return tipo.getCodigo();
    }
}
package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFRegimeTributario;
import org.simpleframework.xml.transform.Transform;

class NFRegimeTributarioTransformer implements Transform<NFRegimeTributario> {

    @Override
    public NFRegimeTributario read(final String codigo) throws Exception {
        return NFRegimeTributario.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFRegimeTributario tipo) throws Exception {
        return tipo.getCodigo();
    }
}
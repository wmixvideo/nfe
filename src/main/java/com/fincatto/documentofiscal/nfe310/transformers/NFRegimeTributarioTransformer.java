package com.fincatto.documentofiscal.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe310.classes.NFRegimeTributario;

public class NFRegimeTributarioTransformer implements Transform<NFRegimeTributario> {

    @Override
    public NFRegimeTributario read(final String codigo) throws Exception {
        return NFRegimeTributario.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFRegimeTributario tipo) throws Exception {
        return tipo.getCodigo();
    }
}
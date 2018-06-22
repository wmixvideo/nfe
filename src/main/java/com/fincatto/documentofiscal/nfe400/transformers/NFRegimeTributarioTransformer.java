package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFRegimeTributario;
import org.simpleframework.xml.transform.Transform;

public class NFRegimeTributarioTransformer implements Transform<NFRegimeTributario> {

    @Override
    public NFRegimeTributario read(final String codigo) {
        return NFRegimeTributario.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFRegimeTributario tipo) {
        return tipo.getCodigo();
    }
}
package com.fincatto.documentofiscal.transformers;

import com.fincatto.documentofiscal.DFModelo;
import org.simpleframework.xml.transform.Transform;

public class DFModeloTransformer implements Transform<DFModelo> {

    @Override
    public DFModelo read(final String codigo) throws Exception {
        return DFModelo.valueOfCodigo(codigo);
    }

    @Override
    public String write(final DFModelo tipo) throws Exception {
        return tipo.getCodigo();
    }
}
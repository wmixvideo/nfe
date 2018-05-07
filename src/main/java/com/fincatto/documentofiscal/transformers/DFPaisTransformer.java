package com.fincatto.documentofiscal.transformers;

import com.fincatto.documentofiscal.DFPais;
import org.simpleframework.xml.transform.Transform;

public class DFPaisTransformer implements Transform<DFPais> {

    @Override
    public DFPais read(final String codigo) throws Exception {
        return DFPais.valueOfCodigo(codigo);
    }

    @Override
    public String write(final DFPais unidadeFederativa) throws Exception {
        return unidadeFederativa.getCodigo().toString();
    }
}
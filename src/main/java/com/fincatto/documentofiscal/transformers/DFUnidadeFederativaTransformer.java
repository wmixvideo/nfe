package com.fincatto.documentofiscal.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.DFUnidadeFederativa;

public class DFUnidadeFederativaTransformer implements Transform<DFUnidadeFederativa> {

    @Override
    public DFUnidadeFederativa read(final String codigo) throws Exception {
        return DFUnidadeFederativa.valueOfCodigo(codigo);
    }

    @Override
    public String write(final DFUnidadeFederativa unidadeFederativa) throws Exception {
        return unidadeFederativa.getCodigoIbge();
    }
}
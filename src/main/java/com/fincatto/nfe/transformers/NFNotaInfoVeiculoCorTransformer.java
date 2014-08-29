package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.NFNotaInfoVeiculoCor;

public class NFNotaInfoVeiculoCorTransformer implements Transform<NFNotaInfoVeiculoCor> {

    @Override
    public NFNotaInfoVeiculoCor read(final String codigoVeiculoCor) throws Exception {
        return null;
    }

    @Override
    public String write(final NFNotaInfoVeiculoCor veiculoCor) throws Exception {
        return veiculoCor.getCodigo();
    }
}
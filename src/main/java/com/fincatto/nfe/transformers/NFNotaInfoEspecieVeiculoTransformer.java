package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.nota.NFNotaInfoEspecieVeiculo;

public class NFNotaInfoEspecieVeiculoTransformer implements Transform<NFNotaInfoEspecieVeiculo> {

    @Override
    public NFNotaInfoEspecieVeiculo read(final String codigoEspecieVeiculo) throws Exception {
        return null;
    }

    @Override
    public String write(final NFNotaInfoEspecieVeiculo especieVeiculo) throws Exception {
        return especieVeiculo.getCodigo();
    }
}
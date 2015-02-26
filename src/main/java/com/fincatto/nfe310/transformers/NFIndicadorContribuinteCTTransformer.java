package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.cadastro.NFIndicadorContribuinteCTe;

public class NFIndicadorContribuinteCTTransformer implements Transform<NFIndicadorContribuinteCTe> {

    @Override
    public NFIndicadorContribuinteCTe read(final String codigo) throws Exception {
        return NFIndicadorContribuinteCTe.valueOfCodigo(Integer.valueOf(codigo));
    }

    @Override
    public String write(final NFIndicadorContribuinteCTe indicador) throws Exception {
        return String.valueOf(indicador.getCodigo());
    }
}
package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.cadastro.NFIndicadorContribuinteCTe;
import org.simpleframework.xml.transform.Transform;

public class NFIndicadorContribuinteCTTransformer implements Transform<NFIndicadorContribuinteCTe> {

    @Override
    public NFIndicadorContribuinteCTe read(final String codigo) throws Exception {
        return NFIndicadorContribuinteCTe.valueOfCodigo(Integer.parseInt(codigo));
    }

    @Override
    public String write(final NFIndicadorContribuinteCTe indicador) throws Exception {
        return String.valueOf(indicador.getCodigo());
    }
}
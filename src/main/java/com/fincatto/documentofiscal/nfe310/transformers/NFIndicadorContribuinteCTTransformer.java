package com.fincatto.documentofiscal.nfe310.transformers;

import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFIndicadorContribuinteCTe;
import org.simpleframework.xml.transform.Transform;

public class NFIndicadorContribuinteCTTransformer implements Transform<NFIndicadorContribuinteCTe> {

    @Override
    public NFIndicadorContribuinteCTe read(final String codigo) {
        return NFIndicadorContribuinteCTe.valueOfCodigo(Integer.parseInt(codigo));
    }

    @Override
    public String write(final NFIndicadorContribuinteCTe indicador) {
        return String.valueOf(indicador.getCodigo());
    }
}
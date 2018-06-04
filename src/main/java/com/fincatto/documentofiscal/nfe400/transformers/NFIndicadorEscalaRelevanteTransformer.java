package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFIndicadorEscalaRelevante;
import org.simpleframework.xml.transform.Transform;

public class NFIndicadorEscalaRelevanteTransformer implements Transform<NFIndicadorEscalaRelevante> {

    @Override
    public NFIndicadorEscalaRelevante read(final String codigo) {
        return NFIndicadorEscalaRelevante.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFIndicadorEscalaRelevante nfIndicadorEscalaRelevante) {
        return nfIndicadorEscalaRelevante.getCodigo();
    }
}
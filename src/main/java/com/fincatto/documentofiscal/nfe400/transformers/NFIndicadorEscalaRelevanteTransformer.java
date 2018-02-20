package com.fincatto.documentofiscal.nfe400.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFIndicadorEscalaRelevante;

public class NFIndicadorEscalaRelevanteTransformer implements Transform<NFIndicadorEscalaRelevante> {

    @Override
    public NFIndicadorEscalaRelevante read(final String codigo) throws Exception {
        return NFIndicadorEscalaRelevante.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFIndicadorEscalaRelevante indicadorPresencaComprador) throws Exception {
        return indicadorPresencaComprador.getCodigo();
    }
}
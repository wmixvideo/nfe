package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFProcessoEmissor;
import org.simpleframework.xml.transform.Transform;

class NFProgramaEmissorTransformer implements Transform<NFProcessoEmissor> {

    @Override
    public NFProcessoEmissor read(final String codigo) throws Exception {
        return NFProcessoEmissor.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFProcessoEmissor tipo) throws Exception {
        return tipo.getCodigo();
    }
}
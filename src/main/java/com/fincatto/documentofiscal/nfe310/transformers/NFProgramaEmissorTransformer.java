package com.fincatto.documentofiscal.nfe310.transformers;

import com.fincatto.documentofiscal.nfe310.classes.NFProcessoEmissor;
import org.simpleframework.xml.transform.Transform;

public class NFProgramaEmissorTransformer implements Transform<NFProcessoEmissor> {

    @Override
    public NFProcessoEmissor read(final String codigo) throws Exception {
        return NFProcessoEmissor.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFProcessoEmissor tipo) throws Exception {
        return tipo.getCodigo();
    }
}
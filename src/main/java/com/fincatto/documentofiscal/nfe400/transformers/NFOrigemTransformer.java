package com.fincatto.documentofiscal.nfe400.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;

public class NFOrigemTransformer implements Transform<NFOrigem> {

    @Override
    public NFOrigem read(final String codigo) throws Exception {
        return NFOrigem.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFOrigem origem) throws Exception {
        return origem.getCodigo();
    }
}
package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFOrigemProcesso;

public class NFOrigemProcessoTransformer implements Transform<NFOrigemProcesso> {

    @Override
    public NFOrigemProcesso read(final String codigo) throws Exception {
        return NFOrigemProcesso.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFOrigemProcesso origemProcesso) throws Exception {
        return origemProcesso.getCodigo();
    }
}
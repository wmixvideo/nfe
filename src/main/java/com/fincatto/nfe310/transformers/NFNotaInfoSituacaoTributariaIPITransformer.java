package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFNotaInfoSituacaoTributariaIPI;

public class NFNotaInfoSituacaoTributariaIPITransformer implements Transform<NFNotaInfoSituacaoTributariaIPI> {

    @Override
    public NFNotaInfoSituacaoTributariaIPI read(final String codigo) throws Exception {
        return NFNotaInfoSituacaoTributariaIPI.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoSituacaoTributariaIPI situacaoTributariaIPI) throws Exception {
        return situacaoTributariaIPI.getCodigo();
    }
}
package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.NFnotaInfoItemModalidadeBCICMSST;

public class NFnotaInfoItemModalidadeBCICMSSTTransformer implements Transform<NFnotaInfoItemModalidadeBCICMSST> {

    @Override
    public NFnotaInfoItemModalidadeBCICMSST read(final String codigo) throws Exception {
        return NFnotaInfoItemModalidadeBCICMSST.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFnotaInfoItemModalidadeBCICMSST modalidadeBCICMSST) throws Exception {
        return modalidadeBCICMSST.getCodigo();
    }
}
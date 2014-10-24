package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFNotaInfoItemModalidadeBCICMSST;

public class NFnotaInfoItemModalidadeBCICMSSTTransformer implements Transform<NFNotaInfoItemModalidadeBCICMSST> {

    @Override
    public NFNotaInfoItemModalidadeBCICMSST read(final String codigo) throws Exception {
        return NFNotaInfoItemModalidadeBCICMSST.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST) throws Exception {
        return modalidadeBCICMSST.getCodigo();
    }
}
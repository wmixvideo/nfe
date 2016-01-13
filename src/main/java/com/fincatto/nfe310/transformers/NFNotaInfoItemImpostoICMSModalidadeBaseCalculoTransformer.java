package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalculo;

class NFNotaInfoItemImpostoICMSModalidadeBaseCalculoTransformer implements Transform<NFNotaInfoItemImpostoICMSModalidadeBaseCalculo> {

    @Override
    public NFNotaInfoItemImpostoICMSModalidadeBaseCalculo read(final String codigo) throws Exception {
        return NFNotaInfoItemImpostoICMSModalidadeBaseCalculo.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoItemImpostoICMSModalidadeBaseCalculo modalidade) throws Exception {
        return modalidade.getCodigo();
    }
}
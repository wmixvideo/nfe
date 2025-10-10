package com.fincatto.documentofiscal.nfe400.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIS;

public class NFNotaInfoImpostoTributacaoISTransformer implements Transform<NFNotaInfoImpostoTributacaoIS> {

    @Override
    public NFNotaInfoImpostoTributacaoIS read(final String cstIs) {
        return NFNotaInfoImpostoTributacaoIS.valueOfCodigo(cstIs);
    }

    @Override
    public String write(final NFNotaInfoImpostoTributacaoIS cstIs) {
        return cstIs.getCodigo();
    }
}
package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.NFNotaInfoImpostoTributacaoICMS;

public class NFNotaInfoImpostoTributacaoICMSTransformer implements Transform<NFNotaInfoImpostoTributacaoICMS> {

    @Override
    public NFNotaInfoImpostoTributacaoICMS read(final String icms) throws Exception {
        return null;
    }

    @Override
    public String write(final NFNotaInfoImpostoTributacaoICMS icms) throws Exception {
        return icms.getCodigo();
    }
}
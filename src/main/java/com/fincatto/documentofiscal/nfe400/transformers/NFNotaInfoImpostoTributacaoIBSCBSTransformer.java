package com.fincatto.documentofiscal.nfe400.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS;

public class NFNotaInfoImpostoTributacaoIBSCBSTransformer implements Transform<NFNotaInfoImpostoTributacaoIBSCBS> {

    @Override
    public NFNotaInfoImpostoTributacaoIBSCBS read(final String icms) {
        return NFNotaInfoImpostoTributacaoIBSCBS.valueOfCodigo(icms);
    }

    @Override
    public String write(final NFNotaInfoImpostoTributacaoIBSCBS icms) {
        return icms.getCodigo();
    }
}
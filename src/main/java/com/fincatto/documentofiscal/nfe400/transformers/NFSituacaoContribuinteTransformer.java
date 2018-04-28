package com.fincatto.documentofiscal.nfe400.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe400.classes.cadastro.NFSituacaoContribuinte;

public class NFSituacaoContribuinteTransformer implements Transform<NFSituacaoContribuinte> {

    @Override
    public NFSituacaoContribuinte read(final String codigoSituacaoContribuinte) throws Exception {
        return NFSituacaoContribuinte.valueOfCodigo(Integer.parseInt(codigoSituacaoContribuinte));
    }

    @Override
    public String write(final NFSituacaoContribuinte situacaoContribuinte) throws Exception {
        return String.valueOf(situacaoContribuinte.getCodigo());
    }
}
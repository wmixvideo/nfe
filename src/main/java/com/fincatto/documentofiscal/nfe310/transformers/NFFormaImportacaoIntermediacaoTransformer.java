package com.fincatto.documentofiscal.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe310.classes.nota.NFFormaImportacaoIntermediacao;

public class NFFormaImportacaoIntermediacaoTransformer implements Transform<NFFormaImportacaoIntermediacao> {

    @Override
    public NFFormaImportacaoIntermediacao read(final String codigo) throws Exception {
        return NFFormaImportacaoIntermediacao.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFFormaImportacaoIntermediacao intermediacao) throws Exception {
        return intermediacao.getCodigo();
    }
}
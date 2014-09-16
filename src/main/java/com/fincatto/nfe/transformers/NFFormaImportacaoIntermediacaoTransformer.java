package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.nota.NFFormaImportacaoIntermediacao;

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
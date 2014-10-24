package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.nota.NFNotaInfoRegimeEspecialTributacao;

public class NFNotaInfoRegimeEspecialTributacaoTransformer implements Transform<NFNotaInfoRegimeEspecialTributacao> {

    @Override
    public NFNotaInfoRegimeEspecialTributacao read(final String codigo) throws Exception {
        return NFNotaInfoRegimeEspecialTributacao.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoRegimeEspecialTributacao tributacao) throws Exception {
        return tributacao.getCodigo();
    }
}
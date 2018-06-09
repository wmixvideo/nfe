package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoRegimeEspecialTributacao;
import org.simpleframework.xml.transform.Transform;

public class NFNotaInfoRegimeEspecialTributacaoTransformer implements Transform<NFNotaInfoRegimeEspecialTributacao> {

    @Override
    public NFNotaInfoRegimeEspecialTributacao read(final String codigo) {
        return NFNotaInfoRegimeEspecialTributacao.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoRegimeEspecialTributacao tributacao) {
        return tributacao.getCodigo();
    }
}
package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.nota.NFNotaInfoRegimeEspecialTributacao;
import org.simpleframework.xml.transform.Transform;

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
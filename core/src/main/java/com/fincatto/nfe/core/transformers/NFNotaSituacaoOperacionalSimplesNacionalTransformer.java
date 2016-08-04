package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFNotaSituacaoOperacionalSimplesNacional;
import org.simpleframework.xml.transform.Transform;

public class NFNotaSituacaoOperacionalSimplesNacionalTransformer implements Transform<NFNotaSituacaoOperacionalSimplesNacional> {

    @Override
    public NFNotaSituacaoOperacionalSimplesNacional read(final String codigo) throws Exception {
        return NFNotaSituacaoOperacionalSimplesNacional.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaSituacaoOperacionalSimplesNacional situacaoOperacional) throws Exception {
        return situacaoOperacional.getCodigo();
    }
}
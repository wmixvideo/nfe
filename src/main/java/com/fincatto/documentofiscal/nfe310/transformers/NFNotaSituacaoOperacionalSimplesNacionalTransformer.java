package com.fincatto.documentofiscal.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaSituacaoOperacionalSimplesNacional;

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
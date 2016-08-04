package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFFinalidade;
import org.simpleframework.xml.transform.Transform;

class NFFinalidadeTransformer implements Transform<NFFinalidade> {

    @Override
    public NFFinalidade read(final String codigo) throws Exception {
        return NFFinalidade.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFFinalidade tipo) throws Exception {
        return tipo.getCodigo();
    }
}
package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.nota.NFIndicadorPresencaComprador;
import org.simpleframework.xml.transform.Transform;

public class NFIndicadorPresencaCompradorTransformer implements Transform<NFIndicadorPresencaComprador> {

    @Override
    public NFIndicadorPresencaComprador read(final String codigo) throws Exception {
        return NFIndicadorPresencaComprador.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFIndicadorPresencaComprador indicadorPresencaComprador) throws Exception {
        return indicadorPresencaComprador.getCodigo();
    }
}
package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFIndicadorPresencaComprador;
import org.simpleframework.xml.transform.Transform;

public class NFIndicadorPresencaCompradorTransformer implements Transform<NFIndicadorPresencaComprador> {

    @Override
    public NFIndicadorPresencaComprador read(final String codigo) {
        return NFIndicadorPresencaComprador.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFIndicadorPresencaComprador indicadorPresencaComprador) {
        return indicadorPresencaComprador.getCodigo();
    }
}
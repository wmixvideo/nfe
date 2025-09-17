package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoAgropecuarioTipoGuia;
import org.simpleframework.xml.transform.Transform;

public class NFNotaInfoAgropecuarioTipoGuiaTransformer implements Transform<NFNotaInfoAgropecuarioTipoGuia> {

    @Override
    public NFNotaInfoAgropecuarioTipoGuia read(final String codigo) {
        return NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoAgropecuarioTipoGuia tipoGuia) {
        return tipoGuia.getCodigo();
    }
}
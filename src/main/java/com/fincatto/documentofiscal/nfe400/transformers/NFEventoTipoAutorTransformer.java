package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import org.simpleframework.xml.transform.Transform;

public class NFEventoTipoAutorTransformer implements Transform<NFEventoTipoAutor> {

    @Override
    public NFEventoTipoAutor read(final String codigo) {
        return NFEventoTipoAutor.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFEventoTipoAutor autor) {
        return autor.getCodigo();
    }

}

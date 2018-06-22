package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFTipo;
import org.simpleframework.xml.transform.Transform;

public class NFTipoTransformer implements Transform<NFTipo> {

    @Override
    public NFTipo read(final String codigo) {
        return NFTipo.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFTipo tipo) {
        return tipo.getCodigo();
    }
}
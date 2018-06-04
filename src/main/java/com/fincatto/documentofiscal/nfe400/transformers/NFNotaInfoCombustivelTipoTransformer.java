package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoCombustivelTipo;
import org.simpleframework.xml.transform.Transform;

public class NFNotaInfoCombustivelTipoTransformer implements Transform<NFNotaInfoCombustivelTipo> {

    @Override
    public NFNotaInfoCombustivelTipo read(final String codigoCombustivelTipo) {
        return NFNotaInfoCombustivelTipo.valueOfCodigo(codigoCombustivelTipo);
    }

    @Override
    public String write(final NFNotaInfoCombustivelTipo combustivelTipo) {
        return combustivelTipo.getCodigo();
    }
}
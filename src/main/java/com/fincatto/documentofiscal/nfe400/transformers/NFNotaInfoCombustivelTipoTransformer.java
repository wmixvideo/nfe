package com.fincatto.documentofiscal.nfe400.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoCombustivelTipo;

public class NFNotaInfoCombustivelTipoTransformer implements Transform<NFNotaInfoCombustivelTipo> {

    @Override
    public NFNotaInfoCombustivelTipo read(final String codigoCombustivelTipo) throws Exception {
        return NFNotaInfoCombustivelTipo.valueOfCodigo(codigoCombustivelTipo);
    }

    @Override
    public String write(final NFNotaInfoCombustivelTipo combustivelTipo) throws Exception {
        return combustivelTipo.getCodigo();
    }
}
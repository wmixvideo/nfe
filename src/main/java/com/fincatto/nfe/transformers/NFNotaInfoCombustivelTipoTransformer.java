package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.nota.NFNotaInfoCombustivelTipo;

public class NFNotaInfoCombustivelTipoTransformer implements Transform<NFNotaInfoCombustivelTipo> {

    @Override
    public NFNotaInfoCombustivelTipo read(final String codigoCombustivelTipo) throws Exception {
        return null;
    }

    @Override
    public String write(final NFNotaInfoCombustivelTipo combustivelTipo) throws Exception {
        return combustivelTipo.getCodigo();
    }
}
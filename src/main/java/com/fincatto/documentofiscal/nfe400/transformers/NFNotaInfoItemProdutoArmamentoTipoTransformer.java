package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemProdutoArmamentoTipo;
import org.simpleframework.xml.transform.Transform;

public class NFNotaInfoItemProdutoArmamentoTipoTransformer implements Transform<NFNotaInfoItemProdutoArmamentoTipo> {

    @Override
    public NFNotaInfoItemProdutoArmamentoTipo read(final String codigo) {
        return NFNotaInfoItemProdutoArmamentoTipo.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoItemProdutoArmamentoTipo tipo) {
        return tipo.getCodigo();
    }
}
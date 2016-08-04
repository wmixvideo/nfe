package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFNotaInfoItemProdutoArmamentoTipo;
import org.simpleframework.xml.transform.Transform;

class NFNotaInfoItemProdutoArmamentoTipoTransformer implements Transform<NFNotaInfoItemProdutoArmamentoTipo> {

    @Override
    public NFNotaInfoItemProdutoArmamentoTipo read(final String codigo) throws Exception {
        return NFNotaInfoItemProdutoArmamentoTipo.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoItemProdutoArmamentoTipo tipo) throws Exception {
        return tipo.getCodigo();
    }
}
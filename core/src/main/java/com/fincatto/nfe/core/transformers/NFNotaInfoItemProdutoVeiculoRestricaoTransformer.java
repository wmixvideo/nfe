package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFNotaInfoItemProdutoVeiculoRestricao;
import org.simpleframework.xml.transform.Transform;

class NFNotaInfoItemProdutoVeiculoRestricaoTransformer implements Transform<NFNotaInfoItemProdutoVeiculoRestricao> {

    @Override
    public NFNotaInfoItemProdutoVeiculoRestricao read(final String codigo) throws Exception {
        return NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoItemProdutoVeiculoRestricao tipo) throws Exception {
        return tipo.getCodigo();
    }
}
package com.fincatto.documentofiscal.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemProdutoVeiculoRestricao;

public class NFNotaInfoItemProdutoVeiculoRestricaoTransformer implements Transform<NFNotaInfoItemProdutoVeiculoRestricao> {

    @Override
    public NFNotaInfoItemProdutoVeiculoRestricao read(final String codigo) throws Exception {
        return NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoItemProdutoVeiculoRestricao tipo) throws Exception {
        return tipo.getCodigo();
    }
}
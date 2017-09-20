package com.fincatto.documentofiscal.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemProdutoVeiculoTipoOperacao;

public class NFNotaInfoItemProdutoVeiculoTipoOperacaoTransformer implements Transform<NFNotaInfoItemProdutoVeiculoTipoOperacao> {

    @Override
    public NFNotaInfoItemProdutoVeiculoTipoOperacao read(final String codigo) throws Exception {
        return NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoItemProdutoVeiculoTipoOperacao tipo) throws Exception {
        return tipo.getCodigo();
    }
}
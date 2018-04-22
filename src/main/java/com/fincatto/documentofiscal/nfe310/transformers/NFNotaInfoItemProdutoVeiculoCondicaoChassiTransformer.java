package com.fincatto.documentofiscal.nfe310.transformers;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoItemProdutoVeiculoCondicaoChassi;
import org.simpleframework.xml.transform.Transform;

public class NFNotaInfoItemProdutoVeiculoCondicaoChassiTransformer implements Transform<NFNotaInfoItemProdutoVeiculoCondicaoChassi> {

    @Override
    public NFNotaInfoItemProdutoVeiculoCondicaoChassi read(final String codigo) throws Exception {
        return NFNotaInfoItemProdutoVeiculoCondicaoChassi.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoItemProdutoVeiculoCondicaoChassi tipo) throws Exception {
        return tipo.getCodigo();
    }
}
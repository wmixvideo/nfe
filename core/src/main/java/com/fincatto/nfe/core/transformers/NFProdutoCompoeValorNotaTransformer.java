package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFProdutoCompoeValorNota;
import org.simpleframework.xml.transform.Transform;

class NFProdutoCompoeValorNotaTransformer implements Transform<NFProdutoCompoeValorNota> {

    @Override
    public NFProdutoCompoeValorNota read(final String codigo) throws Exception {
        return NFProdutoCompoeValorNota.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFProdutoCompoeValorNota tipo) throws Exception {
        return tipo.getCodigo();
    }
}
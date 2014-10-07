package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.nota.NFIdentificadorLocalDestinoOperacao;

public class NFIdentificadorLocalDestinoOperacaoTransformer implements Transform<NFIdentificadorLocalDestinoOperacao> {

    @Override
    public NFIdentificadorLocalDestinoOperacao read(final String codigoOperacao) throws Exception {
        return NFIdentificadorLocalDestinoOperacao.valueOfCodigo(codigoOperacao);
    }

    @Override
    public String write(final NFIdentificadorLocalDestinoOperacao operacao) throws Exception {
        return operacao.getCodigo();
    }
}
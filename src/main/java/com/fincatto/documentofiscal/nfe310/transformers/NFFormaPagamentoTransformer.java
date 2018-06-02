package com.fincatto.documentofiscal.nfe310.transformers;

import com.fincatto.documentofiscal.nfe310.classes.NFFormaPagamentoPrazo;
import org.simpleframework.xml.transform.Transform;

public class NFFormaPagamentoTransformer implements Transform<NFFormaPagamentoPrazo> {

    @Override
    public NFFormaPagamentoPrazo read(final String codigo) {
        return NFFormaPagamentoPrazo.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFFormaPagamentoPrazo formaPagamento) {
        return formaPagamento.getCodigo();
    }
}

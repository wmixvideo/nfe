package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFMeioPagamento;
import org.simpleframework.xml.transform.Transform;

public class NFMeioPagamentoTransformer implements Transform<NFMeioPagamento> {

    @Override
    public NFMeioPagamento read(final String codigo) {
        return NFMeioPagamento.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFMeioPagamento meioPagamento) {
        return meioPagamento.getCodigo();
    }
}
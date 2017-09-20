package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTFormaPagamento;

public class CTFormaPagamentoTransformer implements Transform<CTFormaPagamento> {

    @Override
    public CTFormaPagamento read(final String codigo) throws Exception {
        return CTFormaPagamento.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTFormaPagamento tipo) throws Exception {
        return tipo.getCodigo();
    }
}
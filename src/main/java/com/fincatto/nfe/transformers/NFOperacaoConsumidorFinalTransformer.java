package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.nota.NFOperacaoConsumidorFinal;

public class NFOperacaoConsumidorFinalTransformer implements Transform<NFOperacaoConsumidorFinal> {

    @Override
    public NFOperacaoConsumidorFinal read(final String codigo) throws Exception {
        return NFOperacaoConsumidorFinal.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFOperacaoConsumidorFinal operacao) throws Exception {
        return operacao.getCodigo();
    }
}
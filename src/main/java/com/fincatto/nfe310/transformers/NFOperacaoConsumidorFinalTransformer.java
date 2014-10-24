package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.nota.NFOperacaoConsumidorFinal;

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
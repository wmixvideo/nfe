package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFOperacaoConsumidorFinal;
import org.simpleframework.xml.transform.Transform;

public class NFOperacaoConsumidorFinalTransformer implements Transform<NFOperacaoConsumidorFinal> {

    @Override
    public NFOperacaoConsumidorFinal read(final String codigo) {
        return NFOperacaoConsumidorFinal.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFOperacaoConsumidorFinal operacao) {
        return operacao.getCodigo();
    }
}
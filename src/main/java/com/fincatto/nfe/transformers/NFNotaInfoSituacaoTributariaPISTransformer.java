package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.nota.NFNotaInfoSituacaoTributariaPIS;

public class NFNotaInfoSituacaoTributariaPISTransformer implements Transform<NFNotaInfoSituacaoTributariaPIS> {

    @Override
    public NFNotaInfoSituacaoTributariaPIS read(final String codigo) throws Exception {
        return NFNotaInfoSituacaoTributariaPIS.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoSituacaoTributariaPIS situacaotributariaPIS) throws Exception {
        return situacaotributariaPIS.getCodigo();
    }
}
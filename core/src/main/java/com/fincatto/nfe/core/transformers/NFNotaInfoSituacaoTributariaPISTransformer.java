package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFNotaInfoSituacaoTributariaPIS;
import org.simpleframework.xml.transform.Transform;

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
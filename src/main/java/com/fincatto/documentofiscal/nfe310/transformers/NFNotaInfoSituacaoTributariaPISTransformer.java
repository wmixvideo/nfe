package com.fincatto.documentofiscal.nfe310.transformers;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaPIS;
import org.simpleframework.xml.transform.Transform;

public class NFNotaInfoSituacaoTributariaPISTransformer implements Transform<NFNotaInfoSituacaoTributariaPIS> {

    @Override
    public NFNotaInfoSituacaoTributariaPIS read(final String codigo) {
        return NFNotaInfoSituacaoTributariaPIS.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoSituacaoTributariaPIS situacaotributariaPIS) {
        return situacaotributariaPIS.getCodigo();
    }
}
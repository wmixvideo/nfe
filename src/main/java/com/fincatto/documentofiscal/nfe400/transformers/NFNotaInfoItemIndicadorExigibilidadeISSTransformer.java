package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemIndicadorExigibilidadeISS;
import org.simpleframework.xml.transform.Transform;

public class NFNotaInfoItemIndicadorExigibilidadeISSTransformer implements Transform<NFNotaInfoItemIndicadorExigibilidadeISS> {

    @Override
    public NFNotaInfoItemIndicadorExigibilidadeISS read(final String codigo) {
        return NFNotaInfoItemIndicadorExigibilidadeISS.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoItemIndicadorExigibilidadeISS exigibilidadeISS) {
        return exigibilidadeISS.getCodigo();
    }
}
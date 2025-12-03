package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFCredito;
import org.simpleframework.xml.transform.Transform;

public class NFCreditoTransformer implements Transform<NFCredito> {
    @Override
    public NFCredito read(final String codigo) {
        return NFCredito.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFCredito tipo) {
        return tipo.getCodigo();
    }
}

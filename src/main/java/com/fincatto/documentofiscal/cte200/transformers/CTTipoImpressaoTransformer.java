package com.fincatto.documentofiscal.cte200.transformers;

import com.fincatto.documentofiscal.cte200.classes.CTTipoImpressao;
import org.simpleframework.xml.transform.Transform;

public class CTTipoImpressaoTransformer implements Transform<CTTipoImpressao> {

    @Override
    public CTTipoImpressao read(final String codigo) {
        return CTTipoImpressao.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoImpressao tipo) {
        return tipo.getCodigo();
    }
}
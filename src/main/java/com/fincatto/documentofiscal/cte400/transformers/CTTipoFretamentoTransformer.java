package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTipoFretamento;
import org.simpleframework.xml.transform.Transform;

public class CTTipoFretamentoTransformer implements Transform<CTTipoFretamento> {

    @Override
    public CTTipoFretamento read(final String codigo) {
        return CTTipoFretamento.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoFretamento tipo) {
        return tipo.getCodigo();
    }

}

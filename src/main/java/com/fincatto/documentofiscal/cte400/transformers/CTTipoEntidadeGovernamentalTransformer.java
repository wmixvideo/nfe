package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTipoEntidadeGovernamental;
import com.fincatto.documentofiscal.cte400.classes.CTTipoOperacaoGovernamental;
import org.simpleframework.xml.transform.Transform;

public class CTTipoEntidadeGovernamentalTransformer implements Transform<CTTipoEntidadeGovernamental> {

    @Override
    public CTTipoEntidadeGovernamental read(final String codigo) {
        return CTTipoEntidadeGovernamental.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoEntidadeGovernamental tipo) {
        return tipo.getCodigo();
    }

}

package com.fincatto.documentofiscal.cte400.transformers;

import com.fincatto.documentofiscal.cte400.classes.CTTipoOperacaoGovernamental;
import com.fincatto.documentofiscal.cte400.classes.CTTipoProprietario;
import org.simpleframework.xml.transform.Transform;

public class CTTipoOperacaoGovernamentalTransformer implements Transform<CTTipoOperacaoGovernamental> {

    @Override
    public CTTipoOperacaoGovernamental read(final String codigo) {
        return CTTipoOperacaoGovernamental.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoOperacaoGovernamental tipo) {
        return tipo.getCodigo();
    }

}

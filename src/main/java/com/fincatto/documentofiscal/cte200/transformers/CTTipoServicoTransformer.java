package com.fincatto.documentofiscal.cte200.transformers;

import com.fincatto.documentofiscal.cte200.classes.CTTipoServico;
import org.simpleframework.xml.transform.Transform;

public class CTTipoServicoTransformer implements Transform<CTTipoServico> {

    @Override
    public CTTipoServico read(final String codigo) {
        return CTTipoServico.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoServico tipo) {
        return tipo.getCodigo();
    }
}
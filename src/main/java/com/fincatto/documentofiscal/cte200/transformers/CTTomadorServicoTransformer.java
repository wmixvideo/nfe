package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTTomadorServico;

public class CTTomadorServicoTransformer implements Transform<CTTomadorServico> {

    @Override
    public CTTomadorServico read(final String codigo) throws Exception {
        return CTTomadorServico.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTomadorServico tipo) throws Exception {
        return tipo.getCodigo();
    }
}
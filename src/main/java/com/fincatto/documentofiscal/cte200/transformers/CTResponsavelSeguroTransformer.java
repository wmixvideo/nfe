package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTResponsavelSeguro;

public class CTResponsavelSeguroTransformer implements Transform<CTResponsavelSeguro> {

    @Override
    public CTResponsavelSeguro read(final String codigo) throws Exception {
        return CTResponsavelSeguro.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTResponsavelSeguro tipo) throws Exception {
        return tipo.getCodigo();
    }
}
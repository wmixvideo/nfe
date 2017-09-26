package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTTipoEntregaHorario;

public class CTTipoEntregaHorarioTransformer implements Transform<CTTipoEntregaHorario> {

    @Override
    public CTTipoEntregaHorario read(final String codigo) throws Exception {
        return CTTipoEntregaHorario.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoEntregaHorario tipo) throws Exception {
        return tipo.getCodigo();
    }
}
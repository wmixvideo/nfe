package com.fincatto.documentofiscal.cte200.transformers;

import com.fincatto.documentofiscal.cte200.classes.CTTipoEntregaHorario;
import org.simpleframework.xml.transform.Transform;

public class CTTipoEntregaHorarioTransformer implements Transform<CTTipoEntregaHorario> {

    @Override
    public CTTipoEntregaHorario read(final String codigo) {
        return CTTipoEntregaHorario.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoEntregaHorario tipo) {
        return tipo.getCodigo();
    }
}
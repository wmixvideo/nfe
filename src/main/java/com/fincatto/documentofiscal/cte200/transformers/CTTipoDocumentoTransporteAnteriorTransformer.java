package com.fincatto.documentofiscal.cte200.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.cte200.classes.CTTipoDocumentoTransporteAnterior;

public class CTTipoDocumentoTransporteAnteriorTransformer implements Transform<CTTipoDocumentoTransporteAnterior> {

    @Override
    public CTTipoDocumentoTransporteAnterior read(final String codigo) throws Exception {
        return CTTipoDocumentoTransporteAnterior.valueOfCodigo(codigo);
    }

    @Override
    public String write(final CTTipoDocumentoTransporteAnterior tipo) throws Exception {
        return tipo.getCodigo();
    }
}
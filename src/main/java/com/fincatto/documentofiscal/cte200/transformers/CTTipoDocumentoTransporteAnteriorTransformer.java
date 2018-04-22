package com.fincatto.documentofiscal.cte200.transformers;

import com.fincatto.documentofiscal.cte200.classes.CTTipoDocumentoTransporteAnterior;
import org.simpleframework.xml.transform.Transform;

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
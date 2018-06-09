package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFModalidadeTransporte;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 */
public class MDFModalidadeTransporteTransformer implements Transform<MDFModalidadeTransporte> {

    @Override
    public MDFModalidadeTransporte read(String value) {
        return MDFModalidadeTransporte.valueOfCodigo(value);
    }

    @Override
    public String write(MDFModalidadeTransporte value) {
        return value.getCodigo();
    }
}

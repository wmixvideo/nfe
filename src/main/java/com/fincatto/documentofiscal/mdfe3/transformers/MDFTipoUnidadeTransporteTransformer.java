package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoUnidadeTransporte;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 */
public class MDFTipoUnidadeTransporteTransformer implements Transform<MDFTipoUnidadeTransporte> {

    @Override
    public MDFTipoUnidadeTransporte read(String value) throws Exception {
        return MDFTipoUnidadeTransporte.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoUnidadeTransporte value) throws Exception {
        return value.getCodigo();
    }
}

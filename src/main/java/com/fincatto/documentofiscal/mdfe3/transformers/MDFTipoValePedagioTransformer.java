package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoValePedagio;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Fagner Roger on 08/10/25.
 */
public class MDFTipoValePedagioTransformer implements Transform<MDFTipoValePedagio> {

    @Override
    public MDFTipoValePedagio read(String value) {
        return MDFTipoValePedagio.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoValePedagio value) {
        return value.getCodigo();
    }
}

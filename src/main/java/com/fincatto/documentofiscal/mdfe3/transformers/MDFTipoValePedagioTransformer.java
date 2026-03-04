package com.fincatto.documentofiscal.mdfe3.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoValePedagio;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
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

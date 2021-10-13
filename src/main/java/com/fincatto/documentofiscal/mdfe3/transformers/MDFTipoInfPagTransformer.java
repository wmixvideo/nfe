package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoInfPag;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Edivaldo Merlo Stens on 30/06/20.
 */
public class MDFTipoInfPagTransformer implements Transform<MDFTipoInfPag> {

    @Override
    public MDFTipoInfPag read(String value) {
        return MDFTipoInfPag.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoInfPag value) {
        return value.getCodigo();
    }
}

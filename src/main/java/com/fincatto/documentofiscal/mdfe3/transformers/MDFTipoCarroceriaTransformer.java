package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoCarroceria;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 */
public class MDFTipoCarroceriaTransformer implements Transform<MDFTipoCarroceria> {

    @Override
    public MDFTipoCarroceria read(String value) {
        return MDFTipoCarroceria.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoCarroceria value) {
        return value.getCodigo();
    }
}

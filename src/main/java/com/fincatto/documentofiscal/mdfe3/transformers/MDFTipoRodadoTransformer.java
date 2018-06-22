package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoRodado;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 */
public class MDFTipoRodadoTransformer implements Transform<MDFTipoRodado> {

    @Override
    public MDFTipoRodado read(String value) {
        return MDFTipoRodado.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoRodado value) {
        return value.getCodigo();
    }
}

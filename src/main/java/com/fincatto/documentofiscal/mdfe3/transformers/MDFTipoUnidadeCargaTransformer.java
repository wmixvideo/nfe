package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoUnidadeCarga;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 */
public class MDFTipoUnidadeCargaTransformer implements Transform<MDFTipoUnidadeCarga> {

    @Override
    public MDFTipoUnidadeCarga read(String value) {
        return MDFTipoUnidadeCarga.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoUnidadeCarga value) {
        return value.getCodigo();
    }
}

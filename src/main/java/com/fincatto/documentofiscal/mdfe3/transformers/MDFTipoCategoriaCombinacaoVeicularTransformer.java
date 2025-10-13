package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoCategoriaCombinacaoVeicular;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Fagner Roger on 08/10/25.
 */
public class MDFTipoCategoriaCombinacaoVeicularTransformer implements Transform<MDFTipoCategoriaCombinacaoVeicular> {

    @Override
    public MDFTipoCategoriaCombinacaoVeicular read(String value) {
        return MDFTipoCategoriaCombinacaoVeicular.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoCategoriaCombinacaoVeicular value) {
        return value.getCodigo();
    }
}

package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 */
public class MDFTipoEmissaoTransformer implements Transform<MDFTipoEmissao> {

    @Override
    public MDFTipoEmissao read(String value) {
        return MDFTipoEmissao.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoEmissao value) {
        return value.getCodigo();
    }
}

package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFProcessoEmissao;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
 */
public class MDFProcessoEmissaoTransformer implements Transform<MDFProcessoEmissao> {

    @Override
    public MDFProcessoEmissao read(String value) {
        return MDFProcessoEmissao.valueOfCodigo(value);
    }

    @Override
    public String write(MDFProcessoEmissao value) {
        return value.getCodigo();
    }
}

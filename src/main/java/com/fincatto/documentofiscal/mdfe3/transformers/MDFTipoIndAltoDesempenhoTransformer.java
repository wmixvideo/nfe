package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoIndAltoDesempenho;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Edivaldo Ramos on 07/10/25.
 */
public class MDFTipoIndAltoDesempenhoTransformer implements Transform<MDFTipoIndAltoDesempenho> {

    @Override
    public MDFTipoIndAltoDesempenho read(String value) {
        return MDFTipoIndAltoDesempenho.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoIndAltoDesempenho value) {
        return value.getCodigo();
    }
}

package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoPermissaoAntecipacao;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Fagner Roger on 08/10/25.
 */
public class MDFTipoPermissaoAntecipacaoTransformer implements Transform<MDFTipoPermissaoAntecipacao> {

    @Override
    public MDFTipoPermissaoAntecipacao read(String value) {
        return MDFTipoPermissaoAntecipacao.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoPermissaoAntecipacao value) {
        return value.getCodigo();
    }
}

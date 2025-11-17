package com.fincatto.documentofiscal.mdfe3.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoPermissaoAntecipacao;

/**
 * Created by Eldevan Nery Junior on 06/11/17.
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

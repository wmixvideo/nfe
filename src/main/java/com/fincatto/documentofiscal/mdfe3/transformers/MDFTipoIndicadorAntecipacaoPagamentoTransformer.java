package com.fincatto.documentofiscal.mdfe3.transformers;

import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoIndicadorAntecipacaoPagamento;
import org.simpleframework.xml.transform.Transform;

/**
 * Created by Fagner Roger on 08/10/25.
 */
public class MDFTipoIndicadorAntecipacaoPagamentoTransformer implements Transform<MDFTipoIndicadorAntecipacaoPagamento> {

    @Override
    public MDFTipoIndicadorAntecipacaoPagamento read(String value) {
        return MDFTipoIndicadorAntecipacaoPagamento.valueOfCodigo(value);
    }

    @Override
    public String write(MDFTipoIndicadorAntecipacaoPagamento value) {
        return value.getCodigo();
    }
}

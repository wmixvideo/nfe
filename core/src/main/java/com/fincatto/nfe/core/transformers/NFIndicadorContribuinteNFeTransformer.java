package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.cadastro.NFIndicadorContribuinteNFe;
import org.simpleframework.xml.transform.Transform;

public class NFIndicadorContribuinteNFeTransformer implements Transform<NFIndicadorContribuinteNFe> {

    @Override
    public NFIndicadorContribuinteNFe read(final String codigoIndicador) throws Exception {
        return NFIndicadorContribuinteNFe.valueOfCodigo(Integer.parseInt(codigoIndicador));
    }

    @Override
    public String write(final NFIndicadorContribuinteNFe indicador) throws Exception {
        return String.valueOf(indicador.getCodigo());
    }
}

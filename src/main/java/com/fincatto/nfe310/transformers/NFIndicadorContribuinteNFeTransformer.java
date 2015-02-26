package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.cadastro.NFIndicadorContribuinteNFe;

public class NFIndicadorContribuinteNFeTransformer implements Transform<NFIndicadorContribuinteNFe> {

    @Override
    public NFIndicadorContribuinteNFe read(final String codigoIndicador) throws Exception {
        return NFIndicadorContribuinteNFe.valueOfCodigo(Integer.valueOf(codigoIndicador));
    }

    @Override
    public String write(final NFIndicadorContribuinteNFe indicador) throws Exception {
        return String.valueOf(indicador.getCodigo());
    }
}

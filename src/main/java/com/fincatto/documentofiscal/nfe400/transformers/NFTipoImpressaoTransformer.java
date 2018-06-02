package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFTipoImpressao;
import org.simpleframework.xml.transform.Transform;

public class NFTipoImpressaoTransformer implements Transform<NFTipoImpressao> {

    @Override
    public NFTipoImpressao read(final String codigo) {
        return NFTipoImpressao.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFTipoImpressao tipo) {
        return tipo.getCodigo();
    }
}
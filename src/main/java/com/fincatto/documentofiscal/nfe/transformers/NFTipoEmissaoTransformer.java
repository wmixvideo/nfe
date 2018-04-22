package com.fincatto.documentofiscal.nfe.transformers;

import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import org.simpleframework.xml.transform.Transform;

public class NFTipoEmissaoTransformer implements Transform<NFTipoEmissao> {

    @Override
    public NFTipoEmissao read(final String codigo) throws Exception {
        return NFTipoEmissao.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFTipoEmissao tipo) throws Exception {
        return tipo.getCodigo();
    }
}
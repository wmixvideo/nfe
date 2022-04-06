package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.cadastro.NFSituacaoContribuinte;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFTipoAtoConcessorio;
import org.simpleframework.xml.transform.Transform;

public class NFTipoAtoConcessorioTransformer implements Transform<NFTipoAtoConcessorio> {


    @Override
    public NFTipoAtoConcessorio read(String value) throws Exception {
        return NFTipoAtoConcessorio.valueOfCodigo(value);
    }

    @Override
    public String write(NFTipoAtoConcessorio value) throws Exception {
        return value.getCodigo();
    }
}

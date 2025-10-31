package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTribOutrosPisCofinsTipoRetencaoTransformer implements Transform<NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao>{
    @Override
    public NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao read(String value) {
        return NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao value) {
        return value.getCodigo();
    }
}
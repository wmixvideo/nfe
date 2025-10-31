package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributariaTransformer implements Transform<NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria>{
    @Override
    public NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria read(String value) {
        return NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria value) {
        return value.getCodigo();
    }
}
package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacionalTransformer implements Transform<NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional>{
    @Override
    public NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional read(String value) {
        return NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional value) {
        return value.getCodigo();
    }
}


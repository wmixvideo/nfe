package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimplesTransformer implements Transform<NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples>{
    @Override
    public NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples read(String value) {
        return NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples value) {
        return value.getCodigo();
    }
}


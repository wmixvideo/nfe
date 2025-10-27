package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional;
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


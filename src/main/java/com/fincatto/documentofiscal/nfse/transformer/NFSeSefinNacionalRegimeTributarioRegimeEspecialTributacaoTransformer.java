package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacaoTransformer implements Transform<NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao>{
    @Override
    public NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao read(String value) {
        return NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao value) {
        return value.getCodigo();
    }
}


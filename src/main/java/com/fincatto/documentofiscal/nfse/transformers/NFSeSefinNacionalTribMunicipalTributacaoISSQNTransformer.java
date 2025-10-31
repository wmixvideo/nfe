package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalTribMunicipalTributacaoISSQN;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTribMunicipalTributacaoISSQNTransformer implements Transform<NFSeSefinNacionalTribMunicipalTributacaoISSQN>{
    @Override
    public NFSeSefinNacionalTribMunicipalTributacaoISSQN read(String value) {
        return NFSeSefinNacionalTribMunicipalTributacaoISSQN.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTribMunicipalTributacaoISSQN value) {
        return value.getCodigo();
    }
}
package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTribMunicipalTipoRetencaoISSQNTransformer implements Transform<NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN>{
    @Override
    public NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN read(String value) {
        return NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN value) {
        return value.getCodigo();
    }
}
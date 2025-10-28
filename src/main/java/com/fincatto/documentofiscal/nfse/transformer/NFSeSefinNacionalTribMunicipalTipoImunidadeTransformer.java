package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalTribMunicipalTipoImunidade;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTribMunicipalTipoImunidadeTransformer implements Transform<NFSeSefinNacionalTribMunicipalTipoImunidade>{
    @Override
    public NFSeSefinNacionalTribMunicipalTipoImunidade read(String value) {
        return NFSeSefinNacionalTribMunicipalTipoImunidade.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTribMunicipalTipoImunidade value) {
        return value.getCodigo();
    }
}
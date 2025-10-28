package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalBeneficioMunicipalTipoBeneficio;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalBeneficioMunicipalTipoBeneficioTransformer implements Transform<NFSeSefinNacionalBeneficioMunicipalTipoBeneficio>{
    @Override
    public NFSeSefinNacionalBeneficioMunicipalTipoBeneficio read(String value) {
        return NFSeSefinNacionalBeneficioMunicipalTipoBeneficio.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalBeneficioMunicipalTipoBeneficio value) {
        return value.getCodigo();
    }
}
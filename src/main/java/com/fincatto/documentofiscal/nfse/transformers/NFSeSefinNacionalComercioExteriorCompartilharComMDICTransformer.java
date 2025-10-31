package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalComercioExteriorCompartilharComMDIC;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalComercioExteriorCompartilharComMDICTransformer implements Transform<NFSeSefinNacionalComercioExteriorCompartilharComMDIC>{
    @Override
    public NFSeSefinNacionalComercioExteriorCompartilharComMDIC read(String value) {
        return NFSeSefinNacionalComercioExteriorCompartilharComMDIC.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalComercioExteriorCompartilharComMDIC value) {
        return value.getCodigo();
    }
}


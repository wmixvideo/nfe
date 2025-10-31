package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalComercioExteriorVinculoEntrePartes;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalComercioExteriorVinculoEntrePartesTransformer implements Transform<NFSeSefinNacionalComercioExteriorVinculoEntrePartes>{
    @Override
    public NFSeSefinNacionalComercioExteriorVinculoEntrePartes read(String value) {
        return NFSeSefinNacionalComercioExteriorVinculoEntrePartes.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalComercioExteriorVinculoEntrePartes value) {
        return value.getCodigo();
    }
}


package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalComercioExteriorMecanismoApoioTomador;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalComercioExteriorMecanismoApoioTomadorTransformer implements Transform<NFSeSefinNacionalComercioExteriorMecanismoApoioTomador>{
    @Override
    public NFSeSefinNacionalComercioExteriorMecanismoApoioTomador read(String value) {
        return NFSeSefinNacionalComercioExteriorMecanismoApoioTomador.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalComercioExteriorMecanismoApoioTomador value) {
        return value.getCodigo();
    }
}


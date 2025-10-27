package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalComercioExteriorMecanismoApoioPrestadorTransformer implements Transform<NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador>{
    @Override
    public NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador read(String value) {
        return NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador value) {
        return value.getCodigo();
    }
}


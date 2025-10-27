package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalComercioExteriorModoPrestacao;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalComercioExteriorModoPrestacaoTransformer implements Transform<NFSeSefinNacionalComercioExteriorModoPrestacao>{
    @Override
    public NFSeSefinNacionalComercioExteriorModoPrestacao read(String value) {
        return NFSeSefinNacionalComercioExteriorModoPrestacao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalComercioExteriorModoPrestacao value) {
        return value.getCodigo();
    }
}


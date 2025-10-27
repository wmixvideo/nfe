package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBensTransformer implements Transform<NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens>{
    @Override
    public NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens read(String value) {
        return NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens value) {
        return value.getCodigo();
    }
}


package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalTipoAmbiente;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTipoAmbienteTransformer implements Transform<NFSeSefinNacionalTipoAmbiente>{
    @Override
    public NFSeSefinNacionalTipoAmbiente read(String value) {
        return NFSeSefinNacionalTipoAmbiente.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTipoAmbiente value) {
        return value.getCodigo();
    }
}


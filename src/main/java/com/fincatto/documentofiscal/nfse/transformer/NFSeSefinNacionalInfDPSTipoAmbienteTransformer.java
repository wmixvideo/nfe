package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfDPSTipoAmbiente;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalInfDPSTipoAmbienteTransformer implements Transform<NFSeSefinNacionalInfDPSTipoAmbiente>{
    @Override
    public NFSeSefinNacionalInfDPSTipoAmbiente read(String value) {
        return NFSeSefinNacionalInfDPSTipoAmbiente.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfDPSTipoAmbiente value) {
        return value.getCodigo();
    }
}


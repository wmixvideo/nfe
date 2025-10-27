package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfDPSTipoEmitente;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalSubstituicaoMotivo;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalSubstituicaoMotivoTransformer implements Transform<NFSeSefinNacionalSubstituicaoMotivo>{
    @Override
    public NFSeSefinNacionalSubstituicaoMotivo read(String value) {
        return NFSeSefinNacionalSubstituicaoMotivo.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalSubstituicaoMotivo value) {
        return value.getCodigo();
    }
}


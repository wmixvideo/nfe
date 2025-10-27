package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfDPSTipoAmbiente;
import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalInfoPrestadorCodigoNaoNIF;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalInfoPrestadorCodigoNaoNIFTransformer implements Transform<NFSeSefinNacionalInfoPrestadorCodigoNaoNIF>{
    @Override
    public NFSeSefinNacionalInfoPrestadorCodigoNaoNIF read(String value) {
        return NFSeSefinNacionalInfoPrestadorCodigoNaoNIF.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfoPrestadorCodigoNaoNIF value) {
        return value.getCodigo();
    }
}


package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalTSCodJustCanc;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTSCodJustCancTransformer implements Transform<NFSeSefinNacionalTSCodJustCanc>{
    @Override
    public NFSeSefinNacionalTSCodJustCanc read(String value) {
        return NFSeSefinNacionalTSCodJustCanc.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTSCodJustCanc value) {
        return value.getCodigo();
    }
}


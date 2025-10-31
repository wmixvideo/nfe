package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalTSCodJustSubst;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTSCodJustSubstTransformer implements Transform<NFSeSefinNacionalTSCodJustSubst>{
    @Override
    public NFSeSefinNacionalTSCodJustSubst read(String value) {
        return NFSeSefinNacionalTSCodJustSubst.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTSCodJustSubst value) {
        return value.getCodigo();
    }
}


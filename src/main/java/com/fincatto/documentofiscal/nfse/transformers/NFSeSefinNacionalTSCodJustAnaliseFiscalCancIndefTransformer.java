package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndefTransformer implements Transform<NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef>{
    @Override
    public NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef read(String value) {
        return NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef value) {
        return value.getCodigo();
    }
}


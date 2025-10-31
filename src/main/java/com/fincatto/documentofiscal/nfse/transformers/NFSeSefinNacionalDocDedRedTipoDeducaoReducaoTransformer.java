package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalDocDedRedTipoDeducaoReducao;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalDocDedRedTipoDeducaoReducaoTransformer implements Transform<NFSeSefinNacionalDocDedRedTipoDeducaoReducao>{
    @Override
    public NFSeSefinNacionalDocDedRedTipoDeducaoReducao read(String value) {
        return NFSeSefinNacionalDocDedRedTipoDeducaoReducao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalDocDedRedTipoDeducaoReducao value) {
        return value.getCodigo();
    }
}
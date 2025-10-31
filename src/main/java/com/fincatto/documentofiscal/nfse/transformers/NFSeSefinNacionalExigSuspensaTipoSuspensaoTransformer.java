package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalExigSuspensaTipoSuspensao;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalExigSuspensaTipoSuspensaoTransformer implements Transform<NFSeSefinNacionalExigSuspensaTipoSuspensao>{
    @Override
    public NFSeSefinNacionalExigSuspensaTipoSuspensao read(String value) {
        return NFSeSefinNacionalExigSuspensaTipoSuspensao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalExigSuspensaTipoSuspensao value) {
        return value.getCodigo();
    }
}
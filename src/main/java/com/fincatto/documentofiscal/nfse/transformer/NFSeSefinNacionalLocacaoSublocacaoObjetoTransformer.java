package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalLocacaoSublocacaoObjeto;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalLocacaoSublocacaoObjetoTransformer implements Transform<NFSeSefinNacionalLocacaoSublocacaoObjeto>{
    @Override
    public NFSeSefinNacionalLocacaoSublocacaoObjeto read(String value) {
        return NFSeSefinNacionalLocacaoSublocacaoObjeto.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalLocacaoSublocacaoObjeto value) {
        return value.getCodigo();
    }
}


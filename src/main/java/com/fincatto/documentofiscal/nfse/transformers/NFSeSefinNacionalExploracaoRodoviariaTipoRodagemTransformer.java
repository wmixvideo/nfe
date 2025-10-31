package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalExploracaoRodoviariaTipoRodagem;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalExploracaoRodoviariaTipoRodagemTransformer implements Transform<NFSeSefinNacionalExploracaoRodoviariaTipoRodagem>{
    @Override
    public NFSeSefinNacionalExploracaoRodoviariaTipoRodagem read(String value) {
        return NFSeSefinNacionalExploracaoRodoviariaTipoRodagem.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalExploracaoRodoviariaTipoRodagem value) {
        return value.getCodigo();
    }
}
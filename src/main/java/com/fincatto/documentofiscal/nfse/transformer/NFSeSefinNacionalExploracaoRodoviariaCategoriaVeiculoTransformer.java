package com.fincatto.documentofiscal.nfse.transformer;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculoTransformer implements Transform<NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo>{
    @Override
    public NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo read(String value) {
        return NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo value) {
        return value.getCodigo();
    }
}
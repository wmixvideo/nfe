package com.fincatto.documentofiscal.nfse.transformers;

import com.fincatto.documentofiscal.nfse.classes.nfsenacional.NFSeSefinNacionalLocPrestOpcaoConsumoServico;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalLocPrestOpcaoConsumoServicoTransformer implements Transform<NFSeSefinNacionalLocPrestOpcaoConsumoServico>{
    @Override
    public NFSeSefinNacionalLocPrestOpcaoConsumoServico read(String value) {
        return NFSeSefinNacionalLocPrestOpcaoConsumoServico.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalLocPrestOpcaoConsumoServico value) {
        return value.getCodigo();
    }
}


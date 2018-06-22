package com.fincatto.documentofiscal.nfe310.transformers;

import com.fincatto.documentofiscal.nfe310.classes.lote.envio.NFLoteIndicadorProcessamento;
import org.simpleframework.xml.transform.Transform;

public class NFLoteIndicadorProcessamentoTransformer implements Transform<NFLoteIndicadorProcessamento> {

    @Override
    public NFLoteIndicadorProcessamento read(final String codigo) {
        return NFLoteIndicadorProcessamento.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFLoteIndicadorProcessamento indicadorProcessamento) {
        return indicadorProcessamento.getCodigo();
    }
}
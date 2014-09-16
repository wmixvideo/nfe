package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.nota.NFNotaInfoMotivoDesoneracaoICMS;

public class NFNotaInfoMotivoDesoneracaoICMSTransformer implements Transform<NFNotaInfoMotivoDesoneracaoICMS> {

    @Override
    public NFNotaInfoMotivoDesoneracaoICMS read(final String codigo) throws Exception {
        return NFNotaInfoMotivoDesoneracaoICMS.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaInfoMotivoDesoneracaoICMS desoneracao) throws Exception {
        return desoneracao.getCodigo();
    }
}
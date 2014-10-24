package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.NFNotaMotivoDesoneracaoICMS;

public class NFNotaMotivoDesoneracaoICMSTransformer implements Transform<NFNotaMotivoDesoneracaoICMS> {

    @Override
    public NFNotaMotivoDesoneracaoICMS read(final String codigo) throws Exception {
        return NFNotaMotivoDesoneracaoICMS.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaMotivoDesoneracaoICMS desoneracaoICMS) throws Exception {
        return desoneracaoICMS.getCodigo();
    }
}
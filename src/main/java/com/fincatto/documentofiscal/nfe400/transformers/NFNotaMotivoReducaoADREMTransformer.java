package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaMotivoReducaoADREM;
import org.simpleframework.xml.transform.Transform;

public class NFNotaMotivoReducaoADREMTransformer implements Transform<NFNotaMotivoReducaoADREM> {

    @Override
    public NFNotaMotivoReducaoADREM read(final String codigo) {
        return NFNotaMotivoReducaoADREM.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFNotaMotivoReducaoADREM motivoReducaoADREM) {
        return motivoReducaoADREM.getCodigo();
    }
}
package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFTipoRegimeIBSCBS;
import org.simpleframework.xml.transform.Transform;

public class NFTipoRegimeIBSCBSTransformer implements Transform<NFTipoRegimeIBSCBS> {

    @Override
    public NFTipoRegimeIBSCBS read(final String codigo) {
        return NFTipoRegimeIBSCBS.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFTipoRegimeIBSCBS valor) {
        return valor.getCodigo();
    }
}

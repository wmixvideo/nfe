package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFTipoDeducaoIcms;
import org.simpleframework.xml.transform.Transform;

public class NFTipoDeducaoIcmsTransformer implements Transform<NFTipoDeducaoIcms>{

    @Override
    public NFTipoDeducaoIcms read(String codigo) throws Exception {
        return NFTipoDeducaoIcms.valueOfCodigo(codigo);
    }

    @Override
    public String write(NFTipoDeducaoIcms tipoDeducao) throws Exception {
        return tipoDeducao.getCodigo();
    }

}

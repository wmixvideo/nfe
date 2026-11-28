package com.fincatto.documentofiscal.nfe400.transformers;

import com.fincatto.documentofiscal.nfe400.classes.NFCodigoAtividadeSimplesNacional;
import org.simpleframework.xml.transform.Transform;

public class NFCodigoAtividadeSimplesNacionalTransformer implements Transform<NFCodigoAtividadeSimplesNacional> {

    @Override
    public NFCodigoAtividadeSimplesNacional read(final String codigo) {
        return NFCodigoAtividadeSimplesNacional.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFCodigoAtividadeSimplesNacional valor) {
        return valor.getCodigo();
    }
}

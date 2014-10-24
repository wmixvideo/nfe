package com.fincatto.nfe310.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe310.classes.nota.NFViaTransporteInternacional;

public class NFViaTransporteInternacionalTransformer implements Transform<NFViaTransporteInternacional> {

    @Override
    public NFViaTransporteInternacional read(final String codigo) throws Exception {
        return NFViaTransporteInternacional.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFViaTransporteInternacional via) throws Exception {
        return via.getCodigo();
    }
}
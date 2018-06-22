package com.fincatto.documentofiscal.transformers;

import com.fincatto.documentofiscal.DFAmbiente;
import org.simpleframework.xml.transform.Transform;

public class DFAmbienteTransformer implements Transform<DFAmbiente> {

    @Override
    public DFAmbiente read(final String codigo) {
        return DFAmbiente.valueOfCodigo(codigo);
    }

    @Override
    public String write(final DFAmbiente ambiente) {
        return ambiente.getCodigo();
    }
}
package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFAmbiente;
import org.simpleframework.xml.transform.Transform;

class NFAmbienteTransformer implements Transform<NFAmbiente> {

    @Override
    public NFAmbiente read(final String codigo) throws Exception {
        return NFAmbiente.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFAmbiente ambiente) throws Exception {
        return ambiente.getCodigo();
    }
}
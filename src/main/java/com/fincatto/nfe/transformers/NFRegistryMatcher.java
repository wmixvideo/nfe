package com.fincatto.nfe.transformers;

import java.util.Date;

import org.simpleframework.xml.transform.RegistryMatcher;

import com.fincatto.nfe.NFAmbiente;
import com.fincatto.nfe.NFUnidadeFederativa;

public class NFRegistryMatcher extends RegistryMatcher {
	
	public NFRegistryMatcher() {
		super.bind(Date.class, new NFDateFormatTransformer());
		super.bind(NFAmbiente.class, new NFAmbienteTransformer());
		super.bind(NFUnidadeFederativa.class, new NFUnidadeFederativaTransformer());
	}
}
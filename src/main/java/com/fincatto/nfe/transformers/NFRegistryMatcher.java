package com.fincatto.nfe.transformers;

import java.util.Date;

import org.simpleframework.xml.transform.RegistryMatcher;

import com.fincatto.nfe.Ambiente;

public class NFRegistryMatcher extends RegistryMatcher {
	
	public NFRegistryMatcher() {
		super.bind(Date.class, new NFDateFormatTransformer());
		super.bind(Ambiente.class, new NFAmbienteTransformer());
	}
}
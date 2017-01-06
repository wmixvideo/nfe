package com.fincatto.nfe310;

import com.fincatto.dfe.DFeConfig;

public interface NFeConfig extends DFeConfig {

	String VERSAO_NFE = "3.10";
	String NFE_NAMESPACE = "http://www.portalfiscal.inf.br/nfe";

	Integer getCodigoSegurancaContribuinteID();

	String getCodigoSegurancaContribuinte();

}
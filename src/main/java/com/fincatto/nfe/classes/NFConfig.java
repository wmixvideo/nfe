package com.fincatto.nfe.classes;

import java.io.File;

public interface NFConfig {
	
	NFAmbiente getAmbiente();
	
	File getCertificado();
	
	File getCadeiaCertificados();
	
	String getSenhaCertificado();
	
}

package com.fincatto.nfe.webservices;

import com.fincatto.nfe.NFConfig;

public abstract class WSNFBase {
	
	private final NFConfig config;
	
	public WSNFBase(final NFConfig config) {
		this.config = config;
		this.iniciarlizarCertificados();
	}
	
	public NFConfig getConfig() {
		return this.config;
	}
	
	private final void iniciarlizarCertificados() {
		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
		System.setProperty("javax.net.ssl.trustStoreType", "JKS");
		System.setProperty("javax.net.ssl.trustStore", this.config.getCadeiaCertificados().getAbsolutePath().replaceFirst("file:", ""));
		System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
		System.setProperty("javax.net.ssl.keyStore", this.config.getCertificado().getAbsolutePath().replaceFirst("file:", ""));
		System.setProperty("javax.net.ssl.keyStorePassword", this.config.getSenhaCertificado());
	}
}

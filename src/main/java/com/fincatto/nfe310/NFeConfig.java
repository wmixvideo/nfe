package com.fincatto.nfe310;

import java.io.IOException;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public interface NFeConfig {

	String VERSAO_NFE = "3.10";
	String NFE_NAMESPACE = "http://www.portalfiscal.inf.br/nfe";

	NFAmbiente getAmbiente();

	byte[] getCertificado() throws IOException;

	byte[] getCadeiaCertificados() throws IOException;

	String getCertificadoSenha();

	String getCadeiaCertificadosSenha();

	NFUnidadeFederativa getCUF();

	NFTipoEmissao getTipoEmissao();

	String getSSLProtocolo();

	Integer getCodigoSegurancaContribuinteID();

	String getCodigoSegurancaContribuinte();
}
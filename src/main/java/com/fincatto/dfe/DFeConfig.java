package com.fincatto.dfe;

import java.io.IOException;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.dfe.classes.DFTipoEmissao;

public interface DFeConfig {

	DFAmbiente getAmbiente();

	byte[] getCertificado() throws IOException;

	byte[] getCadeiaCertificados() throws IOException;

	String getCertificadoSenha();

	String getCadeiaCertificadosSenha();

	DFUnidadeFederativa getCUF();

	DFTipoEmissao getTipoEmissao();

	String getSSLProtocolo();
}
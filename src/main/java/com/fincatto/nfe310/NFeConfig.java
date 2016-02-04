package com.fincatto.nfe310;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFAutorizador31;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

import java.io.File;
import java.io.IOException;

public interface NFeConfig {

    String VERSAO_NFE = "3.10";
    String NFE_NAMESPACE = "http://www.portalfiscal.inf.br/nfe";

    NFAmbiente getAmbiente();

    File getCertificado() throws IOException;

    File getCadeiaCertificados() throws IOException;

    String getCertificadoSenha();

    NFUnidadeFederativa getCUF();

    NFTipoEmissao getTipoEmissao();

	default NFAutorizador31 getAutorizador(){
		return getAutorizador(getCUF());
	}
	
	public NFAutorizador31 getAutorizador(final NFUnidadeFederativa uf);
	
	public NFAutorizador31 getAutorizador(final String chaveAcesso);
}
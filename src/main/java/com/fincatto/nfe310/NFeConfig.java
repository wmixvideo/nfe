package com.fincatto.nfe310;

import com.fincatto.nfe310.classes.NFAmbiente;
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

    /**
     *
     * @return Certificado no modo byte array, caso o usuário o recupere de um banco de dados
	 */
    byte[] getCertificadoByteArray();
}
package com.fincatto.nfe310;

import java.io.File;
import java.io.IOException;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public interface NFeConfig {

    final static String VERSAO_NFE = "3.10";

    final static String NFE_NAMESPACE = "http://www.portalfiscal.inf.br/nfe";

    public NFAmbiente getAmbiente();

    public File getCertificado() throws IOException;

    public File getCadeiaCertificados() throws IOException;

    public String getCertificadoSenha();

    public NFUnidadeFederativa getCUF();

    public NFTipoEmissao getTipoEmissao();
}
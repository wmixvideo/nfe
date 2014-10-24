package com.fincatto.nfe200;

import java.io.File;
import java.io.IOException;

import com.fincatto.nfe200.classes.NFAmbiente;
import com.fincatto.nfe200.classes.NFTipoEmissao;
import com.fincatto.nfe200.classes.NFUnidadeFederativa;

public interface NFEConfig {

    final static String VERSAO_NFE = "2.00";

    final static String NFE_NAMESPACE = "http://www.portalfiscal.inf.br/nfe";

    public NFAmbiente getAmbiente();

    public File getCertificado() throws IOException;

    public File getCadeiaCertificados() throws IOException;

    public String getCertificadoSenha();

    public NFUnidadeFederativa getCUF();

    public NFTipoEmissao getTipoEmissao();
}
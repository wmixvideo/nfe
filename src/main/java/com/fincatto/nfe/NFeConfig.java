package com.fincatto.nfe;

import java.io.File;

import com.fincatto.nfe.classes.NFAmbiente;
import com.fincatto.nfe.classes.NFTipoEmissao;
import com.fincatto.nfe.classes.NFUnidadeFederativa;

public interface NFeConfig {

    final static String VERSAO_NFE = "3.10";

    final static String NFE_NAMESPACE = "http://www.portalfiscal.inf.br/nfe";

    public NFAmbiente getAmbiente();

    public File getCertificado();

    public File getCadeiaCertificados();

    public String getCertificadoSenha();

    public NFUnidadeFederativa getCUF();

    public NFTipoEmissao getTipoEmissao();
}
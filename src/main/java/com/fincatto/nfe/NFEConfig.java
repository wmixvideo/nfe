package com.fincatto.nfe;

import java.io.File;
import java.net.URL;

import com.fincatto.nfe.classes.NFAmbiente;
import com.fincatto.nfe.classes.NFTipoEmissao;
import com.fincatto.nfe.classes.NFUnidadeFederativa;

public interface NFEConfig {

    final static String VERSAO_NFE = "2.00";

    final static String NFE_NAMESPACE = "http://www.portalfiscal.inf.br/nfe";

    public NFAmbiente getAmbiente();

    public File getCertificado();

    public File getCadeiaCertificados();

    public String getCertificadoSenha();

    public URL getWsdl();

    public NFUnidadeFederativa getCUF();

    public NFTipoEmissao getTipoEmissao();
}
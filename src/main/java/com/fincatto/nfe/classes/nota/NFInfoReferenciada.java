package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFInfoReferenciada extends NFBase {
    @Element(name = "refNFe", required = true)
    private String chaveAcesso;

    @Element(name = "refNF", required = true)
    private NFInfoModelo1Por1AReferenciada modelo1por1Referenciada;

    public String getChaveAcesso() {
        return this.chaveAcesso;
    }

    public void setChaveAcesso(final String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public NFInfoModelo1Por1AReferenciada getModelo1por1Referenciada() {
        return this.modelo1por1Referenciada;
    }

    public void setModelo1por1Referenciada(final NFInfoModelo1Por1AReferenciada modelo1por1Referenciada) {
        this.modelo1por1Referenciada = modelo1por1Referenciada;
    }
}
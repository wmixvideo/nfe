package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.StringValidador;

public class NFInfoReferenciada extends NFBase {
    @Element(name = "refNFe", required = true)
    private String chaveAcesso;

    @Element(name = "refNF", required = true)
    private NFInfoModelo1Por1AReferenciada modelo1por1Referenciada;

    public void setChaveAcesso(final String chaveAcesso) {
        StringValidador.exatamente44(chaveAcesso);
        this.chaveAcesso = chaveAcesso;
    }

    public void setModelo1por1Referenciada(final NFInfoModelo1Por1AReferenciada modelo1por1Referenciada) {
        this.modelo1por1Referenciada = modelo1por1Referenciada;
    }
}
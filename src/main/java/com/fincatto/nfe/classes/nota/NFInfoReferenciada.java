package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.StringValidador;

public class NFInfoReferenciada extends NFBase {
    @Element(name = "refNFe", required = false)
    private String chaveAcesso;

    @Element(name = "refNF", required = false)
    private NFInfoModelo1Por1AReferenciada modelo1por1Referenciada;

    public void setChaveAcesso(final String chaveAcesso) {
        if (this.modelo1por1Referenciada != null) {
            throw new IllegalStateException("Nao pode setar chave de acesso caso modelo 1 por 1 referenciada esteja setado");
        }
        StringValidador.exatamente44N(chaveAcesso);
        this.chaveAcesso = chaveAcesso;
    }

    public void setModelo1por1Referenciada(final NFInfoModelo1Por1AReferenciada modelo1por1Referenciada) {
        if (this.chaveAcesso != null) {
            throw new IllegalStateException("Nao pode setar modelo 1 por 1 referenciada caso chave de acesso esteja setado");
        }
        this.modelo1por1Referenciada = modelo1por1Referenciada;
    }
}
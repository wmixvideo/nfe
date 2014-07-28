package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoItemImpostoCOFINSNaoTributavel extends NFBase {

    @Element(name = "CST", required = true)
    private String situacaoTributaria;

    public NFNotaInfoItemImpostoCOFINSNaoTributavel() {
        this.situacaoTributaria = null;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria.getCodigo();
    }
}
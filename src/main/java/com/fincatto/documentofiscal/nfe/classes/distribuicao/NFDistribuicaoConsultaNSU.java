package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class NFDistribuicaoConsultaNSU extends DFBase {
    private static final long serialVersionUID = -7083100043003754958L;

    @Element(name = "NSU")
    private String nsu;

    public String getNsu() {
        return this.nsu;
    }

    public NFDistribuicaoConsultaNSU setNsu(final String nsu) {
        this.nsu = nsu;
        return this;
    }

}

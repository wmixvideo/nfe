package com.fincatto.nfe.classes;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class NFProtocolo extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infProt", required = true)
    private NFProtocoloInfo protocolo;

    public NFProtocolo() {
        this.versao = null;
        this.protocolo = null;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public void setProtocolo(final NFProtocoloInfo protocolo) {
        this.protocolo = protocolo;
    }
}
package com.fincatto.nfe.classes.cartacorrecao;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFEventoRetorno extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infEvento", required = true)
    private NFInfoEventoRetorno infoEventoRetorno;

    @Element(name = "Signature", required = false)
    private String assinatura;

    public NFInfoEventoRetorno getInfoEventoRetorno() {
        return this.infoEventoRetorno;
    }

    public String getVersao() {
        return this.versao;
    }

    public String getAssinatura() {
        return this.assinatura;
    }
}
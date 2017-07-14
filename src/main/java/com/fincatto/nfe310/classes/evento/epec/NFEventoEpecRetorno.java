package com.fincatto.nfe310.classes.evento.epec;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.nota.assinatura.NFSignature;

public class NFEventoEpecRetorno extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infEvento", required = true)
    private NFInfoEventoEpecRetorno infoEventoRetorno;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public NFInfoEventoEpecRetorno getInfoEventoRetorno() {
        return this.infoEventoRetorno;
    }

    public void setInfoEventoRetorno(final NFInfoEventoEpecRetorno infoEventoRetorno) {
        this.infoEventoRetorno = infoEventoRetorno;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final String versao) {
        this.versao = versao;
    }

    public NFSignature getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(final NFSignature assinatura) {
        this.assinatura = assinatura;
    }
}
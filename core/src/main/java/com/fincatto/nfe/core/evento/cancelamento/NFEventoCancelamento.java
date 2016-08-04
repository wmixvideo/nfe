package com.fincatto.nfe.core.evento.cancelamento;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.validadores.BigDecimalParser;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFEventoCancelamento extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infEvento", required = true)
    private NFInfoEventoCancelamento infoEvento;

    @Element(name = "Signature", required = false)
    private String assinatura;

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public NFInfoEventoCancelamento getInfoEvento() {
        return this.infoEvento;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setInfoEvento(final NFInfoEventoCancelamento infoEvento) {
        this.infoEvento = infoEvento;
    }

    public void setAssinatura(final String assinatura) {
        this.assinatura = assinatura;
    }

    public String getAssinatura() {
        return this.assinatura;
    }
}
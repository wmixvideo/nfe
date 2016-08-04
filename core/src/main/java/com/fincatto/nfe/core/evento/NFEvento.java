package com.fincatto.nfe.core.evento;

import com.fincatto.nfe.core.NFBase;
import com.fincatto.nfe.core.nota.assinatura.NFSignature;
import com.fincatto.nfe.core.validadores.BigDecimalParser;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFEvento extends NFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infEvento", required = true)
    private NFInfoEvento infoEvento;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public NFInfoEvento getInfoEvento() {
        return this.infoEvento;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setInfoEvento(final NFInfoEvento infoEvento) {
        this.infoEvento = infoEvento;
    }

    public void setAssinatura(final NFSignature assinatura) {
        this.assinatura = assinatura;
    }

    public NFSignature getAssinatura() {
        return this.assinatura;
    }
}
package com.fincatto.documentofiscal.nfe400.classes.evento;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.nota.assinatura.NFSignature;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

public class NFEvento extends DFBase {
    private static final long serialVersionUID = 8494204773888020693L;

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
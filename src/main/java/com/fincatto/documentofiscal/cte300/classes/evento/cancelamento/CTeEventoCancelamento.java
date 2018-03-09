package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

import java.math.BigDecimal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;

@Root(name = "eventoCTe")
public class CTeEventoCancelamento extends DFBase {
    private static final long serialVersionUID = -8363617761063438288L;

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infEvento", required = true)
    private CTeInfoEventoCancelamento infoEvento;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public CTeInfoEventoCancelamento getInfoEvento() {
        return this.infoEvento;
    }

    public void setInfoEvento(final CTeInfoEventoCancelamento infoEvento) {
        this.infoEvento = infoEvento;
    }

    public NFSignature getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(final NFSignature assinatura) {
        this.assinatura = assinatura;
    }
}
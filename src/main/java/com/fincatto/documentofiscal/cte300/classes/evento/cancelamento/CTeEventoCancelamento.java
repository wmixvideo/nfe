package com.fincatto.documentofiscal.cte300.classes.evento.cancelamento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "evento")
public class CTeEventoCancelamento extends DFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infEvento", required = true)
    private CTeInfoEventoCancelamento infoEvento;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public String getVersao() {
        return versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public CTeInfoEventoCancelamento getInfoEvento() {
        return infoEvento;
    }

    public void setInfoEvento(CTeInfoEventoCancelamento infoEvento) {
        this.infoEvento = infoEvento;
    }

    public NFSignature getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(NFSignature assinatura) {
        this.assinatura = assinatura;
    }
}
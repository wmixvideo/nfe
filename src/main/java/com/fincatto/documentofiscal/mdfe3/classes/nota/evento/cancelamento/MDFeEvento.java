package com.fincatto.documentofiscal.mdfe3.classes.nota.evento.cancelamento;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.mdfe3.classes.nota.evento.MDFeInfoEvento;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "eventoMDFe")
public class MDFeEvento<T extends MDFeInfoEvento> extends DFBase {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "infEvento", required = true)
    private T infoEvento;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public String getVersao() {
        return versao;
    }

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public T getInfoEvento() {
        return infoEvento;
    }

    public void setInfoEvento(T infoEvento) {
        this.infoEvento = infoEvento;
    }

    public NFSignature getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(NFSignature assinatura) {
        this.assinatura = assinatura;
    }
}
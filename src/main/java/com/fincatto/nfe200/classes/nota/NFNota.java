package com.fincatto.nfe200.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe200.classes.NFBase;
import com.fincatto.nfe200.classes.nota.assinatura.NFSignature;

@Root(name = "NFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNota extends NFBase {

    private long identificadorLocal;

    @Element(name = "infNFe", required = true)
    private NFNotaInfo info;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public void setInfo(final NFNotaInfo info) {
        this.info = info;
    }

    public NFNotaInfo getInfo() {
        return this.info;
    }

    public void setIdentificadorLocal(final long identificadorLocal) {
        this.identificadorLocal = identificadorLocal;
    }

    public long getIdentificadorLocal() {
        return this.identificadorLocal;
    }

    public void setAssinatura(final NFSignature assinatura) {
        this.assinatura = assinatura;
    }

    public NFSignature getAssinatura() {
        return this.assinatura;
    }
}
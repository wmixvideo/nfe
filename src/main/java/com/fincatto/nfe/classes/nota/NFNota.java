package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.nfe.classes.NFBase;

@Root(name = "NFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNota extends NFBase {

    private long identificadorLocal;

    @Element(name = "infNFe", required = true)
    private NFNotaInfo info;

    @Element(name = "Signature", required = false)
    private String assinatura;

    public void setInfo(final NFNotaInfo info) {
        this.info = info;
    }

    public NFNotaInfo getInfo() {
        return this.info;
    }

    /**
     * Utilizado para identificacao interna do sistema
     */
    public void setIdentificadorLocal(final long identificadorLocal) {
        this.identificadorLocal = identificadorLocal;
    }

    public long getIdentificadorLocal() {
        return this.identificadorLocal;
    }

    public void setAssinatura(final String assinatura) {
        this.assinatura = assinatura;
    }
}
package com.fincatto.nfe310.classes.nota;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.nota.assinatura.NFSignature;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "NFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNota extends NFBase {

    private long identificadorLocal;

    @Element(name = "infNFe")
    private NFNotaInfo info;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public void setInfo(final NFNotaInfo info) {
        this.info = info;
    }

    public NFNotaInfo getInfo() {
        return this.info;
    }

    /**
     * Utilizado para identificacao interna do sistema
     * @param identificadorLocal Identificador.
     */
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
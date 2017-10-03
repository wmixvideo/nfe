package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;

@Root(name = "NFe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class NFNota extends DFBase {
    private static final long serialVersionUID = -6327121382813587248L;

    private long identificadorLocal;

    @Element(name = "infNFe")
    private NFNotaInfo info;

    @Element(name = "infNFeSupl", required = false)
    private NFNotaInfoSuplementar infoSuplementar;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public void setInfo(final NFNotaInfo info) {
        this.info = info;
    }

    public NFNotaInfo getInfo() {
        return this.info;
    }

    public NFNotaInfoSuplementar getInfoSuplementar() {
        return this.infoSuplementar;
    }

    public void setInfoSuplementar(final NFNotaInfoSuplementar infoSuplementar) {
        this.infoSuplementar = infoSuplementar;
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
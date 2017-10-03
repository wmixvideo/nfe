package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;

@Root(name = "CTe")
@Namespace(reference = "http://www.portalfiscal.inf.br/nfe")
public class CTe extends DFBase {
    private static final long serialVersionUID = 3664459758546162479L;

    @Element(name = "infCte", required = true)
    private CTInfo infCte;

    @Element(name = "Signature", required = false)
    private NFSignature assinatura;

    public CTInfo getInfCte() {
        return this.infCte;
    }

    public void setInfCte(final CTInfo infCte) {
        this.infCte = infCte;
    }

    public NFSignature getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(final NFSignature assinatura) {
        this.assinatura = assinatura;
    }

}
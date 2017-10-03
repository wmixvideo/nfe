package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class NFNotaInfoTotal extends DFBase {
    private static final long serialVersionUID = 4579495471129802055L;

    @Element(name = "ICMSTot", required = true)
    private NFNotaInfoICMSTotal icmsTotal;

    @Element(name = "ISSQNtot", required = false)
    private NFNotaInfoISSQNTotal issqnTotal;

    @Element(name = "retTrib", required = false)
    private NFNotaInfoRetencoesTributos retencoesTributos;

    public void setIcmsTotal(final NFNotaInfoICMSTotal icmsTotal) {
        this.icmsTotal = icmsTotal;
    }

    public void setIssqnTotal(final NFNotaInfoISSQNTotal issqnTotal) {
        this.issqnTotal = issqnTotal;
    }

    public void setRetencoesTributos(final NFNotaInfoRetencoesTributos retencoesTributos) {
        this.retencoesTributos = retencoesTributos;
    }

    public NFNotaInfoICMSTotal getIcmsTotal() {
        return this.icmsTotal;
    }

    public NFNotaInfoISSQNTotal getIssqnTotal() {
        return this.issqnTotal;
    }

    public NFNotaInfoRetencoesTributos getRetencoesTributos() {
        return this.retencoesTributos;
    }
}
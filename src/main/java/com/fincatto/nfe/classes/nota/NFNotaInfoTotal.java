package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoTotal extends NFBase {

    @Element(name = "ICMSTot", required = true)
    private NFNotaInfoICMSTotal icmsTotal;

    @Element(name = "ISSQNtot", required = false)
    private NFNotaInfoISSQNTotal issqnTotal;

    @Element(name = "retTrib", required = false)
    private NFNotaInfoRetencoesTributos retencoesTributos;

    public NFNotaInfoICMSTotal getIcmsTotal() {
        return this.icmsTotal;
    }

    public void setIcmsTotal(final NFNotaInfoICMSTotal icmsTotal) {
        this.icmsTotal = icmsTotal;
    }

    public NFNotaInfoISSQNTotal getIssqnTotal() {
        return this.issqnTotal;
    }

    public void setIssqnTotal(final NFNotaInfoISSQNTotal issqnTotal) {
        this.issqnTotal = issqnTotal;
    }

    public NFNotaInfoRetencoesTributos getRetencoesTributos() {
        return this.retencoesTributos;
    }

    public void setRetencoesTributos(final NFNotaInfoRetencoesTributos retencoesTributos) {
        this.retencoesTributos = retencoesTributos;
    }
}
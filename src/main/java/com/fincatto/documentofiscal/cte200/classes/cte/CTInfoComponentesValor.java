package com.fincatto.documentofiscal.cte200.classes.cte;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "Comp")
public class CTInfoComponentesValor extends DFBase {
    private static final long serialVersionUID = -4637453857441149321L;

    @Element(name = "xNome")
    private String xNome;

    @Element(name = "vComp")
    private BigDecimal vComp;

    public String getxNome() {
        return this.xNome;
    }

    public void setxNome(final String xNome) {
        this.xNome = xNome;
    }

    public BigDecimal getvComp() {
        return this.vComp;
    }

    public void setvComp(final BigDecimal vComp) {
        this.vComp = vComp;
    }

}

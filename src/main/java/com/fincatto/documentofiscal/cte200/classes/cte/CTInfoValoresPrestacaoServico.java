package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoValoresPrestacaoServico extends DFBase {
    private static final long serialVersionUID = -1168596648594384020L;

    @Element(name = "vTPrest")
    private String valorTotalPrestacaoServico;

    @Element(name = "vRec")
    private String valorReceber;

    @ElementList(name = "Comp", inline = true, required = false)
    private List<CTInfoComponentesValor> componentes;

    public String getValorTotalPrestacaoServico() {
        return this.valorTotalPrestacaoServico;
    }

    public void setValorTotalPrestacaoServico(final String valorTotalPrestacaoServico) {
        this.valorTotalPrestacaoServico = valorTotalPrestacaoServico;
    }

    public String getValorReceber() {
        return this.valorReceber;
    }

    public void setValorReceber(final String valorReceber) {
        this.valorReceber = valorReceber;
    }

    public List<CTInfoComponentesValor> getComponentes() {
        return this.componentes;
    }

    public void setComponentes(final List<CTInfoComponentesValor> componentes) {
        this.componentes = componentes;
    }

}

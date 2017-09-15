package com.fincatto.cte300.classes;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CTe")
public class Cte {

    @Element(name = "infCte", required = true)
    private InfCte infCte;

    public InfCte getInfCte() {
        return this.infCte;
    }

    public void setInfCte(final InfCte infCte) {
        this.infCte = infCte;
    }
}
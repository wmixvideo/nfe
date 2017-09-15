package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "fluxo")
public class InfCteComplFluxo {

    @Element
    private String xOrig;

    @ElementList(required = false, inline = true)
    private List<InfCteComplFluxoPass> pass;

    @Element
    private String xDest;

    @Element
    private String xRota;
}

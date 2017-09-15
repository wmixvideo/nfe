package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "compl")
public class InfCteCompl {

    @Element
    private String xCaracAd;

    @Element
    private String xCaracSer;

    @Element
    private String xEmi;

    @Element(required = false)
    private InfCteComplFluxo fluxo;

    @Element(name = "Entrega", required = false)
    private InfCteComplEntrega entrega;

    @Element(required = false)
    private String origCalc;

    @Element(required = false)
    private String destCalc;

    @Element(required = false)
    private String xObs;

    @ElementList(name = "ObsCont", inline = true, required = false)
    private List<InfCteComplObsCont> obsCont;

    @ElementList(name = "ObsFisco", inline = true, required = false)
    private List<InfCteComplObsFisco> obsFisco;
}
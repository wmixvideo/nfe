package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class InfCteVPrest {

    @Element(name = "vTPrest")
    private String vtPrest;

    @Element
    private String vRec;

    @ElementList(name = "Comp", inline = true)
    private List<InfCteVPrestComp> comp;
}

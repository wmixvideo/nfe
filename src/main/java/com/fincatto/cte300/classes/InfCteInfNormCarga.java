package com.fincatto.cte300.classes;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class InfCteInfNormCarga {

    @Element
    private String vCarga;

    @Element
    private String proPred;

    @Element(required = false)
    private String xOutCat;

    @ElementList(inline = true)
    private List<InfCteInfNormCargaInfQ> infQ;

    @Element(required = false)
    private String vCargaAverb;

}

package com.fincatto.cte300.classes;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "infQ")
public class InfCteInfNormCargaInfQ {

    @Element
    private String cUnid;

    @Element
    private String tpMed;

    @Element
    private String qCarga;
}

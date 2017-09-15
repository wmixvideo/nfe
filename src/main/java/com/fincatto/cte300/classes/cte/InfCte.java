package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "infCte")
public class InfCte {

    @Attribute(name = "versao", required = true)
    private String versao;

    @Attribute(name = "Id", required = true)
    private String id;

    @Element(required = true)
    private InfCteIde ide;

    @Element
    private InfCteCompl compl;

    @Element(required = true)
    private InfCteEmit emit;

    @Element(required = true)
    private InfCteRem rem;

    @Element(required = true)
    private InfCteExped exped;

    @Element(required = true)
    private InfCteReceb receb;

    @Element(required = true)
    private InfCteDest dest;

    @Element(required = true)
    private InfCteVPrest vPrest;

    @Element(required = true)
    private InfCteImp imp;

    @Element(required = true)
    private InfCteInfNorm infCTeNorm;

    @Element(required = true)
    private InfCteComp infCteComp;

    @Element(required = true)
    private InfCteAnu infCteAnu;

    // TODO
    @ElementList(inline = true, required = true)
    private List autXML;

}

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

    @Element
    private InfCteIde ide;

    @Element
    private InfCteCompl compl;

    @Element
    private InfCteEmit emit;

    @Element
    private InfCteRem rem;

    @Element
    private InfCteExped exped;

    @Element
    private InfCteReceb receb;

    @Element
    private InfCteDest dest;

    @Element
    private InfCteVPrest vPrest;

    @Element
    private InfCteImp imp;

    @Element
    private InfCteInfNorm infCTeNorm;

    @Element
    private InfCteComp infCteComp;

    @Element
    private InfCteAnu infCteAnu;

    @ElementList(inline = true, required = false)
    private List<InfCteAutXML> autXML;
}

package com.fincatto.cte300.classes;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "infNF")
public class InfCteInfNormDocNF {

    @Element(required = false)
    private String nRoma;

    @Element(required = false)
    private String nPed;

    @Element
    private String mod;

    @Element
    private String serie;

    @Element
    private String nDoc;

    @Element
    private String dEmi;

    @Element(name = "vBC")
    private String vbc;

    @Element(name = "vICMS")
    private String vicms;

    @Element(name = "vBCST")
    private String vbcst;

    @Element(name = "vST")
    private String vst;

    @Element
    private String vProd;

    @Element(name = "vNF")
    private String vnf;

    @Element(name = "nCFOP")
    private String ncfop;

    @Element(required = false)
    private String nPeso;

    @Element(required = false, name = "PIN")
    private String pin;

    @Element(required = false)
    private String dPrev;

    @ElementList(inline = true, required = false)
    private List<InfCteInfNormDocNFUnidCarga> infUnidCarga;

    @ElementList(inline = true, required = false)
    private List<InfCteInfNormDocNFUnidadeTransp> infUnidTransp;

}

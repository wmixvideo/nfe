package com.fincatto.cte300.classes;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "infUnidTransp")
public class InfCteInfNormDocNFUnidadeTransp {

    @Element
    private String tpUnidTransp;

    @Element
    private String idUnidTransp;

    @ElementList(inline = true, required = false)
    private List<InfCteInfNormDocNFUnidadeTranspLacUnidTransp> lacUnidTransp;

    @Element(required = false)
    private java.lang.String qtdRat;

    @ElementList(inline = true, required = false)
    private List<InfCteInfNormDocNFUnidadeTranspUnidCarga> infUnidCarga;

}

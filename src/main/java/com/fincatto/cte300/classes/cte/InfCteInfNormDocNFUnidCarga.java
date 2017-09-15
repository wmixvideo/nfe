package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "infUnidCarga")
public class InfCteInfNormDocNFUnidCarga {

    @Element
    private String tpUnidCarga;

    @Element
    private String idUnidCarga;

    @ElementList(inline = true, required = false)
    private List<InfCteInfNormDocNFUnidCargaLacUnidCarga> lacUnidCarga;

    @Element(required = false)
    private String qtdRat;
}

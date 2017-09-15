package com.fincatto.cte300.classes;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "infUnidCarga")
public class InfCteInfNormDocNFUnidadeTranspUnidCarga {

    @Element
    private String tpUnidCarga;

    @Element
    private String idUnidCarga;

    @ElementList(inline = true)
    private List<InfCteInfNormDocNFUnidadeTranspUnidCargaLacUnidCarga> lacUnidCarga;

    @Element(required = false)
    private String qtdRat;

}

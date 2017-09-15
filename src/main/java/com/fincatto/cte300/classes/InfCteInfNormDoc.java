package com.fincatto.cte300.classes;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class InfCteInfNormDoc {

    @ElementList(inline = true, required = false)
    private List<InfCteInfNormDocNF> infNF;

    @ElementList(inline = true)
    private List<InfNFe> infNFe;

    @ElementList(inline = true)
    private List<InfOutros> infOutros;
}

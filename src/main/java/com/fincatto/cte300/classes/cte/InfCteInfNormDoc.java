package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.ElementList;

import com.fincatto.cte300.classes.cte.InfCteInfNormDocNF;

public class InfCteInfNormDoc {

    @ElementList(inline = true, required = false)
    private List<InfCteInfNormDocNF> infNF;

    @ElementList(inline = true, required = false)
    private List<InfCteInfNormDocNFe> infNFe;

    @ElementList(inline = true, required = false)
    private List<InfCteInfNormDocOutros> infOutros;
}

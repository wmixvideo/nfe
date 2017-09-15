package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.cte300.classes.cte.InfCteInfNormDocNFUnidCarga;
import com.fincatto.cte300.classes.cte.InfCteInfNormDocNFUnidadeTransp;

public class InfCteInfNormDocOutros {

    @Element
    protected String tpDoc;

    @Element
    protected String descOutros;

    @Element
    protected String nDoc;

    @Element
    protected String dEmi;

    @Element
    protected String vDocFisc;

    @Element
    protected String dPrev;

    @ElementList(inline = true)
    protected List<InfCteInfNormDocNFUnidCarga> infUnidCarga;

    @ElementList(inline = true)
    protected List<InfCteInfNormDocNFUnidadeTransp> infUnidTransp;
}

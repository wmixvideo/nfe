package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class InfCteInfNormDocAntEmiId {

    @ElementList(inline = true)
    private List<InfCteInfNormDocAntEmiIdPap> idDocAntPap;

    @ElementList(inline = true)
    protected List<InfCteInfNormDocAntEmiIdEle> idDocAntEle;

}
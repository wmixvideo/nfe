package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class InfCteInfNormDocAnt {

    @ElementList(inline = true)
    protected List<InfCteInfNormDocAntEmi> emiDocAnt;

}

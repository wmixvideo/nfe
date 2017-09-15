package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.cte300.classes.cte.InfCteInfNormDocNFUnidCarga;
import com.fincatto.cte300.classes.cte.InfCteInfNormDocNFUnidadeTransp;

public class InfCteInfNormDocNFe {

    @Element
    private String chave;

    @Element(name = "PIN")
    private java.lang.String pin;

    @Element
    private String dPrev;

    @ElementList(inline = true)
    private List<InfCteInfNormDocNFUnidCarga> infUnidCarga;

    @ElementList(inline = true)
    private List<InfCteInfNormDocNFUnidadeTransp> infUnidTransp;
}

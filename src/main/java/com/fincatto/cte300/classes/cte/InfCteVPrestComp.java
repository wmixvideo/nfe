package com.fincatto.cte300.classes.cte;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Comp")
public class InfCteVPrestComp {

    @Element
    private String xNome;

    @Element
    private BigDecimal vComp;
}

package com.fincatto.cte300.classes.cte;

import org.simpleframework.xml.Element;

public class InfCteImp {

    @Element(name = "ICMS")
    private InfCteImpostoICMS icms;

    @Element(required = false)
    private String vTotTrib;

    @Element(required = false)
    private String infAdFisco;

    @Element(name = "ICMSUFFim", required = false)
    private InfCteImpostoICMSUfFim icmsufFim;

}

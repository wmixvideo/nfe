package com.fincatto.cte300.classes;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;

public class InfCteImpostoICMS extends NFBase {

    @Element(name = "ICMS00", required = false)
    private InfCteImpostoICMS00 icms00;

    @Element(name = "ICMS20", required = false)
    private InfCteImpostoICMS20 icms20;

    @Element(name = "ICMS45", required = false)
    private InfCteImpostoICMS45 icms45;

    @Element(name = "ICMS60", required = false)
    private InfCteImpostoICMS60 icms60;

    @Element(name = "ICMS90", required = false)
    private InfCteImpostoICMS90 icms90;

    @Element(name = "ICMSOutraUF", required = false)
    private InfCteImpostoICMSOutraUF icmsOutraUF;

    @Element(name = "ICMSSN", required = false)
    private InfCteImpostoICMSSimplesNacional icmsSimplesNacional;

}
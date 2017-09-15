package com.fincatto.cte300.classes.cte;

import org.simpleframework.xml.Element;

public class InfCteImpostoICMSUfFim {

    @Element(name = "vBCUFFim")
    private String vbcufFim;

    @Element(name = "pFCPUFFim")
    private String pfcpufFim;

    @Element(name = "pICMSUFFim")
    private String picmsufFim;

    @Element(name = "pICMSInter")
    private String picmsInter;

    @Element(name = "pICMSInterPart")
    private String picmsInterPart;

    @Element(name = "vFCPUFFim")
    private String vfcpufFim;

    @Element(name = "vICMSUFFim")
    private String vicmsufFim;

    @Element(name = "vICMSUFIni")
    private String vicmsufIni;
}

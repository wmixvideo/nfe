package com.fincatto.cte300.classes.cte;

import java.time.LocalDate;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.nfe310.classes.NFUnidadeFederativa;

@Root(name = "ide")
public class InfCteIde {

    @Element(name = "cUF")
    private String cuf;

    @Element(name = "cCT")
    private String cct;

    @Element(name = "CFOP")
    private String cfop;

    @Element
    private String natOp;

    @Element
    private String forPag;

    @Element
    private String mod;

    @Element
    private String serie;

    @Element(name = "nCT")
    private String nct;

    @Element
    private String dhEmi;

    @Element
    private String tpImp;

    @Element
    private String tpEmis;

    @Element(name = "cDV")
    private String cdv;

    @Element
    private String tpAmb;

    @Element
    private String tpCTe;

    @Element
    private String procEmi;

    @Element
    private String verProc;

    @Element
    private String refCTE;

    @Element
    private String cMunEnv;

    @Element
    private String xMunEnv;

    @Element(name = "UFEnv")
    private NFUnidadeFederativa ufEnv;

    @Element
    private String modal;

    @Element
    private String tpServ;

    @Element
    private String cMunIni;

    @Element
    private String xMunIni;

    @Element(name = "UFIni")
    private NFUnidadeFederativa ufIni;

    @Element
    private String cMunFim;

    @Element
    private String xMunFim;

    @Element(name = "UFFim")
    private NFUnidadeFederativa ufFim;

    @Element
    private String retira;

    @Element(required = false)
    private String xDetRetira;

    @Element(required = false)
    private Toma3 toma03;

    @Element(required = false)
    private Toma4 toma4;

    @Element(required = false)
    private LocalDate dhCont;

    @Element(required = false)
    private String xJust;
}

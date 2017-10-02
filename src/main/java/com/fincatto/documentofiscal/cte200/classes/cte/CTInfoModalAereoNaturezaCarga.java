package com.fincatto.documentofiscal.cte200.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoModalAereoNaturezaCarga extends DFBase {

    @Element(name = "xDime", required = false)
    private String dimensao;

    @Element(name = "cInfManu", required = false)
    private String informacoesManuseio;

    @Element(name = "cIMP")
    private String cargaEspecial;

}

package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;

public class InfCteInfNorm {

    @Element
    private InfCteInfNormCarga infCarga;

    @Element
    private InfCteInfNormDoc infDoc;

    @Element
    private DocAnt docAnt;

    @Element
    private List seg;

    @Element
    private InfModal infModal;

    @Element
    private List peri;

    @Element
    private List veicNovos;

    @Element
    private Cobr cobr;

    @Element
    private InfCteSub infCteSub;
}

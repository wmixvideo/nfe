package com.fincatto.cte300.classes;

import org.simpleframework.xml.Element;

public class InfCteComplEntrega {

    @Element(required = false)
    private InfCteComplEntregaSemData semData;

    @Element(required = false)
    private InfCteComplEntregaComData comData;

    @Element(required = false)
    private InfCteComplEntregaNoPeriodo noPeriodo;

    @Element(required = false)
    private InfCteComplEntregaSemHora semHora;

    @Element(required = false)
    private InfCteComplEntregaComHora comHora;

    @Element(required = false)
    private InfCteComplEntregaNoInter noInter;
}

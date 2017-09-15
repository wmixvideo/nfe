package com.fincatto.cte300.classes;

import org.simpleframework.xml.Element;

public class InfCteEmit {

    @Element(name = "CNPJ")
    private String cnpj;

    @Element(name = "IE")
    private String ie;

    @Element(name = "IEST", required = false)
    private String iest;

    @Element
    private String xNome;

    @Element
    private String xFant;

    @Element
    private CteEnderecoEmit enderEmit;
}

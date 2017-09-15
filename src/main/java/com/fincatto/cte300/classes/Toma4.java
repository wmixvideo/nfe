package com.fincatto.cte300.classes;

import org.simpleframework.xml.Element;

public class Toma4 {

    @Element
    private String toma;

    @Element(name = "CNPJ")
    private String cnpj;

    @Element(name = "CPF")
    private String cpf;

    @Element(name = "IE", required = false)
    private String ie;

    @Element
    private String xNome;

    @Element(required = false)
    private String xFant;

    @Element
    private String fone;

    @Element
    private CteEnderecoTomador enderToma;

    @Element
    private String email;

}
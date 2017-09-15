package com.fincatto.cte300.classes;

import org.simpleframework.xml.Element;

public class InfCteExped {

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "IE")
    private String ie;

    @Element
    private String xNome;

    @Element(required = false)
    private String xFant;

    @Element(required = false)
    private String fone;

    @Element
    private CteEnderecoRem enderExped;

    @Element(required = false)
    private String email;

}

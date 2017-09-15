package com.fincatto.cte300.classes.cte;

import org.simpleframework.xml.Element;

public class InfCteRem {

    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "IE")
    private String ie;

    @Element
    private String xNome;

    @Element(required = false)
    private String fone;

    @Element
    private CteEnderecoRem enderReme;

    @Element(required = false)
    private String email;

}

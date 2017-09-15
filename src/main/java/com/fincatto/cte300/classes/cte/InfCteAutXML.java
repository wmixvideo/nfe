package com.fincatto.cte300.classes.cte;

import org.simpleframework.xml.Element;

public class InfCteAutXML {

    @Element(name = "CNPJ")
    private String cnpj;

    @Element(name = "CPF")
    private String cpf;

}

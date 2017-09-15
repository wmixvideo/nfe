package com.fincatto.cte300.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public class InfCteInfNormDocAntEmi {

    @Element(name = "CNPJ")
    protected String cnpj;

    @Element(name = "CPF")
    protected String cpf;

    @Element(name = "IE")
    protected String ie;

    @Element(name = "UF")
    protected NFUnidadeFederativa uf;

    @Element
    protected String xNome;

    @ElementList(inline = true)
    protected List<InfCteInfNormDocAntEmiId> idDocAnt;

}

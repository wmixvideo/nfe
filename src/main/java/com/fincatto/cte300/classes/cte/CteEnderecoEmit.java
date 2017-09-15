package com.fincatto.cte300.classes.cte;

import org.simpleframework.xml.Element;

public class CteEnderecoEmit {

    @Element(name = "xLgr")
    private String logradouro;

    @Element(name = "nro")
    private String numero;

    @Element(name = "xCpl", required = false)
    private String complemento;

    @Element(name = "xBairro")
    private String bairro;

    @Element(name = "cMun")
    private String codigoMunicipio;

    @Element(name = "xMun")
    private String descricaoMunicipio;

    @Element(name = "CEP", required = false)
    private String cep;

    @Element(name = "UF")
    private String uf;

    @Element(name = "fone", required = false)
    private String telefone;

}
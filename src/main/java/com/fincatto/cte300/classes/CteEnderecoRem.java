package com.fincatto.cte300.classes;

import org.simpleframework.xml.Element;

public class CteEnderecoRem {

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

    @Element(name = "cPais", required = false)
    private String codigoPais;

    @Element(name = "xPais", required = false)
    private String descricaoPais;
}
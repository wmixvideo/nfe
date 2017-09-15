package com.fincatto.cte300.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;

public class InfCteImpostoICMS20 {

    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "pRedBC")
    private String percentualReducaoBaseCalculo;

    @Element(name = "vBC")
    private String valorBaseCalculo;

    @Element(name = "pICMS")
    private String percentualAliquota;

    @Element(name = "vICMS")
    private String valorTributo;

}

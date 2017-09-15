package com.fincatto.cte300.classes;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;

public class InfCteImpostoICMSOutraUF {

    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "pRedBCOutraUF", required = false)
    private String percentualReducaoBaseCalculo;

    @Element(name = "vBCOutraUF")
    private String valorBaseCalculo;

    @Element(name = "pICMSOutraUF")
    private String percentualAliquota;

    @Element(name = "vICMSOutraUF")
    private String valorTributo;
}

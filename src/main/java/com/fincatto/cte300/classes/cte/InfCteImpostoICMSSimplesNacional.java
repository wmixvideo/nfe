package com.fincatto.cte300.classes.cte;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;

public class InfCteImpostoICMSSimplesNacional {

    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "indSN")
    private String indicadorSimplesNacional;

}

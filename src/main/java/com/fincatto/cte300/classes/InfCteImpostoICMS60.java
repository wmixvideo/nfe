package com.fincatto.cte300.classes;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;

public class InfCteImpostoICMS60 {

    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "vBCSTRet")
    private String valorBaseCalculoRetencao;

    @Element(name = "vICMSSTRet")
    private String valorRetido;

    @Element(name = "pICMSSTRet")
    private String percentualAliquota;

    @Element(name = "vCred", required = false)
    private String valorCredito;

}

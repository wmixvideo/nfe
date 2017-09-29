package com.fincatto.documentofiscal.cte200.classes.cte;

import org.joda.time.LocalDate;
import org.simpleframework.xml.Element;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoModalAereo extends DFBase {

    @Element(name = "nMinu", required = false)
    private String numeroMinuta;

    @Element(name = "nOCA", required = false)
    private LocalDate numeroOperacional;

    @Element(name = "dPrevAereo")
    private LocalDate dataPrevisaoEntrega;

    @Element(name = "xLAgEmi", required = false)
    private String identificacaoEmissor;

    @Element(name = "IdT", required = false)
    private String identificacaoInterna;

    @Element(name = "tarifa")
    private CTInfoModalAereoTarifa tarifa;

    @Element(name = "natCarga")
    private CTInfoModalAereoNaturezaCarga naturezaCarga;

}

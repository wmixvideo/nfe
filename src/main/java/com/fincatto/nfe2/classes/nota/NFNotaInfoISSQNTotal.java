package com.fincatto.nfe2.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe2.classes.NFBase;
import com.fincatto.nfe2.validadores.BigDecimalParser;

public class NFNotaInfoISSQNTotal extends NFBase {
    @Element(name = "vServ", required = false)
    private String valorTotalServicosSobNaoIncidenciaNaoTributadosICMS;

    @Element(name = "vBC", required = false)
    private String baseCalculoISS;

    @Element(name = "vISS", required = false)
    private String valorTotalISS;

    @Element(name = "vPIS", required = false)
    private String valorPISsobreServicos;

    @Element(name = "vCOFINS", required = false)
    private String valorCOFINSsobreServicos;

    public void setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(final BigDecimal valorTotalServicosSobNaoIncidenciaNaoTributadosICMS) {
        this.valorTotalServicosSobNaoIncidenciaNaoTributadosICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalServicosSobNaoIncidenciaNaoTributadosICMS);
    }

    public void setBaseCalculoISS(final BigDecimal baseCalculoISS) {
        this.baseCalculoISS = BigDecimalParser.tamanho15Com2CasasDecimais(baseCalculoISS);
    }

    public void setValorTotalISS(final BigDecimal valorTotalISS) {
        this.valorTotalISS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalISS);
    }

    public void setValorPISsobreServicos(final BigDecimal valorPISsobreServicos) {
        this.valorPISsobreServicos = BigDecimalParser.tamanho15Com2CasasDecimais(valorPISsobreServicos);
    }

    public void setValorCOFINSsobreServicos(final BigDecimal valorCOFINSsobreServicos) {
        this.valorCOFINSsobreServicos = BigDecimalParser.tamanho15Com2CasasDecimais(valorCOFINSsobreServicos);
    }
}
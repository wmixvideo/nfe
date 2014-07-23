package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoCanaDeducao extends NFBase {
    @Element(name = "xDed", required = true)
    private String descricaoDeducao;

    @Element(name = "vDed", required = true)
    private String valorDeducao;

    @Element(name = "vFor", required = true)
    private String valorFornecimento;

    @Element(name = "vTotDed", required = true)
    private String valorTotalDeducao;

    @Element(name = "vLiqFor", required = true)
    private String valorLiquidoFornecimento;

    public String getDescricaoDeducao() {
        return this.descricaoDeducao;
    }

    public void setDescricaoDeducao(final String descricaoDeducao) {
        StringValidador.tamanho60(descricaoDeducao);
        this.descricaoDeducao = descricaoDeducao;
    }

    public BigDecimal getValorDeducao() {
        return new BigDecimal(this.valorDeducao);
    }

    public void setValorDeducao(final BigDecimal valorDeducao) {
        this.valorDeducao = BigDecimalParser.tamanho15Com2CasasDecimais(valorDeducao);
    }

    public BigDecimal getValorFornecimento() {
        return new BigDecimal(this.valorFornecimento);
    }

    public void setValorFornecimento(final BigDecimal valorFornecimento) {
        this.valorFornecimento = BigDecimalParser.tamanho15Com2CasasDecimais(valorFornecimento);
    }

    public BigDecimal getValorTotalDeducao() {
        return new BigDecimal(this.valorTotalDeducao);
    }

    public void setValorTotalDeducao(final BigDecimal valorTotalDeducao) {
        this.valorTotalDeducao = BigDecimalParser.tamanho15Com2CasasDecimais(valorTotalDeducao);
    }

    public BigDecimal getValorLiquidoFornecimento() {
        return new BigDecimal(this.valorLiquidoFornecimento);
    }

    public void setValorLiquidoFornecimento(final BigDecimal valorLiquidoFornecimento) {
        this.valorLiquidoFornecimento = BigDecimalParser.tamanho15Com2CasasDecimais(valorLiquidoFornecimento);
    }
}
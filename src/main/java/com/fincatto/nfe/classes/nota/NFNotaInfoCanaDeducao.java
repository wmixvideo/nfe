package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;

public class NFNotaInfoCanaDeducao extends NFBase {
    @Element(name = "xDed", required = true)
    private String descricaoDeducao;

    @Element(name = "vDed", required = true)
    private BigDecimal valorDeducao;

    @Element(name = "vFor", required = true)
    private BigDecimal valorFornecimento;

    @Element(name = "vTotDed", required = true)
    private BigDecimal valorTotalDeducao;

    @Element(name = "vLiqFor", required = true)
    private BigDecimal valorLiquidoFornecimento;

    public String getDescricaoDeducao() {
        return this.descricaoDeducao;
    }

    public void setDescricaoDeducao(final String descricaoDeducao) {
        if (StringUtils.isBlank(descricaoDeducao)) {
            throw new IllegalStateException("descricaoDeducao nao pode ser vazia");
        }
        if (descricaoDeducao.length() > 60) {
            throw new IllegalStateException("descricaoDeducao deve conter 60 ou menos caracteres");
        }
        this.descricaoDeducao = descricaoDeducao;
    }

    public BigDecimal getValorDeducao() {
        return this.valorDeducao;
    }

    public void setValorDeducao(final BigDecimal valorDeducao) {
        this.valorDeducao = valorDeducao;
    }

    public BigDecimal getValorFornecimento() {
        return this.valorFornecimento;
    }

    public void setValorFornecimento(final BigDecimal valorFornecimento) {
        this.valorFornecimento = valorFornecimento;
    }

    public BigDecimal getValorTotalDeducao() {
        return this.valorTotalDeducao;
    }

    public void setValorTotalDeducao(final BigDecimal valorTotalDeducao) {
        this.valorTotalDeducao = valorTotalDeducao;
    }

    public BigDecimal getValorLiquidoFornecimento() {
        return this.valorLiquidoFornecimento;
    }

    public void setValorLiquidoFornecimento(final BigDecimal valorLiquidoFornecimento) {
        this.valorLiquidoFornecimento = valorLiquidoFornecimento;
    }
}
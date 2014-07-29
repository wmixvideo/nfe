package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoPISAliquota extends NFBase {

    @Element(name = "CST", required = true)
    private NFNotaInfoSituacaoTributariaPIS situacaoTributaria;

    @Element(name = "vBC", required = true)
    private String valorBaseCalculo;

    @Element(name = "pPIS", required = true)
    private String percentualAliquota;

    @Element(name = "vPIS", required = true)
    private String valorTributo;

    public NFNotaInfoItemImpostoPISAliquota() {
        this.situacaoTributaria = null;
        this.valorBaseCalculo = null;
        this.percentualAliquota = null;
        this.valorTributo = null;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaPIS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo);
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = BigDecimalParser.tamanho5Com2CasasDecimais(aliquota);
    }

    public void setValorTributo(final BigDecimal valor) {
        this.valorTributo = BigDecimalParser.tamanho15Com2CasasDecimais(valor);
    }
}
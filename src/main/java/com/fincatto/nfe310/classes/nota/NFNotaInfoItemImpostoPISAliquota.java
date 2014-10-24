package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFNotaInfoSituacaoTributariaPIS;
import com.fincatto.nfe310.validadores.BigDecimalParser;

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
        if (!NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_CUMULATIVO_NAO_CUMULATIVO.equals(situacaoTributaria) && !NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_ALIQUOTA_DIFERENCIADA.equals(situacaoTributaria)) {
            throw new IllegalStateException("Situacao tributaria invalida");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo);
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquota);
    }

    public void setValorTributo(final BigDecimal valor) {
        this.valorTributo = BigDecimalParser.tamanho15Com2CasasDecimais(valor);
    }

    public NFNotaInfoSituacaoTributariaPIS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public String getValorBaseCalculo() {
        return this.valorBaseCalculo;
    }

    public String getPercentualAliquota() {
        return this.percentualAliquota;
    }

    public String getValorTributo() {
        return this.valorTributo;
    }
}
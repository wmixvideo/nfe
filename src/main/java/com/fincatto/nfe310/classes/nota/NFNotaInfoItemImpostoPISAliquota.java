package com.fincatto.nfe310.classes.nota;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.simpleframework.xml.Element;

import com.fincatto.nfe310.classes.NFBase;
import com.fincatto.nfe310.classes.NFNotaInfoSituacaoTributariaPIS;
import com.fincatto.nfe310.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoPISAliquota extends NFBase {
    private static final List<NFNotaInfoSituacaoTributariaPIS> SITUACOES_VALIDAS = Arrays.asList(NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_CUMULATIVO_NAO_CUMULATIVO, NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_ALIQUOTA_DIFERENCIADA);

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
        if (!NFNotaInfoItemImpostoPISAliquota.SITUACOES_VALIDAS.contains(situacaoTributaria)) {
            throw new IllegalStateException("Situacao tributaria invalida");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo, "Valor BC PIS Item");
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = BigDecimalParser.tamanho7ComAte4CasasDecimais(aliquota, "Aliquota PIS Item");
    }

    public void setValorTributo(final BigDecimal valor) {
        this.valorTributo = BigDecimalParser.tamanho15Com2CasasDecimais(valor, "Valor PIS Item");
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
package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFNotaInfoSituacaoTributariaCOFINS;
import com.fincatto.nfe.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoCOFINSOutrasOperacoes extends NFBase {

    @Element(name = "CST", required = true)
    private String codigoSituacaoTributaria;

    @Element(name = "vBC", required = true)
    private String valorBaseCalculo;

    @Element(name = "pCOFINS", required = true)
    private String percentualCOFINS;

    @Element(name = "qBCProd", required = true)
    private String quantidadeVendida;

    @Element(name = "vAliqProd", required = true)
    private String valorAliquota;

    @Element(name = "vCOFINS", required = true)
    private String valorCOFINS;

    public NFNotaInfoItemImpostoCOFINSOutrasOperacoes() {
        this.codigoSituacaoTributaria = null;
        this.valorBaseCalculo = null;
        this.percentualCOFINS = null;
        this.quantidadeVendida = null;
        this.valorAliquota = null;
        this.valorCOFINS = null;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria) {
        this.codigoSituacaoTributaria = situacaoTributaria.getCodigo();
    }

    public void setValorBaseCalculo(final BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalculo);
    }

    public void setPercentualCOFINS(final BigDecimal percentualCOFINS) {
        this.percentualCOFINS = BigDecimalParser.tamanho5Com2CasasDecimais(percentualCOFINS);
    }

    public void setQuantidadeVendida(final BigDecimal quantidadeVendida) {
        this.quantidadeVendida = BigDecimalParser.tamanho16ComAte4CasasDecimais(quantidadeVendida);
    }

    public void setValorAliquota(final BigDecimal valorAliquota) {
        this.valorAliquota = BigDecimalParser.tamanho15Com4CasasDecimais(valorAliquota);
    }

    public void setValorCOFINS(final BigDecimal valorTributo) {
        this.valorCOFINS = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo);
    }
}
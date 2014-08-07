package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;
import com.fincatto.nfe.classes.NFOrigem;
import com.fincatto.nfe.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoICMS20 extends NFBase {

    @Element(name = "orig", required = true)
    private NFOrigem origem;

    @Element(name = "CST", required = true)
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "modBC", required = true)
    private NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeBaseCalculo;

    @Element(name = "pRedBC", required = true)
    private String percentualReducaoBC;

    @Element(name = "vBC", required = true)
    private String valorBCICMS;

    @Element(name = "pICMS", required = true)
    private String percentualAliquota;

    @Element(name = "vICMS", required = true)
    private String valorTributo;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setModalidadeBaseCalculo(final NFNotaInfoItemImpostoICMSModalidadeBaseCalulo modalidadeBaseCalculo) {
        this.modalidadeBaseCalculo = modalidadeBaseCalculo;
    }

    public void setPercentualReducaoBC(final BigDecimal percentualReducaoBC) {
        this.percentualReducaoBC = BigDecimalParser.tamanho5Com2CasasDecimais(percentualReducaoBC);
    }

    public void setValorBCICMS(final BigDecimal valorBCICMS) {
        this.valorBCICMS = BigDecimalParser.tamanho15Com2CasasDecimais(valorBCICMS);
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = BigDecimalParser.tamanho5Com2CasasDecimais(aliquota);
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = BigDecimalParser.tamanho15Com2CasasDecimais(valorTributo);
    }
}
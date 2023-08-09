package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS61 extends DFBase {
    private static final long serialVersionUID = -8806839168760474001L;

    @Element(name = "orig")
    private NFOrigem origem;
    
    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "qBCMonoRet", required = false)
    private String quantidadeBaseCalculo;

    @Element(name = "adRemICMSRet")
    private String percentualAliquota;

    @Element(name = "vICMSMonoRet")
    private String valorTributo;

    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        if (!situacaoTributaria.equals(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COBRADA_ANTERIORMENTE)) {
            throw new IllegalStateException("Situacao tributaria invalida no item ICMS61 ");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setQuantidadeBaseCalculo(final BigDecimal quantidadeBaseCalculo) {
        this.quantidadeBaseCalculo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(quantidadeBaseCalculo, "Quantidade tributada retida anteriormente");
    }

    public void setPercentualAliquota(final BigDecimal percentualAliquota) {
        this.percentualAliquota = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualAliquota, "Alíquota ad rem do imposto retido anteriormente");
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributo, "ICMS retido anteriormente");
    }

    public NFOrigem getOrigem() {
        return origem;
    }

    public NFNotaInfoImpostoTributacaoICMS getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public String getQuantidadeBaseCalculo() {
        return quantidadeBaseCalculo;
    }

    public String getPercentualAliquota() {
        return percentualAliquota;
    }

    public String getValorTributo() {
        return valorTributo;
    }
}

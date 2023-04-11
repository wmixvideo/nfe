package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS53 extends DFBase {
    private static final long serialVersionUID = 6825237127788382375L;

    @Element(name = "orig")
    private NFOrigem origem;
    
    @Element(name = "CST")
    private NFNotaInfoImpostoTributacaoICMS situacaoTributaria;

    @Element(name = "qBCMonoDif")
    private String quantidadeBaseCalculo;

    @Element(name = "adRemICMSDif")
    private String percentualAliquota;

    @Element(name = "vICMSMonoDif")
    private String valorTributo;


    public void setOrigem(final NFOrigem origem) {
        this.origem = origem;
    }

    public void setSituacaoTributaria(final NFNotaInfoImpostoTributacaoICMS situacaoTributaria) {
        if (!situacaoTributaria.equals(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COM_RECOLHIMENTO_DIFERIDO)) {
            throw new IllegalStateException("Situacao tributaria invalida no item ICMS53 ");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setQuantidadeBaseCalculo(BigDecimal quantidadeBaseCalculo) {
        this.quantidadeBaseCalculo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(quantidadeBaseCalculo, "Quantidade tributada diferida");
    }

    public void setPercentualAliquota(BigDecimal percentualAliquota) {
        this.percentualAliquota = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(percentualAliquota, "Alíquota ad rem do imposto diferido");
    }

    public void setValorTributo(BigDecimal valorTributo) {
        this.valorTributo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributo, "Valor do ICMS diferido");
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

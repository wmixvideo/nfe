package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoSituacaoTributariaCOFINS;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoCOFINSQuantidade extends DFBase {
    private static final long serialVersionUID = -7179547773505825448L;
    
    @Element(name = "CST")
    private NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria;
    
    @Element(name = "qBCProd")
    private String quantidadeVendida;
    
    @Element(name = "vAliqProd")
    private String valorAliquota;
    
    @Element(name = "vCOFINS")
    private String valorTributo;

    public NFNotaInfoItemImpostoCOFINSQuantidade() {
        this.situacaoTributaria = null;
        this.quantidadeVendida = null;
        this.valorAliquota = null;
        this.valorTributo = null;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria) {
        if (!NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_TRIBUTAVEL_QUANTIDADE_VENDIDA_POR_ALIQUOTA_POR_UNIDADE_PRODUTO.equals(situacaoTributaria)) {
            throw new IllegalStateException("Situacao tributaria invalida no item COFINS quantidade.");
        }
        this.situacaoTributaria = situacaoTributaria;
    }

    public void setQuantidadeVendida(final BigDecimal quantidadeVendida) {
        this.quantidadeVendida = DFBigDecimalValidador.tamanho16ComAte4CasasDecimais(quantidadeVendida, "Quantidade Vendida COFINS Item Qtde");
    }

    public void setValorAliquota(final BigDecimal valorAliquota) {
        this.valorAliquota = DFBigDecimalValidador.tamanho15Com4CasasDecimais(valorAliquota, "Valor Aliquota COFINS Item Qtde");
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo COFINS Item Qtde");
    }

    public NFNotaInfoSituacaoTributariaCOFINS getSituacaoTributaria() {
        return this.situacaoTributaria;
    }

    public String getQuantidadeVendida() {
        return this.quantidadeVendida;
    }

    public String getValorAliquota() {
        return this.valorAliquota;
    }

    public String getValorTributo() {
        return this.valorTributo;
    }
}

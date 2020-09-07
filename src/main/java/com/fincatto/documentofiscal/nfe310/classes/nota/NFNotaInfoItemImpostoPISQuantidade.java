package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaPIS;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoPISQuantidade extends DFBase {
    private static final long serialVersionUID = 8768801743177271906L;
    
    @Element(name = "CST")
    private NFNotaInfoSituacaoTributariaPIS situacaoTributaria;
    
    @Element(name = "qBCProd")
    private String quantidadeVendida;
    
    @Element(name = "vAliqProd")
    private String valorAliquota;
    
    @Element(name = "vPIS")
    private String valorTributo;

    public NFNotaInfoItemImpostoPISQuantidade() {
        this.situacaoTributaria = null;
        this.quantidadeVendida = null;
        this.valorAliquota = null;
        this.valorTributo = null;
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaPIS situacaoTributaria) {
        if (!NFNotaInfoSituacaoTributariaPIS.OPERACAO_TRIBUTAVEL_QUANTIDADE_VENDIDA_POR_ALIQUOTA_POR_UNIDADE_PRODUTO.equals(situacaoTributaria)) {
            throw new IllegalStateException("Situacao tributaria invalido no item PIS Quantidade");
        }

        this.situacaoTributaria = situacaoTributaria;
    }

    public void setQuantidadeVendida(final BigDecimal quantidadeVendida) {
        this.quantidadeVendida = DFBigDecimalValidador.tamanho16ComAte4CasasDecimais(quantidadeVendida, "Quantidade Vendida PIS Qtde Item");
    }

    public void setValorAliquota(final BigDecimal valorAliquota) {
        this.valorAliquota = DFBigDecimalValidador.tamanho15Com4CasasDecimais(valorAliquota, "Valor Aliquota PIS Qtde Item");
    }

    public void setValorTributo(final BigDecimal valorTributo) {
        this.valorTributo = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valorTributo, "Valor Tributo PIS Qtde Item");
    }

    public NFNotaInfoSituacaoTributariaPIS getSituacaoTributaria() {
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
package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoCombustivelCIDE extends DFBase {
    private static final long serialVersionUID = -2869376510830652913L;
    
    @Element(name = "qBCProd")
    private String quantidadeBCCIDE;
    
    @Element(name = "vAliqProd")
    private String valorAliquota;
    
    @Element(name = "vCIDE")
    private String valor;

    public NFNotaInfoItemProdutoCombustivelCIDE() {
        this.quantidadeBCCIDE = null;
        this.valorAliquota = null;
        this.valor = null;
    }

    public void setQuantidadeBCCIDE(final BigDecimal quantidade) {
        this.quantidadeBCCIDE = DFBigDecimalValidador.tamanho16Com4CasasDecimais(quantidade, "Quantidade Combustivel CIDE");
    }

    public void setValorAliquota(final BigDecimal valorAliquota) {
        this.valorAliquota = DFBigDecimalValidador.tamanho15Com4CasasDecimais(valorAliquota, "Valor Aliquota Combustivel CIDE");
    }

    public void setValor(final BigDecimal valor) {
        this.valor = DFBigDecimalValidador.tamanho15Com2CasasDecimais(valor, "Valor Combustivel CIDE");
    }

    public String getQuantidadeBCCIDE() {
        return this.quantidadeBCCIDE;
    }

    public String getValorAliquota() {
        return this.valorAliquota;
    }

    public String getValor() {
        return this.valor;
    }
}
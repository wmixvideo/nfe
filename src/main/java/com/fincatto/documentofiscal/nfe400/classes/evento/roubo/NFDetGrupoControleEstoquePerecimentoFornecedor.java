package com.fincatto.documentofiscal.nfe400.classes.evento.roubo;

import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gControleEstoque")
public class NFDetGrupoControleEstoquePerecimentoFornecedor extends NFDetGrupoControleEstoquePerecimento {

    @Element(name = "vIBS")
    private BigDecimal valorIBS;

    @Element(name = "vCBS")
    private BigDecimal valorCBS;

    public BigDecimal getValorIBS() {
        return valorIBS;
    }

    public void setValorIBS(BigDecimal valorIBS) {
        DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorIBS, "Valor IBS");
        this.valorIBS = valorIBS;
    }

    public BigDecimal getValorCBS() {
        return valorCBS;
    }

    public void setValorCBS(BigDecimal valorCBS) {
        DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorCBS, "Valor CBS");
        this.valorCBS = valorCBS;
    }
}

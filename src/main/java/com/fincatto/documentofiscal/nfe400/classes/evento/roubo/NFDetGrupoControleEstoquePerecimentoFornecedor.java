package com.fincatto.documentofiscal.nfe400.classes.evento.roubo;

import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gControleEstoque")
public class NFDetGrupoControleEstoquePerecimentoFornecedor extends NFDetGrupoControleEstoquePerecimento {

    @Element(name = "vIBS")
    private String valorIBS;

    @Element(name = "vCBS")
    private String valorCBS;

    public String getValorIBS() {
        return valorIBS;
    }

    public void setValorIBS(BigDecimal valorIBS) {
        this.valorIBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorIBS, "Valor IBS");
    }

    public String getValorCBS() {
        return valorCBS;
    }

    public void setValorCBS(BigDecimal valorCBS) {
        this.valorCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorCBS, "Valor CBS");
    }
}

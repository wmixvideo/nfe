package com.fincatto.documentofiscal.nfe400.classes.evento.naofornecido;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gControleEstoque")
public class NFDetGrupoControleEstoqueNaoFornecimento extends DFBase {

    @Element(name = "qNaoFornecida")
    private BigDecimal quantidade;

    @Element(name = "uNaoFornecida")
    private String unidadeMedida;

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        DFBigDecimalValidador.tamanho11Com4CasasDecimais(quantidade, "Quantidade não fornecida");
        this.quantidade = quantidade;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        DFStringValidador.tamanho6(unidadeMedida, "Unidade de Medida");
        this.unidadeMedida = unidadeMedida;
    }
}

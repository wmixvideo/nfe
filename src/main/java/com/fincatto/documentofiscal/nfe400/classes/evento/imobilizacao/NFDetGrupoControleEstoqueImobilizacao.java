package com.fincatto.documentofiscal.nfe400.classes.evento.imobilizacao;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gControleEstoque")
public class NFDetGrupoControleEstoqueImobilizacao extends DFBase {

    @Element(name = "qImobilizado")
    private BigDecimal quantidade;

    @Element(name = "uImobilizado")
    private String unidade;

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        DFBigDecimalValidador.tamanho11Com4CasasDecimais(quantidade, "Quantidade");
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        DFStringValidador.tamanho6(unidade, "Unidade de medida");
        this.unidade = unidade;
    }
}

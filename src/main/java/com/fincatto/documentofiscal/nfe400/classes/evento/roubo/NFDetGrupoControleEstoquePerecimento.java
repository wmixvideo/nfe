package com.fincatto.documentofiscal.nfe400.classes.evento.roubo;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gControleEstoque")
public class NFDetGrupoControleEstoquePerecimento extends DFBase {

    @Element(name = "qPerecimento")
    private String quantidade;

    @Element(name = "uPerecimento")
    private String unidade;

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = DFBigDecimalValidador.tamanho11Com4CasasDecimais(quantidade, "Quantidade Perecimento");
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        DFStringValidador.tamanho6N(unidade, "Unidade Perecimento");
        this.unidade = unidade;
    }
}

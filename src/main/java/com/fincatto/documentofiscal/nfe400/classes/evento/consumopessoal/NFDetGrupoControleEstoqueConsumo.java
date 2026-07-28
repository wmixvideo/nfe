package com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gControleEstoque")
public class NFDetGrupoControleEstoqueConsumo extends DFBase {

    @Element(name = "qConsumo")
    private String quantidade;

    @Element(name = "uConsumo")
    private String unidadeMedida;

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = DFBigDecimalValidador.tamanho11Com4CasasDecimais(quantidade, "Quantidade de Consumo");
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        DFStringValidador.tamanho3(unidadeMedida, "Unidade de Medida de Consumo");
        this.unidadeMedida = unidadeMedida;
    }
}

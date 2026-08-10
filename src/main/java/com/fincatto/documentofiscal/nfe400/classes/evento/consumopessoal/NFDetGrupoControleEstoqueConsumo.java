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
    private String quantidadeConsumo;

    @Element(name = "uConsumo")
    private String unidadeMedidaConsumo;

    public String getQuantidadeConsumo() {
        return quantidadeConsumo;
    }

    public void setQuantidadeConsumo(BigDecimal quantidadeConsumo) {
        this.quantidadeConsumo = DFBigDecimalValidador.tamanho11Com4CasasDecimais(quantidadeConsumo, "Quantidade de Consumo");
    }

    public String getUnidadeMedidaConsumo() {
        return unidadeMedidaConsumo;
    }

    public void setUnidadeMedidaConsumo(String unidadeMedidaConsumo) {
        DFStringValidador.tamanho3(unidadeMedidaConsumo, "Unidade de Medida de Consumo");
        this.unidadeMedidaConsumo = unidadeMedidaConsumo;
    }
}

package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocomb;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gControleEstoque")
public class NFDetGrupoControleEstoque extends DFBase {

    @Element(name = "qComb")
    private String quantidadeCombustivel;

    @Element(name = "uComb")
    private String unidadeCombustivel;

    public String getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }

    public void setQuantidadeCombustivel(BigDecimal quantidadeCombustivel) {
        this.quantidadeCombustivel = DFBigDecimalValidador.tamanho11Com4CasasDecimais(quantidadeCombustivel, "Quantidade de Combustível");
    }

    public String getUnidadeCombustivel() {
        return unidadeCombustivel;
    }

    public void setUnidadeCombustivel(String unidadeCombustivel) {
        DFStringValidador.tamanho6(unidadeCombustivel, "Unidade de Medida do Combustível");
        this.unidadeCombustivel = unidadeCombustivel;
    }
}

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
    private String quantidadePerecimento;

    @Element(name = "uPerecimento")
    private String unidadePerecimento;

    public String getQuantidadePerecimento() {
        return quantidadePerecimento;
    }

    public void setQuantidadePerecimento(BigDecimal quantidadePerecimento) {
        this.quantidadePerecimento = DFBigDecimalValidador.tamanho11Com4CasasDecimais(quantidadePerecimento, "Quantidade Perecimento");
    }

    public String getUnidadePerecimento() {
        return unidadePerecimento;
    }

    public void setUnidadePerecimento(String unidadePerecimento) {
        DFStringValidador.tamanho6N(unidadePerecimento, "Unidade Perecimento");
        this.unidadePerecimento = unidadePerecimento;
    }
}

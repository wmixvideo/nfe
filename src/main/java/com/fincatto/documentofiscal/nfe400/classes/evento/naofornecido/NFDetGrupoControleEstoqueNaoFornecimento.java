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
    private String quantidadeNaoFornecida;

    @Element(name = "uNaoFornecida")
    private String unidadeMedidaNaoFornecimento;

    public String getQuantidadeNaoFornecida() {
        return quantidadeNaoFornecida;
    }

    public void setQuantidadeNaoFornecida(BigDecimal quantidadeNaoFornecida) {
        this.quantidadeNaoFornecida = DFBigDecimalValidador.tamanho11Com4CasasDecimais(quantidadeNaoFornecida, "Quantidade não fornecida");
    }

    public String getUnidadeMedidaNaoFornecimento() {
        return unidadeMedidaNaoFornecimento;
    }

    public void setUnidadeMedidaNaoFornecimento(String unidadeMedidaNaoFornecimento) {
        DFStringValidador.tamanho6(unidadeMedidaNaoFornecimento, "Unidade de Medida");
        this.unidadeMedidaNaoFornecimento = unidadeMedidaNaoFornecimento;
    }
}

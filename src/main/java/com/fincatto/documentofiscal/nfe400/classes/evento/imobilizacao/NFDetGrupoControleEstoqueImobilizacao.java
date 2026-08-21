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
    private String quantidadeImobilizada;

    @Element(name = "uImobilizado")
    private String unidadeImobilizada;

    public String getQuantidadeImobilizada() {
        return quantidadeImobilizada;
    }

    public void setQuantidadeImobilizada(BigDecimal quantidadeImobilizada) {
        this.quantidadeImobilizada = DFBigDecimalValidador.tamanho11Com4CasasDecimais(quantidadeImobilizada, "Quantidade");
    }

    public String getUnidadeImobilizada() {
        return unidadeImobilizada;
    }

    public void setUnidadeImobilizada(String unidadeImobilizada) {
        DFStringValidador.tamanho6(unidadeImobilizada, "Unidade de medida");
        this.unidadeImobilizada = unidadeImobilizada;
    }
}

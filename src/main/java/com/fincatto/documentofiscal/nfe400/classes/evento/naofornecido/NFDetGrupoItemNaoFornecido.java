package com.fincatto.documentofiscal.nfe400.classes.evento.naofornecido;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gItemNaoFornecido")
public class NFDetGrupoItemNaoFornecido extends DFBase {

    @Attribute(name = "nItem")
    private Integer numeroItem;

    @Element(name = "vIBS")
    private String valorIbs;

    @Element(name = "vCBS")
    private String valorCbs;

    @Element(name = "gControleEstoque")
    private NFDetGrupoControleEstoqueNaoFornecimento controleEstoque;

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        DFIntegerValidador.tamanho1a3(numeroItem, "Número do Item");
        this.numeroItem = numeroItem;
    }

    public String getValorIbs() {
        return valorIbs;
    }

    public void setValorIbs(BigDecimal valorIbs) {
        this.valorIbs = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorIbs, "Valor IBS");
    }

    public String getValorCbs() {
        return valorCbs;
    }

    public void setValorCbs(BigDecimal valorCbs) {
        this.valorCbs = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorCbs, "Valor CBS");
    }

    public NFDetGrupoControleEstoqueNaoFornecimento getControleEstoque() {
        return controleEstoque;
    }

    public void setControleEstoque(NFDetGrupoControleEstoqueNaoFornecimento controleEstoque) {
        this.controleEstoque = controleEstoque;
    }
}

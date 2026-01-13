package com.fincatto.documentofiscal.nfe400.classes.evento.imobilizacao;

import com.fincatto.documentofiscal.nfe400.classes.evento.AbstractNFDetGrupoItem;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "gImobilizacao")
public class NFDetGrupoImobilizacao extends AbstractNFDetGrupoItem {

    @Attribute(name = "nItem")
    private Integer numeroItem;

    @Element(name = "gControleEstoque")
    private NFDetGrupoControleEstoqueImobilizacao grupoControleEstoque;

    public NFDetGrupoControleEstoqueImobilizacao getGrupoControleEstoque() {
        return grupoControleEstoque;
    }

    public void setGrupoControleEstoque(NFDetGrupoControleEstoqueImobilizacao grupoControleEstoque) {
        this.grupoControleEstoque = grupoControleEstoque;
    }

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        DFIntegerValidador.tamanho1a3(numeroItem, "Número do Item do Documento Fiscal");
        this.numeroItem = numeroItem;
    }
}

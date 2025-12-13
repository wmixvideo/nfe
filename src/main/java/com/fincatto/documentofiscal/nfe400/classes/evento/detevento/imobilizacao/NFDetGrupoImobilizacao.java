package com.fincatto.documentofiscal.nfe400.classes.evento.detevento.imobilizacao;

import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.AbstractNFDetGrupoItem;
import org.simpleframework.xml.Element;

public class NFDetGrupoImobilizacao extends AbstractNFDetGrupoItem {

    @Element(name = "gControleEstoque")
    private NFDetGrupoControleEstoqueImobilizacao grupoControleEstoque;

    public NFDetGrupoControleEstoqueImobilizacao getGrupoControleEstoque() {
        return grupoControleEstoque;
    }

    public void setGrupoControleEstoque(NFDetGrupoControleEstoqueImobilizacao grupoControleEstoque) {
        this.grupoControleEstoque = grupoControleEstoque;
    }
}

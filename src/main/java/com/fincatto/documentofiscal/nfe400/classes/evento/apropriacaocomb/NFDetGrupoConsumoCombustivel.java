package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocomb;

import com.fincatto.documentofiscal.nfe400.classes.evento.AbstractNFDetGrupoItem;
import org.simpleframework.xml.Element;

public class NFDetGrupoConsumoCombustivel extends AbstractNFDetGrupoItem {

    @Element(name = "gControleEstoque")
    private NFDetGrupoControleEstoque grupoControleEstoque;

    public NFDetGrupoControleEstoque getGrupoControleEstoque() {
        return grupoControleEstoque;
    }

    public void setGrupoControleEstoque(NFDetGrupoControleEstoque grupoControleEstoque) {
        this.grupoControleEstoque = grupoControleEstoque;
    }
}

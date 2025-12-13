package com.fincatto.documentofiscal.nfe400.classes.evento.detevento.apropriacaocomb;

import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.AbstractNFDetGrupoItem;
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

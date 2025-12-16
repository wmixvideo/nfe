package com.fincatto.documentofiscal.nfe400.classes.evento.alczfmimportacao;

import com.fincatto.documentofiscal.nfe400.classes.evento.AbstractNFDetGrupoItem;
import org.simpleframework.xml.Element;

public class NFDetGrupoConsumoZFM extends AbstractNFDetGrupoItem {

    @Element(name = "gControleEstoque")
    private NFDetGrupoControleEstoqueZFM grupoControleEstoque;

    public NFDetGrupoControleEstoqueZFM getGrupoControleEstoque() {
        return grupoControleEstoque;
    }

    public void setGrupoControleEstoque(NFDetGrupoControleEstoqueZFM grupoControleEstoque) {
        this.grupoControleEstoque = grupoControleEstoque;
    }
}

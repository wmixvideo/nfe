package com.fincatto.documentofiscal.nfe400.classes.evento.detevento.alczfmimportacao.imobilizacao;

import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.AbstractNFDetGrupoItem;
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

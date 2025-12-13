package com.fincatto.documentofiscal.nfe400.classes.evento.detevento.roubo;

import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.AbstractNFDetGrupoItem;
import org.simpleframework.xml.Element;

public class NFDetGrupoPerecimento extends AbstractNFDetGrupoItem {

    @Element(name = "gControleEstoque")
    private NFDetGrupoControleEstoquePerecimento grupoControleEstoquePerecimento;

    public NFDetGrupoControleEstoquePerecimento getGrupoControleEstoquePerecimento() {
        return grupoControleEstoquePerecimento;
    }

    public void setGrupoControleEstoquePerecimento(NFDetGrupoControleEstoquePerecimento grupoControleEstoquePerecimento) {
        this.grupoControleEstoquePerecimento = grupoControleEstoquePerecimento;
    }
}

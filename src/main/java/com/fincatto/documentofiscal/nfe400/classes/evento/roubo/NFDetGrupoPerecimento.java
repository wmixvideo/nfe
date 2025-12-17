package com.fincatto.documentofiscal.nfe400.classes.evento.roubo;

import com.fincatto.documentofiscal.nfe400.classes.evento.AbstractNFDetGrupoItem;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "gPerecimento")
public class NFDetGrupoPerecimento extends AbstractNFDetGrupoItem {

    @Attribute(name = "nitem")
    private Integer numeroItem;

    @Element(name = "gControleEstoque")
    private NFDetGrupoControleEstoquePerecimento grupoControleEstoquePerecimento;

    public NFDetGrupoControleEstoquePerecimento getGrupoControleEstoquePerecimento() {
        return grupoControleEstoquePerecimento;
    }

    public void setGrupoControleEstoquePerecimento(NFDetGrupoControleEstoquePerecimento grupoControleEstoquePerecimento) {
        this.grupoControleEstoquePerecimento = grupoControleEstoquePerecimento;
    }

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        DFIntegerValidador.tamanho1a3(numeroItem, "Número do Item do Documento Fiscal");
        this.numeroItem = numeroItem;
    }
}

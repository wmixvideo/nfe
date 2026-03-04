package com.fincatto.documentofiscal.nfe400.classes.evento.apropriacaocomb;

import com.fincatto.documentofiscal.nfe400.classes.evento.AbstractNFDetGrupoItem;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "gConsumoComb")
public class NFDetGrupoConsumoCombustivel extends AbstractNFDetGrupoItem {

    @Attribute(name = "nItem")
    private Integer numeroItem;

    @Element(name = "gControleEstoque")
    private NFDetGrupoControleEstoque grupoControleEstoque;

    public NFDetGrupoControleEstoque getGrupoControleEstoque() {
        return grupoControleEstoque;
    }

    public void setGrupoControleEstoque(NFDetGrupoControleEstoque grupoControleEstoque) {
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

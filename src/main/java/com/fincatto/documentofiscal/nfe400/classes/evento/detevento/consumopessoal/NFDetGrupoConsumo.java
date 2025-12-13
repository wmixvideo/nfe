package com.fincatto.documentofiscal.nfe400.classes.evento.detevento.consumopessoal;

import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.AbstractNFDetGrupoItem;
import org.simpleframework.xml.Element;

public class NFDetGrupoConsumo extends AbstractNFDetGrupoItem {

    @Element(name = "gControleEstoque")
    private NFDetGrupoControleEstoqueConsumo controleEstoque;

    @Element(name = "DFeReferenciado")
    private NFDetGrupoDfeReferenciado dfeReferenciado;

    public NFDetGrupoControleEstoqueConsumo getControleEstoque() {
        return controleEstoque;
    }

    public void setControleEstoque(NFDetGrupoControleEstoqueConsumo controleEstoque) {
        this.controleEstoque = controleEstoque;
    }

    public NFDetGrupoDfeReferenciado getDfeReferenciado() {
        return dfeReferenciado;
    }

    public void setDfeReferenciado(NFDetGrupoDfeReferenciado dfeReferenciado) {
        this.dfeReferenciado = dfeReferenciado;
    }
}

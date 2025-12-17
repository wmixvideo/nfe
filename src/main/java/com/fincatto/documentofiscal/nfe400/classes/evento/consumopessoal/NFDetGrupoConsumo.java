package com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal;

import com.fincatto.documentofiscal.nfe400.classes.evento.AbstractNFDetGrupoItem;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "gConsumo")
public class NFDetGrupoConsumo extends AbstractNFDetGrupoItem {

    @Attribute(name = "nItem")
    private Integer numeroItem;

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

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        DFIntegerValidador.tamanho1a3(numeroItem, "Número do Item do Documento Fiscal");
        this.numeroItem = numeroItem;
    }
}

package com.fincatto.documentofiscal.nfe400.classes.evento.consumopessoal;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.evento.AbstractNFDetGrupoItem;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "gConsumo")
public class NFDetGrupoConsumo extends DFBase {

    @Attribute(name = "nItem")
    private Integer numeroItem;

    @Element(name = "vIBS")
    private String valorIBS;

    @Element(name = "vCBS")
    private String valorCBS;

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

    public String getValorCBS() {
        return valorCBS;
    }

    public void setValorCBS(BigDecimal valorCBS) {
        this.valorCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorCBS, "Valor CBS");
    }

    public String getValorIBS() {
        return valorIBS;
    }

    public void setValorIBS(BigDecimal valorIBS) {
        this.valorIBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorIBS, "Valor IBS");
    }
}

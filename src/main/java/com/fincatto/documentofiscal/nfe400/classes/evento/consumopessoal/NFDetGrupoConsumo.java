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

    @Element(name = "vCBS")
    private BigDecimal valorCBS;

    @Element(name = "vIBS")
    private BigDecimal valorIBS;

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

    public BigDecimal getValorCBS() {
        return valorCBS;
    }

    public void setValorCBS(BigDecimal valorCBS) {
        DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorCBS, "Valor CBS");
        this.valorCBS = valorCBS;
    }

    public BigDecimal getValorIBS() {
        return valorIBS;
    }

    public void setValorIBS(BigDecimal valorIBS) {
        DFBigDecimalValidador.tamanho13Com2CasasDecimais(valorIBS, "Valor IBS");
        this.valorIBS = valorIBS;
    }
}

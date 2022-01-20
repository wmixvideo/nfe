package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class NFNotaInfoItem extends DFBase {
    private static final long serialVersionUID = 362646693945373643L;
    
    @Attribute(name = "nItem")
    private Integer numeroItem;
    
    @Element(name = "prod")
    private NFNotaInfoItemProduto produto;
    
    @Element(name = "imposto")
    private NFNotaInfoItemImposto imposto;

    @Element(name = "impostoDevol", required = false)
    private NFImpostoDevolvido impostoDevolvido;

    @Element(name = "infAdProd", required = false)
    private String informacoesAdicionais;

    @ElementList(entry = "obsCont", inline = true, required = false)
    private List<NFNotaInfoObservacao> observacoesContribuinte;

    @ElementList(entry = "obsFisco", inline = true, required = false)
    private List<NFNotaInfoObservacao> observacoesFisco;

    public void setNumeroItem(final Integer numeroItem) {
        DFIntegerValidador.tamanho3maximo990(numeroItem, "Numero do Item");
        this.numeroItem = numeroItem;
    }

    public void setInformacoesAdicionais(final String informacoesAdicionais) {
        DFStringValidador.tamanho500(informacoesAdicionais, "Informacoes Adicionais do Item");
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public void setProduto(final NFNotaInfoItemProduto produto) {
        this.produto = produto;
    }

    public void setImposto(final NFNotaInfoItemImposto imposto) {
        this.imposto = imposto;
    }

    public void setObservacoesContribuinte(List<NFNotaInfoObservacao> observacoesContribuinte) {
        this.observacoesContribuinte = observacoesContribuinte;
    }

    public void setObservacoesFisco(List<NFNotaInfoObservacao> observacoesFisco) {
        this.observacoesFisco = observacoesFisco;
    }

    public Integer getNumeroItem() {
        return this.numeroItem;
    }

    public NFNotaInfoItemProduto getProduto() {
        return this.produto;
    }

    public NFNotaInfoItemImposto getImposto() {
        return this.imposto;
    }

    public String getInformacoesAdicionais() {
        return this.informacoesAdicionais;
    }

    public NFImpostoDevolvido getImpostoDevolvido() {
        return this.impostoDevolvido;
    }

    public List<NFNotaInfoObservacao> getObservacoesContribuinte() {
        return observacoesContribuinte;
    }

    public List<NFNotaInfoObservacao> getObservacoesFisco() {
        return observacoesFisco;
    }

    public void setImpostoDevolvido(final NFImpostoDevolvido impostoDevolvido) {
        this.impostoDevolvido = impostoDevolvido;
    }
}
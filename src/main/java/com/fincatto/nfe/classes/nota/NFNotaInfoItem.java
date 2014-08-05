package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.IntegerValidador;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoItem extends NFBase {

    @Attribute(name = "nItem", required = true)
    private Integer numeroItem;

    @Element(name = "infAdProd", required = false)
    private String informacoesAdicionais;

    @Element(name = "prod", required = true)
    private NFNotaInfoItemProduto produto;

    @Element(name = "imposto", required = true)
    private NFNotaInfoItemImposto imposto;

    public void setNumeroItem(final Integer numeroItem) {
        IntegerValidador.tamanho3maximo990(numeroItem);
        this.numeroItem = numeroItem;
    }

    public void setInformacoesAdicionais(final String informacoesAdicionais) {
        StringValidador.tamanho500(informacoesAdicionais);
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public void setProduto(final NFNotaInfoItemProduto produto) {
        this.produto = produto;
    }

    public void setImposto(final NFNotaInfoItemImposto imposto) {
        this.imposto = imposto;
    }
}
package com.fincatto.documentofiscal.cte200.classes.cte;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.fincatto.documentofiscal.DFBase;

public class CTInfoCarga extends DFBase {
    private static final long serialVersionUID = -3650773992643903547L;

    @Element(name = "vCarga", required = true)
    private String valorTotalCarga;

    @Element(name = "proPred")
    private String descricaoProdutoPredominante;

    @Element(name = "xOutCat", required = false)
    private String descricaoOutrasCaracteristicas;

    @ElementList(name = "infQ", inline = true)
    private List<CTInfoCargaQuantidade> informacoesQuantidade;

    public String getValorTotalCarga() {
        return this.valorTotalCarga;
    }

    public void setValorTotalCarga(final String valorTotalCarga) {
        this.valorTotalCarga = valorTotalCarga;
    }

    public String getDescricaoProdutoPredominante() {
        return this.descricaoProdutoPredominante;
    }

    public void setDescricaoProdutoPredominante(final String descricaoProdutoPredominante) {
        this.descricaoProdutoPredominante = descricaoProdutoPredominante;
    }

    public String getDescricaoOutrasCaracteristicas() {
        return this.descricaoOutrasCaracteristicas;
    }

    public void setDescricaoOutrasCaracteristicas(final String descricaoOutrasCaracteristicas) {
        this.descricaoOutrasCaracteristicas = descricaoOutrasCaracteristicas;
    }

    public List<CTInfoCargaQuantidade> getInformacoesQuantidade() {
        return this.informacoesQuantidade;
    }

    public void setInformacoesQuantidade(final List<CTInfoCargaQuantidade> informacoesQuantidade) {
        this.informacoesQuantidade = informacoesQuantidade;
    }

}

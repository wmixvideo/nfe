package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import org.simpleframework.xml.Element;

public class NFNotaInfoItemProdutoDetalhamentoEmbalagem extends DFBase {
    private static final long serialVersionUID = 4756407184060968887L;
    
    @Element(name = "xEmb")
    private String embalagemProduto;
    
    @Element(name = "qVolEmb")
    private String volumeProdutoEmbalagem;

    @Element(name = "uEmb")
    private String unidadeMedidaEmbalagem;

    public String getEmbalagemProduto() {
        return embalagemProduto;
    }

    public void setEmbalagemProduto(String embalagemProduto) {
        this.embalagemProduto = embalagemProduto;
    }

    public String getVolumeProdutoEmbalagem() {
        return volumeProdutoEmbalagem;
    }

    public void setVolumeProdutoEmbalagem(String volumeProdutoEmbalagem) {
        this.volumeProdutoEmbalagem = volumeProdutoEmbalagem;
    }

    public String getUnidadeMedidaEmbalagem() {
        return unidadeMedidaEmbalagem;
    }

    public void setUnidadeMedidaEmbalagem(String unidadeMedidaEmbalagem) {
        this.unidadeMedidaEmbalagem = unidadeMedidaEmbalagem;
    }
}
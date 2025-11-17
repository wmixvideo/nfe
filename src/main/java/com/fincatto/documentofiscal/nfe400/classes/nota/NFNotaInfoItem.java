package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import com.fincatto.documentofiscal.validadores.DFIntegerValidador;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

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

  @Element(name = "obsItem", required = false)
  private NFNotaInfoItemObservacao itemObservacao;

  @Element(name = "vItem", required = false)
  private String vItem; // VB01

  @Element(name = "DFeReferenciado", required = false)
  private NFNotaInfoDFeReferenciado dfeReferenciado; // VC01

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

  public void setImpostoDevolvido(final NFImpostoDevolvido impostoDevolvido) {
    this.impostoDevolvido = impostoDevolvido;
  }

  public NFNotaInfoItemObservacao getItemObservacao() {
    return itemObservacao;
  }

  public void setItemObservacao(
      final NFNotaInfoItemObservacao itemObservacao) {
    this.itemObservacao = itemObservacao;
  }

  public String getVItem() {
    return vItem;
  }

  public void setVItem(BigDecimal vItem) {
    this.vItem = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vItem, "Valor do Item do DFe Referenciado");
  }

  public NFNotaInfoDFeReferenciado getDFeReferenciado() {
    return dfeReferenciado;
  }

  public void setDFeReferenciado(NFNotaInfoDFeReferenciado dFeReferenciado) {
    this.dfeReferenciado = dFeReferenciado;
  }

}

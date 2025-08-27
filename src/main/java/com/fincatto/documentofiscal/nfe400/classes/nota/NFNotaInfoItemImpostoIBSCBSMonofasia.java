package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

/**
 * UB84
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoItemImpostoIBSCBSMonofasia extends DFBase {

  private static final long serialVersionUID = -366528394939416671L;

  // UB84a -x- Sequência XML
  @Element(required = false)
  private String qBCMono; // UB85

  @Element(required = false)
  private String adRemIBS; // UB86

  @Element(required = false)
  private String adRemCBS; // UB87

  @Element(required = false)
  private String vIBSMono; // UB88

  @Element(required = false)
  private String vCBSMono; // UB89

  // UB90 -x- Sequência XML
  @Element(required = false)
  private String qBCMonoReten; // UB91

  @Element(required = false)
  private String adRemIBSReten; // UB92

  @Element(required = false)
  private String vIBSMonoReten; // UB93

  @Element(required = false)
  private String adRemCBSReten; // UB93a

  @Element(required = false)
  private String vCBSMonoReten; // UB93b

  // UB94 -x- Sequência XML
  @Element(required = false)
  private String qBCMonoRet; // UB95

  @Element(required = false)
  private String adRemIBSRet; // UB96

  @Element(required = false)
  private String vIBSMonoRet; // UB97

  @Element(required = false)
  private String adRemCBSRet; // UB98

  @Element(required = false)
  private String vCBSMonoRet; // UB98a

  // UB99 -x- Sequência XML
  @Element(required = false)
  private String pDifIBS; // UB100

  @Element(required = false)
  private String vIBSMonoDif; // UB101

  @Element(required = false)
  private String pDifCBS; // UB102

  @Element(required = false)
  private String vCBSMonoDif; // UB103

  // UB84 -x- Sequência XML
  @Element(required = true)
  private String vTotIBSMonoItem; // UB104

  @Element(required = true)
  private String vTotCBSMonoItem; // UB105

  public String getQBCMono() {
    return qBCMono;
  }

  public void setQBCMono(BigDecimal qBCMono) {
    this.qBCMono = DFBigDecimalValidador.tamanho11Com4CasasDecimais(qBCMono, "Quantidade tributada na monofasia");
  }

  public String getAdRemIBS() {
    return adRemIBS;
  }

  public void setAdRemIBS(BigDecimal adRemIBS) {
    this.adRemIBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemIBS, "Alíquota ad rem do IBS");
  }

  public String getAdRemCBS() {
    return adRemCBS;
  }

  public void setAdRemCBS(BigDecimal adRemCBS) {
    this.adRemCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemCBS, "Alíquota ad rem da CBS");
  }

  public String getVIBSMono() {
    return vIBSMono;
  }

  public void setVIBSMono(BigDecimal vIBSMono) {
    this.vIBSMono = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMono, "Valor do IBS monofásico");
  }

  public String getVCBSMono() {
    return vCBSMono;
  }

  public void setVCBSMono(BigDecimal vCBSMono) {
    this.vCBSMono = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBSMono, "Valor da CBS monofásica");
  }

  public String getqBCMonoReten() {
    return qBCMonoReten;
  }

  public void setqBCMonoReten(BigDecimal qBCMonoReten) {
    this.qBCMonoReten = DFBigDecimalValidador.tamanho11Com4CasasDecimais(qBCMonoReten, "Quantidade tributada sujeita à retenção na monofasia");
  }

  public String getAdRemIBSReten() {
    return adRemIBSReten;
  }

  public void setAdRemIBSReten(BigDecimal adRemIBSReten) {
    this.adRemIBSReten = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemIBSReten, "Alíquota ad rem do IBS sujeito a retenção");
  }

  public String getVIBSMonoReten() {
    return vIBSMonoReten;
  }

  public void setVIBSMonoReten(BigDecimal vIBSMonoReten) {
    this.vIBSMonoReten = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMonoReten, "Valor do IBS monofásico sujeito a retenção");
  }

  public String getAdRemCBSReten() {
    return adRemCBSReten;
  }

  public void setAdRemCBSReten(BigDecimal adRemCBSReten) {
    this.adRemCBSReten = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemCBSReten, "Alíquota ad rem da CBS sujeito a retenção");
  }

  public String getVCBSMonoReten() {
    return vCBSMonoReten;
  }

  public void setVCBSMonoReten(BigDecimal vCBSMonoReten) {
    this.vCBSMonoReten = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBSMonoReten, "Valor da CBS monofásica sujeita a retenção");
  }

  public String getqBCMonoRet() {
    return qBCMonoRet;
  }

  public void setqBCMonoRet(BigDecimal qBCMonoRet) {
    this.qBCMonoRet = DFBigDecimalValidador.tamanho11Com4CasasDecimais(qBCMonoRet, "Quantidade tributada retida anteriormente");
  }

  public String getAdRemIBSRet() {
    return adRemIBSRet;
  }

  public void setAdRemIBSRet(BigDecimal adRemIBSRet) {
    this.adRemIBSRet = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemIBSRet, "Alíquota ad rem do IBS retido anteriormente");
  }

  public String getVIBSMonoRet() {
    return vIBSMonoRet;
  }

  public void setVIBSMonoRet(BigDecimal vIBSMonoRet) {
    this.vIBSMonoRet = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMonoRet, "Valor do IBS retido anteriormente");
  }

  public String getAdRemCBSRet() {
    return adRemCBSRet;
  }

  public void setAdRemCBSRet(BigDecimal adRemCBSRet) {
    this.adRemCBSRet = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(adRemCBSRet, "Alíquota ad rem da CBS retida anteriormente");
  }

  public String getVCBSMonoRet() {
    return vCBSMonoRet;
  }

  public void setVCBSMonoRet(BigDecimal vCBSMonoRet) {
    this.vCBSMonoRet = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBSMonoRet, "Valor da CBS retida anteriormente");
  }

  public String getPDifIBS() {
    return pDifIBS;
  }

  public void setPDifIBS(BigDecimal pDifIBS) {
    this.pDifIBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pDifIBS, "Percentual do diferimento do imposto monofásico");
  }

  public String getVIBSMonoDif() {
    return vIBSMonoDif;
  }

  public void setVIBSMonoDif(BigDecimal vIBSMonoDif) {
    this.vIBSMonoDif = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSMonoDif, "Valor do IBS monofásico diferido");
  }

  public String getPDifCBS() {
    return pDifCBS;
  }

  public void setPDifCBS(BigDecimal pDifCBS) {
    this.pDifCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pDifCBS, "Percentual do diferimento do imposto monofásico");
  }

  public String getVCBSMonoDif() {
    return vCBSMonoDif;
  }

  public void setVCBSMonoDif(BigDecimal vCBSMonoDif) {
    this.vCBSMonoDif = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBSMonoDif, "Valor da CBS Monofásica diferida");
  }

  public String getVTotIBSMonoItem() {
    return vTotIBSMonoItem;
  }

  public void setVTotIBSMonoItem(BigDecimal vTotIBSMonoItem) {
    this.vTotIBSMonoItem = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTotIBSMonoItem, "Total de IBS Monofásico");
  }

  public String getVTotCBSMonoItem() {
    return vTotCBSMonoItem;
  }

  public void setVTotCBSMonoItem(BigDecimal vTotCBSMonoItem) {
    this.vTotCBSMonoItem = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTotCBSMonoItem, "Total da CBS Monofásica");
  }

}

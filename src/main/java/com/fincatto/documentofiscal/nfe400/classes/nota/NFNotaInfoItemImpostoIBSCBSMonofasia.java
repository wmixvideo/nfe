package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

/**
 * UB84
 *
 * @author Edivaldo Merlo Stens
 * @author Ommega Data
 */
@Order(elements = {"gMonoPadrao", "gMonoReten", "gMonoRet", "gMonoDif", "gIBSMonoAdRem", "gIBSMonoAdValorem", "gCBSMonoAdRem", "gCBSMonoAdValorem", "vTotIBSMonoItem", "vTotCBSMonoItem"})
public class NFNotaInfoItemImpostoIBSCBSMonofasia extends DFBase {

  private static final long serialVersionUID = -366528394939416671L;

  @Deprecated(since = "2025.002-RTC-1.5", forRemoval = true)
  @Element(required = false)
  private NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao gMonoPadrao; // UB84a

  @Deprecated(since = "2025.002-RTC-1.5", forRemoval = true)
  @Element(required = false)
  private NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten gMonoReten; // UB90

  @Deprecated(since = "2025.002-RTC-1.5", forRemoval = true)
  @Element(required = false)
  private NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet gMonoRet; // UB94

  @Element(required = false)
  private NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif gMonoDif; // UB99

  @Element(name = "gIBSMonoAdRem", required = false)
  private NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem gIBSMonoAdRem; // UB85a

  @Element(name = "gIBSMonoAdValorem", required = false)
  private NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem gIBSMonoAdValorem; // UB90

  @Element(name = "gCBSMonoAdRem", required = false)
  private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem gCBSMonoAdRem; // UB95a

  @Element(name = "gCBSMonoAdValorem", required = false)
  private NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem gCBSMonoAdValorem; // UB100

  // UB84 -x- Sequência XML
  @Element(name = "vTotIBSMonoItem", required = true)
  private String vTotIBSMonoItem; // UB105a

  @Element(name = "vTotCBSMonoItem", required = true)
  private String vTotCBSMonoItem; // UB105b

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem getGIBSMonoAdRem() {
    return gIBSMonoAdRem;
  }

  public void setGIBSMonoAdRem(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem gIBSMonoAdRem) {
    if (gIBSMonoAdRem != null && this.gIBSMonoAdValorem != null) {
      throw new IllegalStateException("Ja possui grupo IBS monofasico ad valorem selecionado");
    }
    this.gIBSMonoAdRem = gIBSMonoAdRem;
  }

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem getGIBSMonoAdValorem() {
    return gIBSMonoAdValorem;
  }

  public void setGIBSMonoAdValorem(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem gIBSMonoAdValorem) {
    if (gIBSMonoAdValorem != null && this.gIBSMonoAdRem != null) {
      throw new IllegalStateException("Ja possui grupo IBS monofasico ad rem selecionado");
    }
    this.gIBSMonoAdValorem = gIBSMonoAdValorem;
  }

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem getGCBSMonoAdRem() {
    return gCBSMonoAdRem;
  }

  public void setGCBSMonoAdRem(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem gCBSMonoAdRem) {
    if (gCBSMonoAdRem != null && this.gCBSMonoAdValorem != null) {
      throw new IllegalStateException("Ja possui grupo CBS monofasico ad valorem selecionado");
    }
    this.gCBSMonoAdRem = gCBSMonoAdRem;
  }

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem getGCBSMonoAdValorem() {
    return gCBSMonoAdValorem;
  }

  public void setGCBSMonoAdValorem(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem gCBSMonoAdValorem) {
    if (gCBSMonoAdValorem != null && this.gCBSMonoAdRem != null) {
      throw new IllegalStateException("Ja possui grupo CBS monofasico ad rem selecionado");
    }
    this.gCBSMonoAdValorem = gCBSMonoAdValorem;
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

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao getgMonoPadrao() {
    return gMonoPadrao;
  }

  public void setgMonoPadrao(NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoPadrao gMonoPadrao) {
    this.gMonoPadrao = gMonoPadrao;
  }

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten getgMonoReten() {
    return gMonoReten;
  }

  public void setgMonoReten(NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoReten gMonoReten) {
    this.gMonoReten = gMonoReten;
  }

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet getgMonoRet() {
    return gMonoRet;
  }

  public void setgMonoRet(NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoRet gMonoRet) {
    this.gMonoRet = gMonoRet;
  }

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif getgMonoDif() {
    return gMonoDif;
  }

  public void setgMonoDif(NFNotaInfoItemImpostoIBSCBSMonofasicaGMonoDif gMonoDif) {
    this.gMonoDif = gMonoDif;
  }

}

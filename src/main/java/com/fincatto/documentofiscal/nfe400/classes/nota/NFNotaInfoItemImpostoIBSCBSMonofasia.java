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
@Order(elements = {"gIBSMonoAdRem", "gIBSMonoAdValorem", "gCBSMonoAdRem", "gCBSMonoAdValorem", "vTotIBSMonoItem", "vTotCBSMonoItem"})
public class NFNotaInfoItemImpostoIBSCBSMonofasia extends DFBase {

  private static final long serialVersionUID = -366528394939416671L;

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
}

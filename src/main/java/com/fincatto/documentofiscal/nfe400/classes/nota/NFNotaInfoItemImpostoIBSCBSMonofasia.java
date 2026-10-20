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

  private boolean isSelecionadoIBS = false;
  private boolean isSelecionadoCBS = false;

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

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem getgIBSMonoAdRem() {
    return gIBSMonoAdRem;
  }

  public void setgIBSMonoAdRem(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem gIBSMonoAdRem) {
    this.validaApenasUmIBSSelecionado();
    this.gIBSMonoAdRem = gIBSMonoAdRem;
  }

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem getgIBSMonoAdValorem() {
    return gIBSMonoAdValorem;
  }

  public void setgIBSMonoAdValorem(NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem gIBSMonoAdValorem) {
    this.validaApenasUmIBSSelecionado();
    this.gIBSMonoAdValorem = gIBSMonoAdValorem;
  }

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem getgCBSMonoAdRem() {
    return gCBSMonoAdRem;
  }

  public void setgCBSMonoAdRem(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem gCBSMonoAdRem) {
    this.validaApenasUmCBSSelecionado();
    this.gCBSMonoAdRem = gCBSMonoAdRem;
  }

  public NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem getgCBSMonoAdValorem() {
    return gCBSMonoAdValorem;
  }

  public void setgCBSMonoAdValorem(NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem gCBSMonoAdValorem) {
    this.validaApenasUmCBSSelecionado();
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

  private void validaApenasUmIBSSelecionado() {
    if (this.isSelecionadoIBS) {
      throw new IllegalStateException("Ja possui IBS selecionado");
    }
    this.isSelecionadoIBS = true;
  }

  private void validaApenasUmCBSSelecionado() {
    if (this.isSelecionadoCBS) {
      throw new IllegalStateException("Ja possui CBS selecionado");
    }
    this.isSelecionadoCBS = true;
  }
}

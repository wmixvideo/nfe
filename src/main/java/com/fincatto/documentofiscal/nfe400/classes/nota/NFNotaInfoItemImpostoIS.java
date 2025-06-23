package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIS;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

/**
 * UB01
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoItemImpostoIS extends DFBase {

  private static final long serialVersionUID = -366528394939416671L;

  @Element(name = "CSTIS", required = true)
  private NFNotaInfoImpostoTributacaoIS cstIS; // UB02

  @Element(name = "cClassTribIS", required = true)
  private String cClassTribIS; // UB03

  // UB04 -x- Sequência XML 0-1
  @Element(required = false)
  private String vBCIS; // UB05

  @Element(required = false)
  private String pIS; // UB06

  @Element(required = false)
  private String pISEspec; // UB07

  // UB08 -x- Sequência XML 0-1
  @Element(required = false)
  private String uTrib; // UB09

  @Element(required = false)
  private String qTrib; // UB10

  @Element(required = false)
  private String vIS; // UB11

  public NFNotaInfoImpostoTributacaoIS getCstIS() {
    return cstIS;
  }

  public void setCstIS(NFNotaInfoImpostoTributacaoIS cstIS) {
    this.cstIS = cstIS;
  }

  public String getCClassTribIS() {
    return cClassTribIS;
  }

  public void setCClassTribIS(String cClassTribIS) {
    this.cClassTribIS = cClassTribIS;
  }

  public String getVBCIS() {
    return vBCIS;
  }

  public void getVBCIS(BigDecimal vBCIS) {
    this.vBCIS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vBCIS, "Valor da Base de Cálculo do Imposto Seletivo");
  }

  public String getPIS() {
    return pIS;
  }

  public void setPIS(BigDecimal pIS) {
    this.pIS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pIS, "Alíquota do Imposto Seletivo");
  }

  public String getPISEspec() {
    return pISEspec;
  }

  public void setPISEspec(BigDecimal pISEspec) {
    this.pISEspec = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pISEspec, "Alíquota específica por unidade de medida apropriada");
  }

  public String getuTrib() {
    return uTrib;
  }

  public void setuTrib(String uTrib) {
    this.uTrib = uTrib;
  }

  public String getQTrib() {
    return qTrib;
  }

  public void setQTrib(BigDecimal qTrib) {
    this.qTrib = DFBigDecimalValidador.tamanho11Com4CasasDecimais(qTrib, "Quantidade Tributável");
  }

  public String getVIS() {
    return vIS;
  }

  public void getVIS(BigDecimal vIS) {
    this.vIS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIS, "Valor do Imposto Seletivo");
  }

}

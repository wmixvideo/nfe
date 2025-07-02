package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * 15/06/2025
 *
 * @author Edivaldo Merlo Stens
 */
@Root(name = "TTribRegular")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeTTribRegular extends DFBase {

  private static final long serialVersionUID = -3330020091021942368L;

  @Element(name = "CSTReg", required = true)
  private String cstReg;

  @Element(required = true)
  private String cClassTribReg;

  @Element(required = true)
  private String pAliqEfetRegIBSUF;

  @Element(required = true)
  private String vTribRegIBSUF;

  @Element(required = true)
  private String pAliqEfetRegIBSMun;

  @Element(required = true)
  private String vTribRegIBSMun;

  @Element(required = true)
  private String pAliqEfetRegCBS;

  @Element(required = true)
  private String vTribRegCBS;

  public String getCSTReg() {
    return cstReg;
  }

  public void setCSTReg(String cstReg) {
    this.cstReg = cstReg;
  }

  public String getCClassTribReg() {
    return cClassTribReg;
  }

  public void setCClassTribReg(String cClassTribReg) {
    this.cClassTribReg = cClassTribReg;
  }

  public String getPAliqEfetRegIBSUF() {
    return pAliqEfetRegIBSUF;
  }

  public void setPAliqEfetRegIBSUF(BigDecimal pAliqEfetRegIBSUF) {
    this.pAliqEfetRegIBSUF = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqEfetRegIBSUF, "Alíquota efetiva da UF Informado a Alíquota caso não cumprida a condição resolutória/suspensiva");
  }

  public String getVTribRegIBSUF() {
    return vTribRegIBSUF;
  }

  public void setVTribRegIBSUF(BigDecimal vTribRegIBSUF) {
    this.vTribRegIBSUF = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTribRegIBSUF, "Informado como seria o valor do Tributo da UF caso não cumprida a condição resolutória/suspensiva");
  }

  public String getPAliqEfetRegIBSMun() {
    return pAliqEfetRegIBSMun;
  }

  public void setPAliqEfetRegIBSMun(BigDecimal pAliqEfetRegIBSMun) {
    this.pAliqEfetRegIBSMun = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqEfetRegIBSMun, "Alíquota efetiva do Município Informado a Alíquota caso não cumprida a condição resolutória/suspensiva");
  }

  public String getVTribRegIBSMun() {
    return vTribRegIBSMun;
  }

  public void setVTribRegIBSMun(BigDecimal vTribRegIBSMun) {
    this.vTribRegIBSMun = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTribRegIBSMun, "Informado como seria o valor do Tributo do Município caso não cumprida a condição resolutória/suspensiva");
  }

  public String getPAliqEfetRegCBS() {
    return pAliqEfetRegCBS;
  }

  public void setPAliqEfetRegCBS(BigDecimal pAliqEfetRegCBS) {
    this.pAliqEfetRegCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqEfetRegCBS, "Alíquota efetiva da CBS Informado a Alíquota caso não cumprida a condição resolutória/suspensiva");
  }

  public String getVTribRegCBS() {
    return vTribRegCBS;
  }

  public void setVTribRegCBS(BigDecimal vTribRegCBS) {
    this.vTribRegCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTribRegCBS, "Informado como seria o valor do Tributo CBS caso não cumprida a condição resolutória/suspensiva");
  }

}

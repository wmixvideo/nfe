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
@Root(name = "TTribCompraGov")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeTTribCompraGov extends DFBase {

  private static final long serialVersionUID = -3330020091023450254L;

  @Element(required = true)
  private String pAliqIBSUF;

  @Element(required = true)
  private String vTribIBSUF;

  @Element(required = true)
  private String pAliqIBSMun;

  @Element(required = true)
  private String vTribIBSMun;

  @Element(required = true)
  private String pAliqCBS;

  @Element(required = true)
  private String vTribCBS;

  public String getPAliqIBSUF() {
    return pAliqIBSUF;
  }

  public void setPAliqIBSUF(BigDecimal pAliqIBSUF) {
    this.pAliqIBSUF = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqIBSUF, "Alíquota IBS da UF utilizada");
  }

  public String getVTribIBSUF() {
    return vTribIBSUF;
  }

  public void setVTribIBSUF(BigDecimal vTribIBSUF) {
    this.vTribIBSUF = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTribIBSUF, "Valor do Tributo do IBS da UF");
  }

  public String getPAliqIBSMun() {
    return pAliqIBSMun;
  }

  public void setPAliqIBSMun(BigDecimal pAliqIBSMun) {
    this.pAliqIBSMun = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqIBSMun, "Alíquota IBS do Município utilizada");
  }

  public String getVTribIBSMun() {
    return vTribIBSMun;
  }

  public void setVTribIBSMun(BigDecimal vTribIBSMun) {
    this.vTribIBSMun = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTribIBSMun, "Valor do Tributo do Município da UF");
  }

  public String getPAliqCBS() {
    return pAliqCBS;
  }

  public void setPAliqCBS(BigDecimal pAliqCBS) {
    this.pAliqCBS = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqCBS, "Alíquota IBS do CBS utilizada");
  }

  public String getVTribCBS() {
    return vTribCBS;
  }

  public void setVTribCBS(BigDecimal vTribCBS) {
    this.vTribCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vTribCBS, "Valor do Tributo da CBS");
  }

}

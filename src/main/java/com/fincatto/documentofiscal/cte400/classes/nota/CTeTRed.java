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
@Root(name = "TRed")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeTRed extends DFBase {

  private static final long serialVersionUID = -3330020091022569872L;

  @Element(required = true)
  private String pRedAliq;

  @Element(required = true)
  private String pAliqEfet;

  public String getPRedAliq() {
    return pRedAliq;
  }

  public void setPRedAliq(BigDecimal pRedAliq) {
    this.pRedAliq = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pRedAliq, "Percentual da redução de Alíquota do cClassTrib");
  }

  public String getPAliqEfet() {
    return pAliqEfet;
  }

  public void setPAliqEfet(BigDecimal pAliqEfet) {
    this.pAliqEfet = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pAliqEfet, "Alíquota efetiva do IBS de competência das UF que será aplicada a base de cálculo");
  }

}

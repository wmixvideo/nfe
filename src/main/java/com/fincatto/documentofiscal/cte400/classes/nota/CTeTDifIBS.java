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
@Root(name = "TDifIBS")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeTDifIBS extends DFBase {

  private static final long serialVersionUID = -3330020091022569873L;

  @Element(required = true)
  private String pDif;

  @Element(required = true)
  private String vDif;

  public String getPDif() {
    return pDif;
  }

  public void setPDif(BigDecimal pDif) {
    this.pDif = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pDif, "Percentual de diferimento");
  }

  public String getVDif() {
    return vDif;
  }

  public void setVDif(BigDecimal vDif) {
    this.vDif = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDif, "Calor do diferimento");
  }

}

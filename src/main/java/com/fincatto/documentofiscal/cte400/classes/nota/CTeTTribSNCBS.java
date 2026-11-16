package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * gCBSSN - Grupo de informacoes da composicao do valor da CBS para o Simples Nacional
 * (NT 2026.005, tipo TTribSN do DFeTiposBasicos_v1.00.xsd).
 */
@Root(name = "gCBSSN")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeTTribSNCBS extends DFBase {

  private static final long serialVersionUID = -2290381745612093475L;

  @Element(name = "pCBSSN")
  private String pCBSSN;

  @Element(name = "vCBSSN")
  private String vCBSSN;

  public String getPCBSSN() {
    return pCBSSN;
  }

  /**
   * Aliquota efetiva da CBS para os optantes do Simples Nacional (pCBSSN, 3v2-4).
   */
  public void setPCBSSN(final BigDecimal pCBSSN) {
    this.pCBSSN = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pCBSSN, "Aliquota efetiva da CBS para os optantes do Simples Nacional");
  }

  public String getVCBSSN() {
    return vCBSSN;
  }

  /**
   * Valor da CBS para os optantes do Simples Nacional (vCBSSN, 13v2).
   */
  public void setVCBSSN(final BigDecimal vCBSSN) {
    this.vCBSSN = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBSSN, "Valor da CBS para os optantes do Simples Nacional");
  }
}

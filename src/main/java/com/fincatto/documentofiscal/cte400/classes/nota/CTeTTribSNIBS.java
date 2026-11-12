package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * gIBSSN - Grupo de informacoes da composicao do valor do IBS para o Simples Nacional
 * (NT 2026.005, tipo TTribSN do DFeTiposBasicos_v1.00.xsd).
 */
@Root(name = "gIBSSN")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeTTribSNIBS extends DFBase {

  private static final long serialVersionUID = 4128576293017458112L;

  @Element(name = "pIBSSN")
  private String pIBSSN;

  @Element(name = "vIBSSN")
  private String vIBSSN;

  public String getPIBSSN() {
    return pIBSSN;
  }

  /**
   * Aliquota efetiva do IBS para os optantes do Simples Nacional (pIBSSN, 3v2-4).
   */
  public void setPIBSSN(final BigDecimal pIBSSN) {
    this.pIBSSN = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pIBSSN, "Aliquota efetiva do IBS para os optantes do Simples Nacional");
  }

  public String getVIBSSN() {
    return vIBSSN;
  }

  /**
   * Valor do IBS para os optantes do Simples Nacional (vIBSSN, 13v2).
   */
  public void setVIBSSN(final BigDecimal vIBSSN) {
    this.vIBSSN = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSSN, "Valor do IBS para os optantes do Simples Nacional");
  }
}

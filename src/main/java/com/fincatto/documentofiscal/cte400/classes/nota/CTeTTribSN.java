package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * gTribSN - Grupo de informacoes da composicao do valor do IBS e da CBS para o Simples Nacional
 * (NT 2026.005, tipo TTribSN do DFeTiposBasicos_v1.00.xsd).<br>
 * Filho do grupo IBSCBS. Os grupos gIBSSN e gCBSSN sao opcionais e devem ser informados conforme o CRT e o
 * tpRegimeIBSCBS do emitente.
 */
@Root(name = "gTribSN")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeTTribSN extends DFBase {

  private static final long serialVersionUID = 7561034928173640219L;

  @Element(name = "gIBSSN", required = false)
  private CTeTTribSNIBS gIBSSN;

  @Element(name = "gCBSSN", required = false)
  private CTeTTribSNCBS gCBSSN;

  public CTeTTribSNIBS getGIBSSN() {
    return gIBSSN;
  }

  /**
   * Grupo de informacoes da composicao do valor do IBS para o Simples Nacional (gIBSSN).
   */
  public void setGIBSSN(final CTeTTribSNIBS gIBSSN) {
    this.gIBSSN = gIBSSN;
  }

  public CTeTTribSNCBS getGCBSSN() {
    return gCBSSN;
  }

  /**
   * Grupo de informacoes da composicao do valor da CBS para o Simples Nacional (gCBSSN).
   */
  public void setGCBSSN(final CTeTTribSNCBS gCBSSN) {
    this.gCBSSN = gCBSSN;
  }
}

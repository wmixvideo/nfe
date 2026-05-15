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
@Root(name = "CTeTTribEstornoCred")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeTTribEstornoCred extends DFBase {

  private static final long serialVersionUID = -3330020091023450254L;

  @Element(required = true)
  private String vIBSEstCred;

  @Element(required = true)
  private String vCBSEstCred;

  public String getVIBSEstCred() {
    return vIBSEstCred;
  }

  public void setVIBSEstCred(BigDecimal vIBSEstCred) {
    this.vIBSEstCred = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBSEstCred, "Valor do IBS a ser estornado");
  }

  public String getvCBSEstCred() {
    return vCBSEstCred;
  }

  public void setVCBSEstCred(BigDecimal vCBSEstCred) {
    this.vCBSEstCred = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBSEstCred, "Valor do CBS a ser estornado");
  }

}

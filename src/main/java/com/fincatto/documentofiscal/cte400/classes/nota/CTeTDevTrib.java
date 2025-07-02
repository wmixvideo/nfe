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
@Root(name = "TDevTrib")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeTDevTrib extends DFBase {

  private static final long serialVersionUID = -3330020091022569858L;

  @Element(required = true)
  private String vDevTrib;

  public String getVDevTrib() {
    return vDevTrib;
  }

  public void setVDevTrib(BigDecimal vDevTrib) {
    this.vDevTrib = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vDevTrib, "Valor do tributo devolvido");
  }

}

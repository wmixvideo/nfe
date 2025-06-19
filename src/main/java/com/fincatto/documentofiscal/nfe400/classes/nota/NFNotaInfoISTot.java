package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

/**
 * W31
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoISTot extends DFBase {

  private static final long serialVersionUID = 1644701343314788458L;

  @Element(name = "vIS")
  private String vIS; // W33

  public String getVIS() {
    return vIS;
  }

  public void setVIS(BigDecimal vIS) {
    this.vIS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIS, "Valor Total do Imposto Seletivo");
  }

}

package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

/**
 * UB106
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoItemImpostoIBSCBSTransfCred extends DFBase {

  private static final long serialVersionUID = -366528394939245967L;

  @Element(required = true)
  private String vIBS; // UB107

  @Element(required = true)
  private String vCBS; // UB108

  public String getVIBS() {
    return vIBS;
  }

  public void setVIBS(BigDecimal vIBS) {
    this.vIBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vIBS, "Valor do IBS a ser transferido");
  }

  public String getVCBS() {
    return vCBS;
  }

  public void setVCBS(BigDecimal vCBS) {
    this.vCBS = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCBS, "Valor da CBS a ser transferida");
  }

}

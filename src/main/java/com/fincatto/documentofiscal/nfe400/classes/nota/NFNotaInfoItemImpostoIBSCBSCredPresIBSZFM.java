package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

/**
 * UB109
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoItemImpostoIBSCBSCredPresIBSZFM extends DFBase {

  private static final long serialVersionUID = -366528394939245967L;

  @Element(required = true)
  private String tpCredPresIBSZFM; // UB110

  @Element(required = false)
  private String vCredPresIBSZFM; // UB111

  public String getTpCredPresIBSZFM() {
    return tpCredPresIBSZFM;
  }

  public void setTpCredPresIBSZFM(String tpCredPresIBSZFM) {
    this.tpCredPresIBSZFM = tpCredPresIBSZFM;
  }

  public String getVCredPresIBSZFM() {
    return vCredPresIBSZFM;
  }

  public void setVCredPresIBSZFM(BigDecimal vCredPresIBSZFM) {
    this.vCredPresIBSZFM = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCredPresIBSZFM, "Valor do crédito presumido calculado sobre o saldo devedor apurado");
  }

}

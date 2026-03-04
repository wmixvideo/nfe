package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.simpleframework.xml.Element;

/**
 * UB109
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoItemImpostoIBSCBSCredPresIBSZFM extends DFBase {

  private static final long serialVersionUID = -366528394939245967L;

  /**
   * UB132 - Mês e ano de referência para apuração (AAAA-MM)
   */
  @Element(name = "competApur", required = true)
  private LocalDate anoMesReferenciaApuracao;

  @Element(required = true)
  private String tpCredPresIBSZFM; // UB133

  @Element(required = true)
  private String vCredPresIBSZFM; // UB134

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

  public LocalDate getAnoMesReferenciaApuracao() {
    return anoMesReferenciaApuracao;
  }

  public void setAnoMesReferenciaApuracao(LocalDate anoMesReferenciaApuracao) {
    this.anoMesReferenciaApuracao = anoMesReferenciaApuracao;
  }
}

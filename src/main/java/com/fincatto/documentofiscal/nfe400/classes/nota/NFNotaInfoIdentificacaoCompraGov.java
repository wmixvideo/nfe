package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.DFBigDecimalValidador;
import java.math.BigDecimal;
import org.simpleframework.xml.Element;

/**
 * // B31
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoIdentificacaoCompraGov extends DFBase {

  private static final long serialVersionUID = -2568396066960852196L;

  @Element(required = true)
  private String tpEnteGov; // B32

  @Element(required = true)
  private String pRedutor; // B33

  @Element(required = true)
  private String tpOperGov; // B34

  public String getTpEnteGov() {
    return tpEnteGov;
  }

  public void setTpEnteGov(String tpEnteGov) {
    this.tpEnteGov = tpEnteGov;
  }

  public String getPRedutor() {
    return pRedutor;
  }

  public void setPRedutor(BigDecimal pRedutor) {
    this.pRedutor = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pRedutor, "Valor total da NF-e com IBS / CBS / IS");
  }

  public String getTpOperGov() {
    return tpOperGov;
  }

  public void setTpOperGov(String tpOperGov) {
    this.tpOperGov = tpOperGov;
  }

}

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
@Root(name = "TCredPres")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeTCredPres extends DFBase {

  private static final long serialVersionUID = -3330020091022345698L;

  @Element(required = true)
  private String cCredPres;

  @Element(required = true)
  private String pCredPres;

  @Element()
  private String vCredPres;

  @Element()
  private String vCredPresCondSus;

  public String getCCredPres() {
    return cCredPres;
  }

  public void setCCredPres(String cCredPres) {
    this.cCredPres = cCredPres;
  }

  public String getPCredPres() {
    return pCredPres;
  }

  public void setPCredPres(BigDecimal pCredPres) {
    this.pCredPres = DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(pCredPres, "Percentual de crédito presumido");
  }

  public String getVCredPres() {
    return vCredPres;
  }

  public void setVCredPres(BigDecimal vCredPres) {
    this.vCredPres = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCredPres, "Valor do crédito presumido");
  }

  public String getVCredPresCondSus() {
    return vCredPresCondSus;
  }

  public void setVCredPresCondSus(BigDecimal vCredPresCondSus) {
    this.vCredPresCondSus = DFBigDecimalValidador.tamanho13Com2CasasDecimais(vCredPresCondSus, "Valor do Crédito Presumido Condição Suspensiva Preencher apenas para cCredPres com indicação de Condição Suspensiva");
  }

}

package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.cte.CTeConfig;
import com.fincatto.documentofiscal.validadores.DFStringValidador;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;


@Root(name = "infDCe")
@Namespace(reference = CTeConfig.NAMESPACE)
public class CTeNotaInfoCTeNormalInfoDocumentosInfoDCe extends DFBase {

  private static final long serialVersionUID = -5021595944749821569L;

  @Element(name = "chave")
  private String chave;

  public String getChave() {
    return this.chave;
  }

  /**
   * Chave de acesso da NF-e
   */
  public void setChave(final String chave) {
    DFStringValidador.exatamente44N(chave, "Chave de acesso da NF-e");
    this.chave = chave;
  }

}

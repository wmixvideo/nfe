package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFBase;

/**
 * // BB01
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoIdentificacaoPagAntecipado extends DFBase {

  private static final long serialVersionUID = -2568396066960857836L;

  private String refNFe; // BB02

  public String getRefNFe() {
    return refNFe;
  }

  public void setRefNFe(String refNFe) {
    this.refNFe = refNFe;
  }

}

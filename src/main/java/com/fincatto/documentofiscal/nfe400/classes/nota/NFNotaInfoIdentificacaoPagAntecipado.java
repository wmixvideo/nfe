package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.util.List;

import org.simpleframework.xml.ElementList;

import com.fincatto.documentofiscal.DFBase;

/**
 * // BB01
 *
 * @author Edivaldo Merlo Stens
 */
public class NFNotaInfoIdentificacaoPagAntecipado extends DFBase {

  private static final long serialVersionUID = -2568396066960857836L;

  @ElementList(entry = "refNFe", inline = true)
  private List<String> refNFe; // BB02

  public List<String> getRefNFe() {
    return refNFe;
  }

  public void setRefNFe(List<String> refNFe) {
    this.refNFe = refNFe;
  }

}

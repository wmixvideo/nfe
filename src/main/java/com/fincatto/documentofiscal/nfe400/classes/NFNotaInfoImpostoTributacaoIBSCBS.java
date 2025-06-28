package com.fincatto.documentofiscal.nfe400.classes;

/**
 *
 * @author Edivaldo Merlo Stens
 */
public enum NFNotaInfoImpostoTributacaoIBSCBS {

  _000("000", "Tributa\u00e7\u00e3o integral",
      C.IND_GIBSCBS_1, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_T, C.IND_NFCE_T, C.IND_CTE_T, C.IND_CTE_OS_T, C.IND_BPE_T, C.IND_BPE_TM_T, C.IND_NF3E_T, C.IND_NF_COM_T, C.IND_NFSE_T),
  _010("010", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes",
      C.IND_GIBSCBS_0, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_F, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_F),
  _011("011", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes reduzidas",
      C.IND_GIBSCBS_0, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_F, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_F),
  _200("200", "Al\u00edquota reduzida",
      C.IND_GIBSCBS_1, C.IND_GIBSCBS_MONO_0, C.IND_GRED_1, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_T, C.IND_NFCE_T, C.IND_CTE_T, C.IND_CTE_OS_T, C.IND_BPE_T, C.IND_BPE_TM_T, C.IND_NF3E_T, C.IND_NF_COM_T, C.IND_NFSE_T),
  _210("210", "Redu\u00e7\u00e3o de al\u00edquota com redutor de base de c\u00e1lculo",
      C.IND_GIBSCBS_1, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_F, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_T),
  _220("220", "Al\u00edquota fixa",
      C.IND_GIBSCBS_1, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_F, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_F),
  _221("221", "Al\u00edquota fixa proporcional",
      C.IND_GIBSCBS_0, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_F, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_T),
  _222("222", "Redu\u00e7\u00e3o de base de c\u00e1lculo",
      C.IND_GIBSCBS_1, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_F, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_F),
  _400("400", "Isen\u00e7\u00e3o",
      C.IND_GIBSCBS_0, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_F, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_T, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_T),
  _410("410", "Imunidade e n\u00e3o incid\u00eancia",
      C.IND_GIBSCBS_0, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_T, C.IND_NFCE_T, C.IND_CTE_T, C.IND_CTE_OS_T, C.IND_BPE_T, C.IND_BPE_TM_T, C.IND_NF3E_T, C.IND_NF_COM_T, C.IND_NFSE_T),
  _510("510", "Diferimento",
      C.IND_GIBSCBS_1, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_1, C.IND_GTRANSF_CRED_0, C.IND_NFE_T, C.IND_NFCE_T, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_T, C.IND_NF_COM_F, C.IND_NFSE_T),
  _550("550", "Suspens\u00e3o",
      C.IND_GIBSCBS_1, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_T, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_T, C.IND_NF_COM_F, C.IND_NFSE_T),
  _620("620", "Tributa\u00e7\u00e3o monof\u00e1sica",
      C.IND_GIBSCBS_0, C.IND_GIBSCBS_MONO_1, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_T, C.IND_NFCE_T, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_F),
  _800("800", "Transfer\u00eancia de cr\u00e9dito",
      C.IND_GIBSCBS_0, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_1, C.IND_NFE_T, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_F),
  _810("810", "Ajustes",
      C.IND_GIBSCBS_N, C.IND_GIBSCBS_MONO_N, C.IND_GRED_N, C.IND_GDIF_N, C.IND_GTRANSF_CRED_N, C.IND_NFE_F, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_F),
  _820("820", "Tributa\u00e7\u00e3o em declara\u00e7\u00e3o de regime espec\u00edfico",
      C.IND_GIBSCBS_0, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_F, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_F, C.IND_NF_COM_F, C.IND_NFSE_T),
  _830("830", "Exclus\u00e3o de base de c\u00e1lculo",
      C.IND_GIBSCBS_1, C.IND_GIBSCBS_MONO_0, C.IND_GRED_0, C.IND_GDIF_0, C.IND_GTRANSF_CRED_0, C.IND_NFE_F, C.IND_NFCE_F, C.IND_CTE_F, C.IND_CTE_OS_F, C.IND_BPE_F, C.IND_BPE_TM_F, C.IND_NF3E_T, C.IND_NF_COM_F, C.IND_NFSE_F);

  private final String codigo;
  private final String descricao;
  private final Integer indGIBSCBS;
  private final Integer indGIBSCBSMono;
  private final Integer indGRed;
  private final Integer indGDif;
  private final Integer indGTransfCred;
  private final boolean indNFe;
  private final boolean indNFCe;
  private final boolean indCTe;
  private final boolean indCteOS;
  private final boolean indBPe;
  private final boolean indBPeTM;
  private final boolean indNF3e;
  private final boolean indNFCom;
  private final boolean indNFSe;

  private NFNotaInfoImpostoTributacaoIBSCBS(String codigo, String descricao, Integer indGIBSCBS, Integer indGIBSCBSMono, Integer indGRed, Integer indGDif, Integer indGTransfCred, boolean indNFe, boolean indNFCe, boolean indCTe, boolean indCteOS, boolean indBPe, boolean indBPeTM, boolean indNF3e, boolean indNFCom, boolean indNFSe) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.indGIBSCBS = indGIBSCBS;
    this.indGIBSCBSMono = indGIBSCBSMono;
    this.indGRed = indGRed;
    this.indGDif = indGDif;
    this.indGTransfCred = indGTransfCred;
    this.indNFe = indNFe;
    this.indNFCe = indNFCe;
    this.indCTe = indCTe;
    this.indCteOS = indCteOS;
    this.indBPe = indBPe;
    this.indBPeTM = indBPeTM;
    this.indNF3e = indNF3e;
    this.indNFCom = indNFCom;
    this.indNFSe = indNFSe;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static NFNotaInfoImpostoTributacaoIBSCBS valueOfCodigo(final String codigoICMS) {
    for (final NFNotaInfoImpostoTributacaoIBSCBS icms : NFNotaInfoImpostoTributacaoIBSCBS.values()) {
      if (icms.getCodigo().equals(codigoICMS)) {
        return icms;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return codigo + " - " + descricao;
  }

  public Integer getIndGIBSCBS() {
    return indGIBSCBS;
  }

  public Integer getIndGIBSCBSMono() {
    return indGIBSCBSMono;
  }

  public Integer getIndGRed() {
    return indGRed;
  }

  public Integer getIndGDif() {
    return indGDif;
  }

  public Integer getIndGTransfCred() {
    return indGTransfCred;
  }

  public boolean isIndNFe() {
    return indNFe;
  }

  public boolean isIndNFCe() {
    return indNFCe;
  }

  public boolean isIndCTe() {
    return indCTe;
  }

  public boolean isIndCteOS() {
    return indCteOS;
  }

  public boolean isIndBPe() {
    return indBPe;
  }

  public boolean isIndBPeTM() {
    return indBPeTM;
  }

  public boolean isIndNF3e() {
    return indNF3e;
  }

  public boolean isIndNFCom() {
    return indNFCom;
  }

  public boolean isIndNFSe() {
    return indNFSe;
  }

  private static class C {

    private static final Integer IND_GIBSCBS_N = null;
    private static final Integer IND_GIBSCBS_0 = 0;
    private static final Integer IND_GIBSCBS_1 = 1;
    private static final Integer IND_GIBSCBS_MONO_N = null;
    private static final Integer IND_GIBSCBS_MONO_0 = 0;
    private static final Integer IND_GIBSCBS_MONO_1 = 1;
    private static final Integer IND_GRED_N = null;
    private static final Integer IND_GRED_0 = 0;
    private static final Integer IND_GRED_1 = 1;
    private static final Integer IND_GDIF_N = null;
    private static final Integer IND_GDIF_0 = 0;
    private static final Integer IND_GDIF_1 = 1;
    private static final Integer IND_GTRANSF_CRED_N = null;
    private static final Integer IND_GTRANSF_CRED_0 = 0;
    private static final Integer IND_GTRANSF_CRED_1 = 1;
    private static final boolean IND_NFE_T = true;
    private static final boolean IND_NFE_F = false;
    private static final boolean IND_NFCE_T = true;
    private static final boolean IND_NFCE_F = false;
    private static final boolean IND_CTE_T = true;
    private static final boolean IND_CTE_F = false;
    private static final boolean IND_CTE_OS_T = true;
    private static final boolean IND_CTE_OS_F = false;
    private static final boolean IND_BPE_T = true;
    private static final boolean IND_BPE_F = false;
    private static final boolean IND_BPE_TM_T = true;
    private static final boolean IND_BPE_TM_F = false;
    private static final boolean IND_NF3E_T = true;
    private static final boolean IND_NF3E_F = false;
    private static final boolean IND_NF_COM_T = true;
    private static final boolean IND_NF_COM_F = false;
    private static final boolean IND_NFSE_T = true;
    private static final boolean IND_NFSE_F = false;
  }
}

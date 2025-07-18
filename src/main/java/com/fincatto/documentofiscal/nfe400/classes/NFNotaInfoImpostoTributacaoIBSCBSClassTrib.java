package com.fincatto.documentofiscal.nfe400.classes;

import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_000;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_010;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_011;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_200;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_830;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Este enum é uma proposta (ainda não utilizada, e pode ser excluída), de acordo com a tabela tabela CST_cClassTribPublicacao_20250618.
 * Ainda não está com todos os códigos da tabela.
 * @author Edivaldo Merlo Stens
 */
public enum NFNotaInfoImpostoTributacaoIBSCBSClassTrib {

  CST_000001("000001", CST_000, "Situações tributadas integralmente pelo IBS e CBS",
      IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_000002("000002", CST_000, "Exploração de via",
      IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_000003("000003", CST_000, "Regime automotivo - projetos incentivados (art. 311)",
      IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_1, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_000004("000004", CST_000, "Regime automotivo - projetos incentivados (art. 312)",
      IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_1, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_010001("010001", CST_010, "Operações do FGTS não realizadas pela Caixa Econômica Federal",
      IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_010002("010002", CST_010, "Operações do serviço financeiro",
      IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_011001("011001", CST_011, "Planos de assistência funerária.",
      IND.P_RED_IBS_60, IND.P_RED_CBS_60, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_011002("011002", CST_011, "Planos de assistência à saúde",
      IND.P_RED_IBS_60, IND.P_RED_CBS_60, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_011003("011003", CST_011, "Intermediação de planos de assistência à saúde",
      IND.P_RED_IBS_60, IND.P_RED_CBS_60, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_011004("011004", CST_011, "Concursos e prognósticos",
      IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_011005("011005", CST_011, "Planos de assistência à saúde de animais domésticos",
      IND.P_RED_IBS_30, IND.P_RED_CBS_30, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_200001("200001", CST_200, "Aquisições realizadas entre empresas autorizadas a operar em zonas de processamento de exportação",
      IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_200002("200002", CST_200, "Fornecimento ou importação para produtor rural não contribuinte ou TAC",
      IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_200003("200003", CST_200, "Vendas de produtos destinados à alimentação humana (Anexo I)",
      IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_200004("200004", CST_200, "Venda de dispositivos médicos com a especificação das respectivas classificações da NCM/SH previstas no Anexo XII da Lei Complementar nº 214, de 2025, observado o art. 144 da Lei Complementar nº 214, de 2025.",
      IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_200005("200005", CST_200, "Venda de dispositivos médicos adquiridos por órgãos da administração pública (Anexo IV).",
      IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_200006("200006", CST_200, "Situação de emergência de saúde pública reconhecida pelo Poder público (Anexo XII).",
      IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_200007("200007", CST_200, "Fornecimento dos dispositivos de acessibilidade próprios para pessoas com deficiência (Anexo XIII).",
      IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_200008("200008", CST_200, "Fornecimento dos dispositivos de acessibilidade próprios para pessoas com deficiência adquiridos por órgãos da administração pública (Anexo V).",
      IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_200009("200009", CST_200, "Fornecimento de medicamentos (Anexo XIV).",
      IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  CST_200010("200010", CST_200, "Fornecimento dos medicamentos registrados na Anvisa, adquiridos por órgãos da administração pública.",
      IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
  // falta implementar o restante de acordo com a tabela CST_cClassTribPublicacao_20250618
  CST_830001("830001", CST_830, "Documento com exclusão da BC da CBS e do IBS de energia elétrica fornecida pela distribuidora à UC",
      IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_N, IND.CRED_PRES_N, IND.MONO_N, IND.MONO_RETEN_N,
      IND.MONO_RET_N, IND.MONO_DIF_N, null, null);

  private final String codigo;
  private final NFNotaInfoImpostoTributacaoIBSCBS cst;
  private final String descricao;
  private final BigDecimal pRedIBS;
  private final BigDecimal pRedCBS;
  private final Integer indRedutorBC;
  private final Integer indGTribRegular;
  private final Integer indCredPres;
  private final Integer indMono;
  private final Integer indMonoReten;
  private final Integer indMonoRet;
  private final Integer indMonoDif;
  private final LocalDate dIniVig;
  private final LocalDate dFimVig;

  private NFNotaInfoImpostoTributacaoIBSCBSClassTrib(String codigo, NFNotaInfoImpostoTributacaoIBSCBS cst, String descricao, BigDecimal pRedIBS, BigDecimal pRedCBS, Integer indRedutorBC, Integer indGTribRegular, Integer indCredPres, Integer indMono, Integer indMonoReten, Integer indMonoRet, Integer indMonoDif, LocalDate dIniVig, LocalDate dFimVig) {
    this.codigo = codigo;
    this.cst = cst;
    this.descricao = descricao;
    this.pRedIBS = pRedIBS;
    this.pRedCBS = pRedCBS;
    this.indRedutorBC = indRedutorBC;
    this.indGTribRegular = indGTribRegular;
    this.indCredPres = indCredPres;
    this.indMono = indMono;
    this.indMonoReten = indMonoReten;
    this.indMonoRet = indMonoRet;
    this.indMonoDif = indMonoDif;
    this.dIniVig = dIniVig;
    this.dFimVig = dFimVig;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static NFNotaInfoImpostoTributacaoIBSCBSClassTrib valueOfCodigo(final String codigoIBSCBS) {
    for (final NFNotaInfoImpostoTributacaoIBSCBSClassTrib ibscbs : NFNotaInfoImpostoTributacaoIBSCBSClassTrib.values()) {
      if (ibscbs.getCodigo().equals(codigoIBSCBS)) {
        return ibscbs;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return codigo + " - " + descricao;
  }

  public NFNotaInfoImpostoTributacaoIBSCBS getCst() {
    return cst;
  }

  public BigDecimal getpRedIBS() {
    return pRedIBS;
  }

  public BigDecimal getpRedCBS() {
    return pRedCBS;
  }

  public Integer getIndRedutorBC() {
    return indRedutorBC;
  }

  public Integer getIndGTribRegular() {
    return indGTribRegular;
  }

  public Integer getIndCredPres() {
    return indCredPres;
  }

  public Integer getIndMono() {
    return indMono;
  }

  public Integer getIndMonoReten() {
    return indMonoReten;
  }

  public Integer getIndMonoRet() {
    return indMonoRet;
  }

  public Integer getIndMonoDif() {
    return indMonoDif;
  }

  public LocalDate getdIniVig() {
    return dIniVig;
  }

  public LocalDate getdFimVig() {
    return dFimVig;
  }

  /**
   * Verifica se o código está vigente com base na data atual.
   *
   * @return true se estiver vigente, false caso contrário.
   */
  public boolean isVigente() {
    LocalDate hoje = LocalDate.now();
    return (dIniVig == null || !hoje.isBefore(dIniVig)) && (dFimVig == null || !hoje.isAfter(dFimVig));
  }

  /**
   * Verifica se o código está vigente com base na data passada por parametro.
   *
   * @param inDate
   * @return true se estiver vigente, false caso contrário.
   */
  public boolean isVigente(LocalDate inDate) {
    return (dIniVig == null || !inDate.isBefore(dIniVig)) && (dFimVig == null || !inDate.isAfter(dFimVig));
  }

  private static class IND {

    private static final BigDecimal P_RED_IBS_N = null;
    private static final BigDecimal P_RED_IBS_30 = new BigDecimal("30");
    private static final BigDecimal P_RED_IBS_60 = new BigDecimal("60");
    private static final BigDecimal P_RED_IBS_100 = new BigDecimal("100");

    private static final BigDecimal P_RED_CBS_N = null;
    private static final BigDecimal P_RED_CBS_30 = new BigDecimal("30");
    private static final BigDecimal P_RED_CBS_60 = new BigDecimal("60");
    private static final BigDecimal P_RED_CBS_100 = new BigDecimal("100");

    private static final Integer RED_BC_N = null;
    private static final Integer RED_BC_0 = 0;
    private static final Integer RED_BC_1 = 1;

    private static final Integer GTRIB_REG_N = null;
    private static final Integer GTRIB_REG_0 = 0;
    private static final Integer GTRIB_REG_1 = 1;

    private static final Integer CRED_PRES_N = null;
    private static final Integer CRED_PRES_0 = 0;
    private static final Integer CRED_PRES_1 = 1;

    private static final Integer MONO_N = null;
    private static final Integer MONO_0 = 0;
    private static final Integer MONO_1 = 1;

    private static final Integer MONO_RETEN_N = null;
    private static final Integer MONO_RETEN_0 = 0;
    private static final Integer MONO_RETEN_1 = 1;

    private static final Integer MONO_RET_N = null;
    private static final Integer MONO_RET_0 = 0;
    private static final Integer MONO_RET_1 = 1;

    private static final Integer MONO_DIF_N = null;
    private static final Integer MONO_DIF_0 = 0;
    private static final Integer MONO_DIF_1 = 1;
  }
}

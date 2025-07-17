package com.fincatto.documentofiscal.nfe400.classes;

import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.TRIBUTACAO_INTEGRAL;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.TRIBUTACAO_ALIQUOTAS_UNIFORMES;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.TRIBUTACAO_ALIQUOTAS_UNIFORMES_REDUZIDAS;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.ALIQUOTA_REDUZIDA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.EXCLUSAO_BASE_CALCULO;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Este enum é uma proposta (ainda não utilizada, e pode ser excluída), de acordo com a tabela tabela CST_cClassTribPublicacao_20250618.
 * Ainda não está com todos os códigos da tabela.
 * @author Edivaldo Merlo Stens
 */
public enum NFNotaInfoImpostoTributacaoIBSCBSClassTrib {

  SITUACOES_TRIBUTADAS_INTEGRALMENTE("000001", TRIBUTACAO_INTEGRAL, "Situações tributadas integralmente pelo IBS e CBS",
      C.P_RED_IBS_N, C.P_RED_CBS_N, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  EXPLORACAO_DE_VIA("000002", TRIBUTACAO_INTEGRAL, "Exploração de via",
      C.P_RED_IBS_N, C.P_RED_CBS_N, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  REGIME_AUTOMOTIVO_ART311("000003", TRIBUTACAO_INTEGRAL, "Regime automotivo - projetos incentivados (art. 311)",
      C.P_RED_IBS_N, C.P_RED_CBS_N, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_1, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  REGIME_AUTOMOTIVO_ART312("000004", TRIBUTACAO_INTEGRAL, "Regime automotivo - projetos incentivados (art. 312)",
      C.P_RED_IBS_N, C.P_RED_CBS_N, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_1, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  OPERACOES_FGTS_NAO_REALIZADAS_CEF("010001", TRIBUTACAO_ALIQUOTAS_UNIFORMES, "Operações do FGTS não realizadas pela Caixa Econômica Federal",
      C.P_RED_IBS_N, C.P_RED_CBS_N, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  OPERACOES_SERVICO_FINANCEIRO("010002", TRIBUTACAO_ALIQUOTAS_UNIFORMES, "Operações do serviço financeiro",
      C.P_RED_IBS_N, C.P_RED_CBS_N, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  PLANO_ASSISTENCIA_FUNERARIA("011001", TRIBUTACAO_ALIQUOTAS_UNIFORMES_REDUZIDAS, "Planos de assistência funerária.",
      C.P_RED_IBS_60, C.P_RED_CBS_60, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  PLANO_ASSISTENCIA_SAUDE("011002", TRIBUTACAO_ALIQUOTAS_UNIFORMES_REDUZIDAS, "Planos de assistência à saúde",
      C.P_RED_IBS_60, C.P_RED_CBS_60, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  INTERMEDIACAO_PLANO_ASSISTENCIA_SAUDE("011003", TRIBUTACAO_ALIQUOTAS_UNIFORMES_REDUZIDAS, "Intermediação de planos de assistência à saúde",
      C.P_RED_IBS_60, C.P_RED_CBS_60, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  CONCURSOS_PROGNOSTICOS("011004", TRIBUTACAO_ALIQUOTAS_UNIFORMES_REDUZIDAS, "Concursos e prognósticos",
      C.P_RED_IBS_N, C.P_RED_CBS_N, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  PLANOS_ASSISTENCIA_SAUDE_ANIMAIS_DOMESTICOS("011005", TRIBUTACAO_ALIQUOTAS_UNIFORMES_REDUZIDAS, "Planos de assistência à saúde de animais domésticos",
      C.P_RED_IBS_30, C.P_RED_CBS_30, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  AQUISICOES_ENTRE_EMPRESAS_AUTORIZADAS_OPERAR_ZONAS_PROCESSAMENTO_EXPORTACAO("200001", ALIQUOTA_REDUZIDA, "Aquisições realizadas entre empresas autorizadas a operar em zonas de processamento de exportação",
      C.P_RED_IBS_100, C.P_RED_CBS_100, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  FORNECIMENTO_IMPORTACAO_PRODUTOR_RURAL_NAO_CONTRIBUINTE_TAC("200002", ALIQUOTA_REDUZIDA, "Fornecimento ou importação para produtor rural não contribuinte ou TAC",
      C.P_RED_IBS_100, C.P_RED_CBS_100, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  VENDAS_PRODUTOS_ALIMENTACAO_HUMANA("200003", ALIQUOTA_REDUZIDA, "Vendas de produtos destinados à alimentação humana (Anexo I)",
      C.P_RED_IBS_100, C.P_RED_CBS_100, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  VENDA_DISPOSITIVOS_MEDICOS_ANEXO_XII("200004", ALIQUOTA_REDUZIDA, "Venda de dispositivos médicos com a especificação das respectivas classificações da NCM/SH previstas no Anexo XII da Lei Complementar nº 214, de 2025, observado o art. 144 da Lei Complementar nº 214, de 2025.",
      C.P_RED_IBS_100, C.P_RED_CBS_100, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  VENDA_DISPOSITIVOS_MEDICOS_ANEXO_IV("200005", ALIQUOTA_REDUZIDA, "Venda de dispositivos médicos adquiridos por órgãos da administração pública (Anexo IV).",
      C.P_RED_IBS_100, C.P_RED_CBS_100, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  SITUACAO_EMERGENCIA_SAUDE_PUBLICA_ANEXO_XII("200006", ALIQUOTA_REDUZIDA, "Situação de emergência de saúde pública reconhecida pelo Poder público (Anexo XII).",
      C.P_RED_IBS_100, C.P_RED_CBS_100, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  FORNECIMENTO_DISPOSITIVOS_ACESSIBILIDADE_ANEXO_XIII("200007", ALIQUOTA_REDUZIDA, "Fornecimento dos dispositivos de acessibilidade próprios para pessoas com deficiência (Anexo XIII).",
      C.P_RED_IBS_100, C.P_RED_CBS_100, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  FORNECIMENTO_DISPOSITIVOS_ACESSIBILIDADE_ANEXO_V("200008", ALIQUOTA_REDUZIDA, "Fornecimento dos dispositivos de acessibilidade próprios para pessoas com deficiência adquiridos por órgãos da administração pública (Anexo V).",
      C.P_RED_IBS_100, C.P_RED_CBS_100, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  FORNECIMENTO_MEDICAMENTOS_ANEXO_XIV("200009", ALIQUOTA_REDUZIDA, "Fornecimento de medicamentos (Anexo XIV).",
      C.P_RED_IBS_100, C.P_RED_CBS_100, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  FORNECIMENTO_MEDICAMENTOS_ADMINISTRACAO_PUBLICA("200010", ALIQUOTA_REDUZIDA, "Fornecimento dos medicamentos registrados na Anvisa, adquiridos por órgãos da administração pública.",
      C.P_RED_IBS_100, C.P_RED_CBS_100, C.IND_RED_BC_N, C.IND_GTRIB_REG_0, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null),
  // falta implementar o restante de acordo com a tabela CST_cClassTribPublicacao_20250618
  DOCUMENTO_EXCLUSAO_BC_ENERGIA_DISTRIBUIDORA_UC("830001", EXCLUSAO_BASE_CALCULO, "Documento com exclusão da BC da CBS e do IBS de energia elétrica fornecida pela distribuidora à UC",
      C.P_RED_IBS_N, C.P_RED_CBS_N, C.IND_RED_BC_N, C.IND_GTRIB_REG_N, C.IND_CRED_PRES_N, C.IND_MONO_N, C.IND_MONO_RETEN_N,
      C.IND_MONO_RET_N, C.IND_MONO_DIF_N, null, null);

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

  public static NFNotaInfoImpostoTributacaoIBSCBSClassTrib valueOfCodigo(final String codigoICMS) {
    for (final NFNotaInfoImpostoTributacaoIBSCBSClassTrib icms : NFNotaInfoImpostoTributacaoIBSCBSClassTrib.values()) {
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

  private static class C {

    private static final BigDecimal P_RED_IBS_N = null;
    private static final BigDecimal P_RED_IBS_30 = new BigDecimal("30");
    private static final BigDecimal P_RED_IBS_60 = new BigDecimal("60");
    private static final BigDecimal P_RED_IBS_100 = new BigDecimal("100");

    private static final BigDecimal P_RED_CBS_N = null;
    private static final BigDecimal P_RED_CBS_30 = new BigDecimal("30");
    private static final BigDecimal P_RED_CBS_60 = new BigDecimal("60");
    private static final BigDecimal P_RED_CBS_100 = new BigDecimal("100");

    private static final Integer IND_RED_BC_N = null;
    private static final Integer IND_RED_BC_0 = 0;
    private static final Integer IND_RED_BC_1 = 1;

    private static final Integer IND_GTRIB_REG_N = null;
    private static final Integer IND_GTRIB_REG_0 = 0;
    private static final Integer IND_GTRIB_REG_1 = 1;

    private static final Integer IND_CRED_PRES_N = null;
    private static final Integer IND_CRED_PRES_0 = 0;
    private static final Integer IND_CRED_PRES_1 = 1;

    private static final Integer IND_MONO_N = null;
    private static final Integer IND_MONO_0 = 0;
    private static final Integer IND_MONO_1 = 1;

    private static final Integer IND_MONO_RETEN_N = null;
    private static final Integer IND_MONO_RETEN_0 = 0;
    private static final Integer IND_MONO_RETEN_1 = 1;

    private static final Integer IND_MONO_RET_N = null;
    private static final Integer IND_MONO_RET_0 = 0;
    private static final Integer IND_MONO_RET_1 = 1;

    private static final Integer IND_MONO_DIF_N = null;
    private static final Integer IND_MONO_DIF_0 = 0;
    private static final Integer IND_MONO_DIF_1 = 1;
  }
}

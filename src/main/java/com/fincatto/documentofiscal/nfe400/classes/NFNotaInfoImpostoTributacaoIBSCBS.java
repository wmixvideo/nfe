package com.fincatto.documentofiscal.nfe400.classes;

/**
 * @author Edivaldo Merlo Stens
 */
public enum NFNotaInfoImpostoTributacaoIBSCBS {

    CST_000("000", "Tributa\u00e7\u00e3o integral",
            IND.GIBSCBS_1, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_T, IND.NFCE_T, IND.CTE_T, IND.CTE_OS_T, IND.BPE_T, IND.BPE_TM_T, IND.NF3E_T, IND.NF_COM_T, IND.NFSE_T),
    CST_010("010", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes",
            IND.GIBSCBS_0, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_F, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_F),
    CST_011("011", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes reduzidas",
            IND.GIBSCBS_0, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_F, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_F),
    CST_200("200", "Al\u00edquota reduzida",
            IND.GIBSCBS_1, IND.GIBSCBS_MONO_0, IND.GRED_1, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_T, IND.NFCE_T, IND.CTE_T, IND.CTE_OS_T, IND.BPE_T, IND.BPE_TM_T, IND.NF3E_T, IND.NF_COM_T, IND.NFSE_T),
    CST_210("210", "Redu\u00e7\u00e3o de al\u00edquota com redutor de base de c\u00e1lculo",
            IND.GIBSCBS_1, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_F, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_T),
    CST_220("220", "Al\u00edquota fixa",
            IND.GIBSCBS_1, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_F, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_F),
    CST_221("221", "Al\u00edquota fixa proporcional",
            IND.GIBSCBS_0, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_F, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_T),
    CST_222("222", "Redu\u00e7\u00e3o de base de c\u00e1lculo",
            IND.GIBSCBS_1, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_F, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_F),
    CST_400("400", "Isen\u00e7\u00e3o",
            IND.GIBSCBS_0, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_F, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_T, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_T),
    CST_410("410", "Imunidade e n\u00e3o incid\u00eancia",
            IND.GIBSCBS_0, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_T, IND.NFCE_T, IND.CTE_T, IND.CTE_OS_T, IND.BPE_T, IND.BPE_TM_T, IND.NF3E_T, IND.NF_COM_T, IND.NFSE_T),
    CST_510("510", "Diferimento",
            IND.GIBSCBS_1, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_1, IND.GTRANSF_CRED_0, IND.NFE_T, IND.NFCE_T, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_T, IND.NF_COM_F, IND.NFSE_T),
    CST_550("550", "Suspens\u00e3o",
            IND.GIBSCBS_1, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_T, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_T, IND.NF_COM_F, IND.NFSE_T),
    CST_620("620", "Tributa\u00e7\u00e3o monof\u00e1sica",
            IND.GIBSCBS_0, IND.GIBSCBS_MONO_1, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_T, IND.NFCE_T, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_F),
    CST_800("800", "Transfer\u00eancia de cr\u00e9dito",
            IND.GIBSCBS_0, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_1, IND.NFE_T, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_F),
    CST_810("810", "Ajustes",
            IND.GIBSCBS_N, IND.GIBSCBS_MONO_N, IND.GRED_N, IND.GDIF_N, IND.GTRANSF_CRED_N, IND.NFE_F, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_F),
    CST_820("820", "Tributa\u00e7\u00e3o em declara\u00e7\u00e3o de regime espec\u00edfico",
            IND.GIBSCBS_0, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_F, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_F, IND.NF_COM_F, IND.NFSE_T),
    CST_830("830", "Exclus\u00e3o de base de c\u00e1lculo",
            IND.GIBSCBS_1, IND.GIBSCBS_MONO_0, IND.GRED_0, IND.GDIF_0, IND.GTRANSF_CRED_0, IND.NFE_F, IND.NFCE_F, IND.CTE_F, IND.CTE_OS_F, IND.BPE_F, IND.BPE_TM_F, IND.NF3E_T, IND.NF_COM_F, IND.NFSE_F);

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

    public static NFNotaInfoImpostoTributacaoIBSCBS valueOfCodigo(final String codigoIBSCBS) {
        for (final NFNotaInfoImpostoTributacaoIBSCBS ibscbs : NFNotaInfoImpostoTributacaoIBSCBS.values()) {
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

    private static class IND {
        private static final Integer GIBSCBS_N = null;
        private static final Integer GIBSCBS_0 = 0;
        private static final Integer GIBSCBS_1 = 1;
        private static final Integer GIBSCBS_MONO_N = null;
        private static final Integer GIBSCBS_MONO_0 = 0;
        private static final Integer GIBSCBS_MONO_1 = 1;
        private static final Integer GRED_N = null;
        private static final Integer GRED_0 = 0;
        private static final Integer GRED_1 = 1;
        private static final Integer GDIF_N = null;
        private static final Integer GDIF_0 = 0;
        private static final Integer GDIF_1 = 1;
        private static final Integer GTRANSF_CRED_N = null;
        private static final Integer GTRANSF_CRED_0 = 0;
        private static final Integer GTRANSF_CRED_1 = 1;
        private static final boolean NFE_T = true;
        private static final boolean NFE_F = false;
        private static final boolean NFCE_T = true;
        private static final boolean NFCE_F = false;
        private static final boolean CTE_T = true;
        private static final boolean CTE_F = false;
        private static final boolean CTE_OS_T = true;
        private static final boolean CTE_OS_F = false;
        private static final boolean BPE_T = true;
        private static final boolean BPE_F = false;
        private static final boolean BPE_TM_T = true;
        private static final boolean BPE_TM_F = false;
        private static final boolean NF3E_T = true;
        private static final boolean NF3E_F = false;
        private static final boolean NF_COM_T = true;
        private static final boolean NF_COM_F = false;
        private static final boolean NFSE_T = true;
        private static final boolean NFSE_F = false;
    }
}

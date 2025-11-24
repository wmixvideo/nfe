package com.fincatto.documentofiscal.nfe400.classes;

import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.IND.*;

import java.util.Arrays;

/**
 * Enum que define os Codigos de Classificacao Tributaria do IBS e CBS
 * CST_cClassTribPublicacao_20250618.xlsx 
 * Aba CST
 * 
 * @author Edivaldo Merlo Stens
 * @author Marcos Lombardi de Andrade
 */
public enum NFNotaInfoImpostoTributacaoIBSCBS {

    CST_000("000", "Tributa\u00e7\u00e3o integral",
            UM, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_010("010", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes",
    		ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_011("011", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes reduzidas",
    		ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_200("200", "Al\u00edquota reduzida",
    		 UM, ZERO, UM, ZERO, ZERO, ZERO, ZERO),
    
    CST_220("220", "Al\u00edquota fixa",
    		 UM, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_221("221", "Al\u00edquota fixa proporcional",
    		 UM, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_222("222", "Redu\u00e7\u00e3o de base de c\u00e1lculo",
    		ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_400("400", "Isen\u00e7\u00e3o",
    		ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_410("410", "Imunidade e n\u00e3o incid\u00eancia",
    		ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_510("510", "Diferimento",
    		 UM, ZERO, ZERO, UM, ZERO, ZERO, ZERO),

    CST_515("515", "Diferimento com redu\u00e7\u00e3o de al\u00edquota",
            UM, ZERO, UM, UM, ZERO, ZERO, ZERO),
    
    CST_550("550", "Suspens\u00e3o",
    		 UM, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_620("620", "Tributa\u00e7\u00e3o monof\u00e1sica",
    		ZERO, UM, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_800("800", "Transfer\u00eancia de cr\u00e9dito",
    		ZERO, ZERO, ZERO, ZERO, UM, ZERO, ZERO),
    
    CST_810("810", "Ajustes de IBS na ZFM",
    		 ZERO, ZERO, ZERO, ZERO, ZERO, UM, ZERO),

    CST_811("811", "Ajustes",
            ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, UM),
    
    CST_820("820", "Tributa\u00e7\u00e3o em declara\u00e7\u00e3o de regime espec\u00edfico",
    		ZERO, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO),
    
    CST_830("830", "Exclus\u00e3o de base de c\u00e1lculo",
    		 UM, ZERO, ZERO, ZERO, ZERO, ZERO, ZERO);

    private final String codigo;
    private final String descricao;
    private final Integer indGIBSCBS;
    private final Integer indGIBSCBSMono;
    private final Integer indGRed;
    private final Integer indGDif;
    private final Integer indGTransfCred;
    private final Integer indGCredPresIBS;
    private final Integer indGAjusteCompet;

    private NFNotaInfoImpostoTributacaoIBSCBS(String codigo, String descricao, Integer indGIBSCBS, Integer indGIBSCBSMono, Integer indGRed, Integer indGDif, Integer indGTransfCred, Integer indGCredPresIBS, Integer indGAjusteCompet) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.indGIBSCBS = indGIBSCBS;
        this.indGIBSCBSMono = indGIBSCBSMono;
        this.indGRed = indGRed;
        this.indGDif = indGDif;
        this.indGTransfCred = indGTransfCred;
        this.indGCredPresIBS = indGCredPresIBS;
        this.indGAjusteCompet = indGAjusteCompet;
    }

	public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
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

    public Integer getIndGCredPresIBS() { return indGCredPresIBS; }

    public Integer getIndGAjusteCompet() { return indGAjusteCompet; }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
    
    /**
	 * Retorna o enum correspondente ao codigo IBSCBS informado.
	 *
	 * @param codigoIBSCBS o codigo IBSCBS
	 * @return o enum correspondente ou null se nao encontrado
	 */
    public static NFNotaInfoImpostoTributacaoIBSCBS valueOfCodigo(final String codigoIBSCBS) {
	    return Arrays.stream(NFNotaInfoImpostoTributacaoIBSCBS.values())
    			.filter(ibscbs -> ibscbs.getCodigo().equals(codigoIBSCBS))
    				.findFirst().orElse(null);
    }
    
    static class IND {
    	
        static final Integer UM = 1;
        static final Integer ZERO = 0;
        static final boolean SIM = true;
        static final boolean NAO = false;
        
    }
}

package com.fincatto.documentofiscal.nfe400.classes;

import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_000;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_010;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_011;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_200;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_830;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Enum que define os Codigos de Classificacao Tributaria do IBS e CBS
 *
 * CST_cClassTribPublicacao_20250618.xlsx
 * 
 * @author Edivaldo Merlo Stens
 * @author Marcos Lombardi de Andrade
 */
public enum NFNotaInfoImpostoTributacaoIBSCBSClassTrib {

	// CST_000
	CST_000001("000001", CST_000, "Situações tributadas integralmente pelo IBS e CBS",
				IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
				IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_000002("000002", CST_000, "Exploração de via",
		      	IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_000003("000003", CST_000, "Regime automotivo - projetos incentivados (art. 311)",
		      	IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_1, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_000004("000004", CST_000, "Regime automotivo - projetos incentivados (art. 312)",
		      	IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_1, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	
	// CST_010
	CST_010001("010001", CST_010, "Operações do FGTS não realizadas pela Caixa Econômica Federal",
		      	IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_010002("010002", CST_010, "Operações do serviço financeiro",
		      	IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	
	// CST_011
	CST_011001("011001", CST_011, "Planos de assistência funerária.",
		      	IND.P_RED_IBS_60, IND.P_RED_CBS_60, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_011002("011002", CST_011, "Planos de assistência à saúde",
		      	IND.P_RED_IBS_60, IND.P_RED_CBS_60, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_011003("011003", CST_011, "Intermediação de planos de assistência à saúde",
		      	IND.P_RED_IBS_60, IND.P_RED_CBS_60, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_011004("011004", CST_011, "Concursos e prognósticos",
		      	IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_011005("011005", CST_011, "Planos de assistência à saúde de animais domésticos",
		      	IND.P_RED_IBS_30, IND.P_RED_CBS_30, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	
	// CST_200
	CST_200001("200001", CST_200, "Aquisições realizadas entre empresas autorizadas a operar em zonas de processamento de exportação",
		      	IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_200002("200002", CST_200, "Fornecimento ou importação para produtor rural não contribuinte ou TAC",
		      	IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_200003("200003", CST_200, "Vendas de produtos destinados à alimentação humana (Anexo I)",
		      	IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_200004("200004", CST_200, "Venda de dispositivos médicos com a especificação das respectivas classificações da NCM/SH previstas no Anexo XII da Lei Complementar nº 214, de 2025, observado o art. 144 da Lei Complementar nº 214, de 2025.",
		      	IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_200005("200005", CST_200, "Venda de dispositivos médicos adquiridos por órgãos da administração pública (Anexo IV).",
		      	IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_200006("200006", CST_200, "Situação de emergência de saúde pública reconhecida pelo Poder público (Anexo XII).",
		      	IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		      	IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_200007("200007", CST_200, "Fornecimento dos dispositivos de acessibilidade próprios para pessoas com deficiência (Anexo XIII).",
		      	IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		        IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	  
	CST_200008("200008", CST_200, "Fornecimento dos dispositivos de acessibilidade próprios para pessoas com deficiência adquiridos por órgãos da administração pública (Anexo V).",
	        	IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
		        IND.MONO_N, IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null),
	
	CST_200009("200009", CST_200, "Fornecimento de medicamentos (Anexo XIV).", IND.P_RED_IBS_100, 
				IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
				IND.MONO_N, null, null, null, null, null),
	
	CST_200010("200010", CST_200, "Fornecimento dos medicamentos registrados na Anvisa, adquiridos por órgãos da administração pública.",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
				IND.MONO_N, null, null, null, null,	null),
	
	CST_200011("200011", CST_200, "Fornecimento das composições para nutrição enteral e parenteral quando adquiridas por órgãos da administração pública (Anexo VI)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, IND.CRED_PRES_N, 
				IND.MONO_N, null, null, null, null,	null),
	
	CST_200012("200012", CST_200, "Situação de emergência de saúde pública reconhecida pelo Poder público (Anexo XIV)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200013("200013", CST_200, "Fornecimento de tampões higiênicos, absorventes higiênicos internos ou externos",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200014("200014", CST_200, "Fornecimento dos produtos hortícolas, frutas e ovos (Anexo XV)", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200015("200015", CST_200, "Venda de automóveis de passageiros de fabricação nacional adquiridos por motoristas profissionais ou pessoas com deficiência",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200016("200016", CST_200, "Prestação de serviços de pesquisa e desenvolvimento por Instituição Científica, Tecnológica e de Inovação (ICT)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200017("200017", CST_200, "Operações relacionadas ao FGTS", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200018("200018", CST_200, "Operações de resseguro e retrocessão", IND.P_RED_IBS_100, IND.P_RED_CBS_100,
				IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200019("200019", CST_200, "Importador dos serviços financeiros contribuinte", IND.P_RED_IBS_100,
				IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200020("200020", CST_200, "Operação praticada por sociedades cooperativas optantes por regime específico do IBS e CBS",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200021("200021", CST_200, "Serviços de transporte público coletivo de passageiros ferroviário e hidroviário",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200022("200022", CST_200, "Operação originada fora da ZFM que destine bem material industrializado a contribuinte estabelecido na ZFM",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200023("200023", CST_200, "Operação realizada por indústria incentivada que destine bem material intermediário para outra indústria incentivada na ZFM",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200024("200024", CST_200, "Operação originada fora das Áreas de Livre Comércio destinadas a contribuinte estabelecido nas Áreas de Livre Comércio",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null,
				null, null, null, null, null, null),
	
	CST_200025("200025", CST_200, "Fornecimento dos serviços de educação relacionados ao Programa Universidade para Todos (Prouni)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null,
				null, null, null, null, null, null),
	
	CST_200026("200026", CST_200, "Locação de imóveis localizados nas zonas reabilitadas", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200027("200027", CST_200, "Operações de locação, cessão onerosa e arrendamento de bens imóveis",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null,
				null, null, null, null, null, null),
	
	CST_200028("200028", CST_200, "Fornecimento dos serviços de educação (Anexo II)", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200029("200029", CST_200, "Fornecimento dos serviços de saúde humana (Anexo III)", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200030("200030", CST_200, "Venda dos dispositivos médicos  (Anexo IV)", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200031("200031", CST_200, "Fornecimento dos dispositivos de acessibilidade próprios para pessoas com deficiência (Anexo V)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200032("200032", CST_200, "Fornecimento dos medicamentos registrados na Anvisa ou produzidos por farmácias de manipulação, ressalvados os medicamentos sujeitos à alíquota zero",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null,
				null, null, null, null, null, null),
	
	CST_200033("200033", CST_200, "Fornecimento das composições para nutrição enteral e parenteral (Anexo VI)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null,
				null, null, null, null, null, null),
	
	CST_200034("200034", CST_200, "Fornecimento dos alimentos destinados ao consumo humano (Anexo VII)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null,
				null, null, null, null, null, null),
	
	CST_200035("200035", CST_200, "Fornecimento dos produtos de higiene pessoal e limpeza (Anexo VIII)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200036("200036", CST_200, "Fornecimento de produtos agropecuários, aquícolas, pesqueiros, florestais e extrativistas vegetais in natura",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null,
				null, null, null, null, null, null),
	
	CST_200037("200037", CST_200, "Fornecimento de serviços ambientais de conservação ou recuperação da vegetação nativa", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200038("200038", CST_200, "Fornecimento dos insumos agropecuários e aquícolas (Anexo IX)", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200039("200039", CST_200, "Fornecimento dos serviços e o licenciamento ou cessão dos direitos destinados às produções nacionais artísticas (Anexo X)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200040("200040", CST_200, "Fornecimento de serviços de comunicação institucional à administração pública",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200041("200041", CST_200, "Fornecimento de serviço de educação desportiva (art. 141. I)", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200042("200042", CST_200, "Fornecimento de serviço de educação desportiva (art. 141. II)", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200043("200043", CST_200,"Fornecimento à administração pública dos serviços e dos bens relativos à soberania (Anexo XI)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null,
				null, null, null, null, null, null),
	
	CST_200044("200044", CST_200, "Operações e prestações de serviços de segurança da informação e segurança cibernética desenvolvidos por sociedade que tenha sócio brasileiro (Anexo XI)",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200045("200045", CST_200, "Operações relacionadas a projetos de reabilitação urbana de zonas históricas e de áreas críticas de recuperação e reconversão urbanística",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200046("200046", CST_200, "Operações com bens imóveis", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200047("200047", CST_200, "Bares e Restaurantes", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N,	IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200048("200048", CST_200, "Hotelaria, Parques de Diversão e Parques Temáticos", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200049("200049", CST_200, "Transporte coletivo de passageiros rodoviário, ferroviário e hidroviário",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200450("200450", CST_200, "Serviços de transporte aéreo regional coletivo de passageiros ou de carga",
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200051("200051", CST_200, "Agências de Turismo", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),
	
	CST_200052("200052", CST_200, "Prestação de serviços de profissões intelectuais", 
				IND.P_RED_IBS_100, IND.P_RED_CBS_100, IND.RED_BC_N, IND.GTRIB_REG_0, null, 
				null, null, null, null, null, null),

	// TODO falta implementar o restante de acordo com a tabela

	// CST_830
	CST_830001("830001", CST_830, "Documento com exclusão da BC da CBS e do IBS de energia elétrica fornecida pela distribuidora à UC",
				IND.P_RED_IBS_N, IND.P_RED_CBS_N, IND.RED_BC_N, IND.GTRIB_REG_N, IND.CRED_PRES_N, 
				IND.MONO_N,	IND.MONO_RETEN_N, IND.MONO_RET_N, IND.MONO_DIF_N, null, null);

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

  private NFNotaInfoImpostoTributacaoIBSCBSClassTrib(String codigo, NFNotaInfoImpostoTributacaoIBSCBS cst, String descricao, 
		  BigDecimal pRedIBS, BigDecimal pRedCBS, Integer indRedutorBC, Integer indGTribRegular, Integer indCredPres, 
		  Integer indMono, Integer indMonoReten, Integer indMonoRet, Integer indMonoDif, LocalDate dIniVig, LocalDate dFimVig) {
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
	    return Arrays.stream(NFNotaInfoImpostoTributacaoIBSCBSClassTrib.values())
	    			.filter(ibscbs -> ibscbs.getCodigo().equals(codigoIBSCBS))
	    				.findFirst().orElse(null);
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

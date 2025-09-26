package com.fincatto.documentofiscal.nfe400.classes;

import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTipoAliquotaIBSCBS.PADRAO;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTipoAliquotaIBSCBS.FIXA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTipoAliquotaIBSCBS.UNIFORME_SETORIAL;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTipoAliquotaIBSCBS.UNIFORME_NACIONAL;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTipoAliquotaIBSCBS.SEM_ALIQUOTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_000;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_010;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_011;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_200;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_210;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_220;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_221;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_222;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_400;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_410;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_510;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_550;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_620;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_800;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_810;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_820;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.NA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.ZERO;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.UM;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.TRINTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.QUARENTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.CINQUENTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.SESSENTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.SETENTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.OITENTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.CEM;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.S;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBSClassTrib.IND.NA_SN;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_830;
import static java.time.LocalDate.of;

import java.time.LocalDate;
import java.util.Arrays;
import java.math.BigDecimal;

/**
 * Enum que define os Codigos de Classificacao Tributaria cClass do IBS e CBS
 * CST_cClassTribPublicacao_20250618.xlsx 
 * Aba cClass
 * 
 * @author Edivaldo Merlo Stens
 * @author Marcos Lombardi de Andrade
 */
public enum NFNotaInfoImpostoTributacaoIBSCBSClassTrib {

	// CST_000
	CST_000001("000001", CST_000, "Situa\u00e7\u00f5es tributadas integralmente pelo IBS e CBS",
			null, PADRAO, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
  
	CST_000002("000002", CST_000, "Explora\u00e7\u00e3o de via",
				"Art. 11, VIII", PADRAO, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_000003("000003", CST_000, "Regime automotivo - projetos incentivados (art. 311)",
				"Art. 311", PADRAO, NA, NA, NA_SN, ZERO, UM, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_000004("000004", CST_000, "Regime automotivo - projetos incentivados (art. 312)",
				"Art. 312", PADRAO, NA, NA, NA_SN, ZERO, UM, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	// CST_010
	CST_010001("010001", CST_010, "Opera\u00e7\u00f5es do FGTS n\u00e3o realizadas pela Caixa Econ\u00f4mica Federal",
				"Art. 212", UNIFORME_SETORIAL, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_010002("010002", CST_010, "Opera\u00e7\u00f5es do servi\u00e7o financeiro",
				"Art. 233", UNIFORME_SETORIAL, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	// CST_011
	CST_011001("011001", CST_011, "Planos de assist\u00eancia funer\u00e1ria",
				"Art. 236", UNIFORME_NACIONAL, SESSENTA, SETENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_011002("011002", CST_011, "Planos de assist\u00eancia \u00e0 sa\u00fade",
				"Art. 237", UNIFORME_NACIONAL, SETENTA, SETENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_011003("011003", CST_011, "Intermedia\u00e7\u00e3o de planos de assist\u00eancia \u00e0 sa\u00fade",
				"Art. 240", UNIFORME_NACIONAL, SETENTA, SETENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_011004("011004", CST_011, "Concursos e progn\u00f3sticos",
				"Art. 246", UNIFORME_NACIONAL, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_011005("011005", CST_011, "Planos de assist\u00eancia \u00e0 sa\u00fade de animais dom\u00e9sticos",
				"Art. 243", UNIFORME_NACIONAL, TRINTA, TRINTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	// CST_200
	CST_200001("200001", CST_200, "Aquisi\u00e7\u00f5es realizadas entre empresas autorizadas a operar em zonas de processamento de exporta\u00e7\u00e3o",
				"Art. 103", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_200002("200002", CST_200, "Fornecimento ou importa\u00e7\u00e3o para produtor rural n\u00e3o contribuinte ou TAC",
				"Art. 110", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_200003("200003", CST_200, "Vendas de produtos destinados \u00e0 alimenta\u00e7\u00e3o humana (Anexo I)",
				"Art. 125", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_200004("200004", CST_200, "Venda de dispositivos m\u00e9dicos com a especifica\u00e7\u00e3o das respectivas classifica\u00e7\u00f5es da NCM/SH previstas no Anexo XII da Lei Complementar nº 214, de 2025, observado o art. 144 da Lei Complementar nº 214, de 2025",
				"Art. 144, I", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_200005("200005", CST_200, "Venda de dispositivos m\u00e9dicos adquiridos por \u00f3rg\u00e3os da administra\u00e7\u00e3o p\u00fablica (Anexo IV)",
				"Art. 144, II", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_200006("200006", CST_200, "Situa\u00e7\u00e3o de emerg\u00eancia de sa\u00fade p\u00fablica reconhecida pelo Poder p\u00fablico (Anexo XII)",
				"Art. 144, § 3º", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_200007("200007", CST_200, "Fornecimento dos dispositivos de acessibilidade pr\u00f3prios para pessoas com defici\u00eancia (Anexo XIII)",
				"Art. 145, I", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	  
	CST_200008("200008", CST_200, "Fornecimento dos dispositivos de acessibilidade pr\u00f3prios para pessoas com defici\u00eancia adquiridos por \u00f3rg\u00e3os da administra\u00e7\u00e3o p\u00fablica (Anexo V)",
				"Art. 145, II", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200009("200009", CST_200, "Fornecimento de medicamentos (Anexo XIV)", 
				"Art. 146", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200010("200010", CST_200, "Fornecimento dos medicamentos registrados na Anvisa, adquiridos por \u00f3rg\u00e3os da administra\u00e7\u00e3o p\u00fablica",
				"Art. 146, § 1º", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200011("200011", CST_200, "Fornecimento das composi\u00e7\u00f5es para nutri\u00e7\u00e3o enteral e parenteral quando adquiridas por \u00f3rg\u00e3os da administra\u00e7\u00e3o p\u00fablica (Anexo VI)",
				"Art. 146, § 2º", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200012("200012", CST_200, "Situa\u00e7\u00e3o de emerg\u00eancia de sa\u00fade p\u00fablica reconhecida pelo Poder p\u00fablico (Anexo XIV)",
				"Art. 146, § 4º", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200013("200013", CST_200, "Fornecimento de tamp\u00f5es higi\u00eanicos, absorventes higi\u00eanicos internos ou externos",
				"Art. 147", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200014("200014", CST_200, "Fornecimento dos produtos hort\u00edcolas, frutas e ovos (Anexo XV)", 
				"Art. 148", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200015("200015", CST_200, "Venda de autom\u00f3veis de passageiros de fabrica\u00e7\u00e3o nacional adquiridos por motoristas profissionais ou pessoas com defici\u00eancia",
				"Art. 149", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200016("200016", CST_200, "Presta\u00e7\u00e3o de servi\u00e7os de pesquisa e desenvolvimento por Institui\u00e7\u00e3o Cient\u00edfica, Tecnol\u00f3gica e de Inova\u00e7\u00e3o (ICT)",
				"Art. 156", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200017("200017", CST_200, "Opera\u00e7\u00f5es relacionadas ao FGTS", 
				"Art. 212, § 3º, I", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200018("200018", CST_200, "Opera\u00e7\u00f5es de resseguro e retrocess\u00e3o",
				"Art. 223, § 4º", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200019("200019", CST_200, "Importador dos servi\u00e7os financeiros contribuinte", 
				"Art. 231, § 1º, II", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200020("200020", CST_200, "Opera\u00e7\u00e3o praticada por sociedades cooperativas optantes por regime espec\u00edfico do IBS e CBS",
				"Art. 271", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200021("200021", CST_200, "Servi\u00e7os de transporte p\u00fablico coletivo de passageiros ferrovi\u00e1rio e hidrovi\u00e1rio",
				"Art. 285, I", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200022("200022", CST_200, "Opera\u00e7\u00e3o originada fora da ZFM que destine bem material industrializado a contribuinte estabelecido na ZFM",
				"Art. 445", PADRAO, CEM, CEM, NA_SN, UM, UM, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200023("200023", CST_200, "Opera\u00e7\u00e3o realizada por ind\u00fastria incentivada que destine bem material intermedi\u00e1rio para outra ind\u00fastria incentivada na ZFM",
				"Art. 448", PADRAO, CEM, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200024("200024", CST_200, "Opera\u00e7\u00e3o originada fora das \u00c1reas de Livre Com\u00e9rcio destinadas a contribuinte estabelecido nas \u00c1reas de Livre Com\u00e9rcio",
				"Art. 463", PADRAO, CEM, CEM, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200025("200025", CST_200, "Fornecimento dos servi\u00e7os de educa\u00e7\u00e3o relacionados ao Programa Universidade para Todos (Prouni)",
				"Art. 308", PADRAO, SESSENTA, CEM, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200026("200026", CST_200, "Loca\u00e7\u00e3o de im\u00f3veis localizados nas zonas reabilitadas", 
				"Art. 158, par\u00e1grafo \u00fanico", PADRAO, OITENTA, OITENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200027("200027", CST_200, "Opera\u00e7\u00f5es de loca\u00e7\u00e3o, cess\u00e3o onerosa e arrendamento de bens im\u00f3veis",
				"Art. 261, par\u00e1grafo \u00fanico", PADRAO, SETENTA, SETENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200028("200028", CST_200, "Fornecimento dos servi\u00e7os de educa\u00e7\u00e3o (Anexo II)", 
				"Art. 129", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200029("200029", CST_200, "Fornecimento dos servi\u00e7os de sa\u00fade humana (Anexo III)", 
				"Art. 130", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200030("200030", CST_200, "Venda dos dispositivos m\u00e9dicos  (Anexo IV)", 
				"Art. 131", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200031("200031", CST_200, "Fornecimento dos dispositivos de acessibilidade pr\u00f3prios para pessoas com defici\u00eancia (Anexo V)",
				"Art. 132", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200032("200032", CST_200, "Fornecimento dos medicamentos registrados na Anvisa ou produzidos por farm\u00e1cias de manipula\u00e7\u00e3o, ressalvados os medicamentos sujeitos \u00e0 al\u00edquota zero",
				"Art. 133", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200033("200033", CST_200, "Fornecimento das composi\u00e7\u00f5es para nutri\u00e7\u00e3o enteral e parenteral (Anexo VI)",
				"Art. 133, § 1º", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200034("200034", CST_200, "Fornecimento dos alimentos destinados ao consumo humano (Anexo VII)",
				"Art. 135", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200035("200035", CST_200, "Fornecimento dos produtos de higiene pessoal e limpeza (Anexo VIII)",
				"Art. 463", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200036("200036", CST_200, "Fornecimento de produtos agropecu\u00e1rios, aqu\u00edcolas, pesqueiros, florestais e extrativistas vegetais in natura",
				"Art. 137", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200037("200037", CST_200, "Fornecimento de servi\u00e7os ambientais de conserva\u00e7\u00e3o ou recupera\u00e7\u00e3o da vegeta\u00e7\u00e3o nativa", 
				"Art. 137, § 3º", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200038("200038", CST_200, "Fornecimento dos insumos agropecu\u00e1rios e aqu\u00edcolas (Anexo IX)", 
				"Art. 138", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200039("200039", CST_200, "Fornecimento dos servi\u00e7os e o licenciamento ou cess\u00e3o dos direitos destinados \u00e0s produ\u00e7\u00f5es nacionais art\u00edsticas (Anexo X)",
				"Art. 139", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200040("200040", CST_200, "Fornecimento de servi\u00e7os de comunica\u00e7\u00e3o institucional \u00e0 administra\u00e7\u00e3o p\u00fablica",
				"Art. 140", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200041("200041", CST_200, "Fornecimento de servi\u00e7o de educa\u00e7\u00e3o desportiva (art. 141. I)", 
				"Art. 141, I", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200042("200042", CST_200, "Fornecimento de servi\u00e7o de educa\u00e7\u00e3o desportiva (art. 141. II)", 
				"Art. 141, II", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200043("200043", CST_200,"Fornecimento \u00e0 administra\u00e7\u00e3o p\u00fablica dos servi\u00e7os e dos bens relativos \u00e0 soberania (Anexo XI)",
				"Art. 142, I", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200044("200044", CST_200, "Opera\u00e7\u00f5es e presta\u00e7\u00f5es de servi\u00e7os de seguran\u00e7a da informa\u00e7\u00e3o e seguran\u00e7a cibern\u00e9tica desenvolvidos por sociedade que tenha s\u00f3cio brasileiro (Anexo XI)",
				"Art. 142, II", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200045("200045", CST_200, "Opera\u00e7\u00f5es relacionadas a projetos de reabilita\u00e7\u00e3o urbana de zonas hist\u00f3ricas e de \u00e1reas cr\u00edticas de recupera\u00e7\u00e3o e reconvers\u00e3o urban\u00edstica",
				"Art. 158", PADRAO, SESSENTA, SESSENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200046("200046", CST_200, "Opera\u00e7\u00f5es com bens im\u00f3veis", 
				"Art. 261", PADRAO, CINQUENTA, CINQUENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200047("200047", CST_200, "Bares e Restaurantes", 
				"Art. 275", PADRAO, QUARENTA, QUARENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200048("200048", CST_200, "Hotelaria, Parques de Divers\u00e3o e Parques Tem\u00e1ticos", 
				"Art. 281",PADRAO, QUARENTA, QUARENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200049("200049", CST_200, "Transporte coletivo de passageiros rodovi\u00e1rio, ferrovi\u00e1rio e hidrovi\u00e1rio",
				"Art. 286",PADRAO, QUARENTA, QUARENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200450("200450", CST_200, "Servi\u00e7os de transporte a\u00e9reo regional coletivo de passageiros ou de carga",
				"Art. 287",PADRAO, QUARENTA, QUARENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200051("200051", CST_200, "Ag\u00eancias de Turismo", 
				"Art. 289, II",PADRAO, QUARENTA, QUARENTA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_200052("200052", CST_200, "Presta\u00e7\u00e3o de servi\u00e7os de profiss\u00f5es intelectuais", 
				"Art. 127, I a XVIII", PADRAO, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_210001("210001", CST_210, "Redutor social aplicado uma \u00fanica vez na aliena\u00e7\u00e3o de bem im\u00f3vel residencial novo",
				"Arts. 259 e 261", PADRAO, CINQUENTA, CINQUENTA, S, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_210002("210002", CST_210, "Redutor social aplicado uma \u00fanica vez na aliena\u00e7\u00e3o de lote residencial",
				"Arts. 259 e 261", PADRAO, CINQUENTA, CINQUENTA, S, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_210003("210003", CST_210, "Redutor social em opera\u00e7\u00f5es de loca\u00e7\u00e3o, cess\u00e3o onerosa e arrendamento de bens im\u00f3veis de uso residencial",
				"Art. 260", PADRAO, NA, SETENTA, S, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),

	// CST_220
	CST_220001("220001", CST_220, "Incorpora\u00e7\u00e3o imobili\u00e1ria submetida ao regime especial de tributa\u00e7\u00e3o",
				"Art. 485, I", FIXA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_220002("220002", CST_220, "Incorpora\u00e7\u00e3o imobili\u00e1ria submetida ao regime especial de tributa\u00e7\u00e3o",
				"Art. 485, II", FIXA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_220003("220003", CST_220, "Aliena\u00e7\u00e3o de im\u00f3vel decorrente de parcelamento do solo",
				"Art. 486", FIXA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	// CST_221
	CST_221001("221001", CST_221, "Loca\u00e7\u00e3o, cess\u00e3o onerosa ou arrendamento de bem im\u00f3vel com al\u00edquota sobre a receita bruta",
				"Art. 487, § 2º", FIXA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	// CST_222
	CST_222001("222001", CST_222, "Transporte internacional de passageiros, caso os trechos de ida e volta sejam vendidos em conjunto",
				"Art. 12 § 8º", PADRAO, NA, NA, S, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 6, 11)),
	
	// CST_400
	CST_400001("400001", CST_400, "Fornecimento de servi\u00e7os de transporte p\u00fablico coletivo de passageiros rodovi\u00e1rio e metrovi\u00e1rio",
				"Art. 157", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),

	// CST_410 
	CST_410001("410001", CST_410, "Fornecimento de bonifica\u00e7\u00f5es quando constem no documento fiscal e que n\u00e3o dependam de evento posterior",
				"Art. 5º, § 1º, I", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410002("410002", CST_410, "Transfer\u00eancias entre estabelecimentos pertencentes ao mesmo contribuinte",
				"Art. 6º, II", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410003("410003", CST_410, "Doa\u00e7\u00f5es sem contrapresta\u00e7\u00e3o em benef\u00edcio do doador",
				"Art. 6º, VIII", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410004("410004", CST_410, "Exporta\u00e7\u00f5es de bens e servi\u00e7os",
				"Art. 8º", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410005("410005", CST_410, "Fornecimentos realizados pela Uni\u00e3o, pelos Estados, pelo Distrito Federal e pelos Munic\u00edpios",
				"Art. 9º, I e § 1º", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410006("410006", CST_410, "Fornecimentos realizados por entidades religiosas e templos de qualquer culto",
				"Art. 9º, II", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410007("410007", CST_410, "Fornecimentos realizados por partidos pol\u00edticos",
				"Art. 9º, III", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410008("410008", CST_410, "Fornecimentos de livros, jornais, peri\u00f3dicos e do papel destinado a sua impress\u00e3o",
				"Art. 9º, IV", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410009("410009", CST_410, "Fornecimentos de fonogramas e videofonogramas musicais produzidos no Brasil",
				"Art. 9º, V", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410010("410010", CST_410, "Fornecimentos de servi\u00e7o de comunica\u00e7\u00e3o nas modalidades de radiodifus\u00e3o sonora e de sons e imagens de recep\u00e7\u00e3o livre e gratuita",
				"Art. 9º, VI", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410011("410011", CST_410, "Fornecimentos de ouro, quando definido em lei como ativo financeiro ou instrumento cambial",
				"Art. 9º, VII", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410012("410012", CST_410, "Fornecimento de condom\u00ednio edil\u00edcio n\u00e3o optante pelo regime regular",
				"Art. 26, § 2º, II", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410013("410013", CST_410, "Exporta\u00e7\u00f5es de combust\u00edveis",
				"Art. 98", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410014("410014", CST_410, "Fornecimento de produtor rural n\u00e3o contribuinte",
				"Art. 164", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, UM, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410015("410015", CST_410, "Fornecimento por transportador aut\u00f4nomo n\u00e3o contribuinte",
				"Art. 169", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, UM, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410016("410016", CST_410, "Fornecimento de produtor rural n\u00e3o contribuinte",
				"Art. 170", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410017("410017", CST_410, "Aquisi\u00e7\u00e3o de bem m\u00f3vel com cr\u00e9dito presumido sob condi\u00e7\u00e3o de revenda realizada",
				"Art. 171", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, UM, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410018("410018", CST_410, "Opera\u00e7\u00f5es relacionadas aos fundos garantidores e executores de pol\u00edticas p\u00fablicas",
				"Art. 213", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410019("410019", CST_410, "Exclus\u00e3o da gorjeta na base de c\u00e1lculo no fornecimento de alimenta\u00e7\u00e3o",
				"Art. 274, I", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410020("410020", CST_410, "Exclus\u00e3o do valor de intermedia\u00e7\u00e3o na base de c\u00e1lculo no fornecimento de alimenta\u00e7\u00e3o",
				"Art. 274, II", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_410021("410021", CST_410, "Contribui\u00e7\u00e3o de que trata o art. 149-A da Constitui\u00e7\u00e3o Federal",
				"Art. 12 § 2º", SEM_ALIQUOTA, NA, NA, NA_SN, NA, NA, NA, NA, NA, NA, null, null, of(2025, 6, 11)),
	
	CST_410999("410999", CST_410, "Opera\u00e7\u00f5es n\u00e3o onerosas sem previs\u00e3o de tributa\u00e7\u00e3o, n\u00e3o especificadas anteriormente",
				"Art. 4º, § 1º", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 6, 11)),
	
	// CST_510
	CST_510001("510001", CST_510, "Opera\u00e7\u00f5es, sujeitas a diferimento, com energia el\u00e9trica, relativas \u00e0 gera\u00e7\u00e3o, comercializa\u00e7\u00e3o, distribui\u00e7\u00e3o e transmiss\u00e3o",
				"Art. 28, § 1º", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_510002("510002", CST_510, "Opera\u00e7\u00f5es, sujeitas a diferimento, com insumos agropecu\u00e1rios e aqu\u00edcolas destinados a produtor rural contribuinte (Anexo IX)",
				"Art. 138, § 2º", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	// CST_550
	CST_550001("550001", CST_550, "Exporta\u00e7\u00f5es de bens materiais",
				"Art. 82", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550002("550002", CST_550, "Regime de Tr\u00e2nsito",
				"Art. 84", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550003("550003", CST_550, "Regimes de Dep\u00f3sito  (art. 85)",
				"Art. 85", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550004("550004", CST_550, "Regimes de Dep\u00f3sito (art. 87)",
				"Art. 87", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550005("550005", CST_550, "Regimes de Dep\u00f3sito (art. 87, Par\u00e1grafo \u00fanico)",
				"Art. 87, par\u00e1grafo \u00fanico", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550006("550006", CST_550, "Regimes de Perman\u00eancia Tempor\u00e1ria",
				"Art. 88", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550007("550007", CST_550, "Regimes de Aperfei\u00e7oamento",
				"Art. 90", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550008("550008", CST_550, "Importa\u00e7\u00e3o de bens para o Regime de Repetro-Tempor\u00e1rio",
				"Art. 93, I", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550009("550009", CST_550, "GNL-Tempor\u00e1rio",
				"Art. 93, II", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550010("550010", CST_550, "Repetro-Permanente",
				"Art. 93, III", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550011("550011", CST_550, "Repetro-Industrializa\u00e7\u00e3o",
				"550005", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550012("550012", CST_550, "Repetro-Nacional",
				"Art. 93, V", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550013("550013", CST_550, "Repetro-Entreposto",
				"Art. 93, VI", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550014("550014", CST_550, "Zona de Processamento de Exporta\u00e7\u00e3o",
				"Arts. 99, 100 e 102", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550015("550015", CST_550, "Regime Tribut\u00e1rio para Incentivo \u00e0 Moderniza\u00e7\u00e3o e \u00e0 Amplia\u00e7\u00e3o da Estrutura Portu\u00e1ria",
				"Art. 105", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550016("550016", CST_550, "Regime Especial de Incentivos para o Desenvolvimento da Infraestrutura",
				"Art. 106", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550017("550017", CST_550, "Regime Tribut\u00e1rio para Incentivo \u00e0 Atividade Econ\u00f4mica Naval",
				"Art. 107", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550018("550018", CST_550, "Desonera\u00e7\u00e3o da aquisi\u00e7\u00e3o de bens de capital",
				"Art. 109", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550019("550019", CST_550, "Importa\u00e7\u00e3o de bem material por ind\u00fastria incentivada para utiliza\u00e7\u00e3o na ZFM",
				"Art. 443", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_550020("550020", CST_550, "\u00c1reas de livre com\u00e9rcio",
				"Art. 461", SEM_ALIQUOTA, NA, NA, NA_SN, UM, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),

	// CST_620
	CST_620001("620001", CST_620, "Tributa\u00e7\u00e3o monof\u00e1sica sobre combust\u00edveis",
				"Art. 172, 179 I", UNIFORME_SETORIAL, NA, NA, NA_SN, ZERO, NA, UM, ZERO, ZERO, ZERO, null, null, of(2025, 5, 19)),
	
	CST_620002("620002", CST_620, "Tributa\u00e7\u00e3o monof\u00e1sica com responsabilidade pela reten\u00e7\u00e3o sobre combust\u00edveis",
				"Art. 178", UNIFORME_SETORIAL, NA, NA, NA_SN, ZERO, NA, UM, UM, ZERO, ZERO, null, null, of(2025, 5, 19)),
	
	CST_620003("620003", CST_620, "Tributa\u00e7\u00e3o monof\u00e1sica com tributos retidos por responsabilidade sobre combust\u00edveis",
				"Art. 178", UNIFORME_SETORIAL, NA, NA, NA_SN, ZERO, NA, ZERO, ZERO, ZERO, UM, null, null, of(2025, 5, 19)),
	
	CST_620004("620004", CST_620, "Tributa\u00e7\u00e3o monof\u00e1sica sobre mistura de EAC com gasolina A em percentual superior ao obrigat\u00f3rio",
				"Art. 179, II, a", UNIFORME_SETORIAL, NA, NA, NA_SN, ZERO, NA, UM, ZERO, UM, ZERO, null, null, of(2025, 5, 19)),
	
	CST_620005("620005", CST_620, "Tributa\u00e7\u00e3o monof\u00e1sica sobre mistura de EAC com gasolina A em percentual inferior ao obrigat\u00f3rio",
				"Art. 179, II, b", UNIFORME_SETORIAL, NA, NA, NA_SN, ZERO, NA, ZERO, ZERO, UM, ZERO, null, null, of(2025, 5, 19)),
	
	CST_620006("620006", CST_620, "Tributa\u00e7\u00e3o monof\u00e1sica sobre combust\u00edveis cobrada anteriormente",
				"Art. 180", UNIFORME_SETORIAL, NA, NA, NA_SN, ZERO, NA, ZERO, ZERO, UM, ZERO, null, null, of(2025, 5, 19)),
	
	// CST_800
	CST_800001("800001", CST_800, "Fus\u00e3o, cis\u00e3o ou incorpora\u00e7\u00e3o",
				"Art. 55", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_800002("800002", CST_800, "Transfer\u00eancia de cr\u00e9dito do associado, inclusive as cooperativas singulares",
				"Art. 272", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	// CST_810
	CST_810001("810001", CST_810, "Cr\u00e9dito presumido sobre o valor apurado nos fornecimentos a partir da ZFM",
				"Art. 450", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, UM, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	// CST_820
	CST_820001("820001", CST_820, "Documento com informa\u00e7\u00f5es de fornecimento de servi\u00e7os de planos de assist\u00eancia \u00e0 sa\u00fade",
				"Art. 235", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_820002("820002", CST_820, "Documento com informa\u00e7\u00f5es de fornecimento de servi\u00e7os de planos de assist\u00eancia funer\u00e1ria",
				"Art. 236", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),

	CST_820003("820003", CST_820, "Documento com informa\u00e7\u00f5es de fornecimento de servi\u00e7os de planos de assist\u00eancia \u00e0 sa\u00fade de animais dom\u00e9sticos",
				"Art. 243", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_820004("820004", CST_820, "Documento com informa\u00e7\u00f5es de presta\u00e7\u00e3o de servi\u00e7os de consursos de progn\u00f3sticos",
				"Art. 248", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_820005("820005", CST_820, "Documento com informa\u00e7\u00f5es de aliena\u00e7\u00e3o de bens im\u00f3veis",
				"Art. 254, § 1º", SEM_ALIQUOTA, NA, NA, NA_SN, ZERO, NA, NA, NA, NA, NA, null, null, of(2025, 5, 19)),
	
	CST_820006("820006", CST_820, "Documento com informa\u00e7\u00f5es de fornecimento de servi\u00e7os de explora\u00e7\u00e3o de via",
				"Art. 11, VIII", SEM_ALIQUOTA, NA, NA, NA_SN, NA, NA, NA, NA, NA, NA, null, null, of(2025, 6, 11)),
	
	// CST_830
	CST_830001("830001", CST_830, "Documento com exclus\u00e3o da BC da CBS e do IBS de energia el\u00e9trica fornecida pela distribuidora \u00e0 UC",
				"Art 28, par\u00e1grafos 3° e 4°", SEM_ALIQUOTA, NA, NA, NA_SN, NA, NA, NA, NA, NA, NA, null, null, of(2025, 6, 11));
	
	private final String codigo;
	private final NFNotaInfoImpostoTributacaoIBSCBS cst;
	private final String descricao;
	private final String leiComplementar;
	private final NFNotaInfoImpostoTipoAliquotaIBSCBS tipoAliquota;
	private final BigDecimal pRedIBS;
	private final BigDecimal pRedCBS;
	private final Boolean indRedutorBC;
	private final BigDecimal indGTribRegular;
	private final BigDecimal indCredPres;
	private final BigDecimal indMono;
	private final BigDecimal indMonoReten;
	private final BigDecimal indMonoRet;
	private final BigDecimal indMonoDif;
	private final LocalDate dIniVig;
	private final LocalDate dFimVig;
	private final LocalDate dataAtualizacao;

	private NFNotaInfoImpostoTributacaoIBSCBSClassTrib(String codigo, NFNotaInfoImpostoTributacaoIBSCBS cst,
			String descricao, String leiComplementar, NFNotaInfoImpostoTipoAliquotaIBSCBS tipoAliquota,
			BigDecimal pRedIBS, BigDecimal pRedCBS,
			Boolean indRedutorBC, BigDecimal indGTribRegular,
			BigDecimal indCredPres, BigDecimal indMono,
			BigDecimal indMonoReten, BigDecimal indMonoRet,
			BigDecimal indMonoDif, LocalDate dIniVig, LocalDate dFimVig,
			LocalDate dataAtualizacao) {
		this.codigo = codigo;
		this.cst = cst;
		this.descricao = descricao;
		this.leiComplementar = leiComplementar;
		this.tipoAliquota = tipoAliquota;
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
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public NFNotaInfoImpostoTributacaoIBSCBS getCst() {
		return cst;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public LocalDate getdFimVig() {
		return dFimVig;
	}

	public LocalDate getdIniVig() {
		return dIniVig;
	}

	public BigDecimal getIndCredPres() {
		return indCredPres;
	}

	public BigDecimal getIndGTribRegular() {
		return indGTribRegular;
	}

	public BigDecimal getIndMono() {
		return indMono;
	}

	public BigDecimal getIndMonoDif() {
		return indMonoDif;
	}

	public BigDecimal getIndMonoRet() {
		return indMonoRet;
	}

	public BigDecimal getIndMonoReten() {
		return indMonoReten;
	}

	public Boolean getIndRedutorBC() {
		return indRedutorBC;
	}

	public String getLeiComplementar() {
		return leiComplementar;
	}

	public BigDecimal getpRedCBS() {
		return pRedCBS;
	}

	public BigDecimal getpRedIBS() {
		return pRedIBS;
	}

	public NFNotaInfoImpostoTipoAliquotaIBSCBS getTipoAliquota() {
		return tipoAliquota;
	}

	/**
	 * Verifica se o codigo esta vigente com base na data atual.
	 *
	 * @return true se estiver vigente, false caso contrario.
	 */
	public boolean isVigente() {
		LocalDate hoje = LocalDate.now();
		return (dIniVig == null || !hoje.isBefore(dIniVig)) && (dFimVig == null || !hoje.isAfter(dFimVig));
	}

	/**
	 * Verifica se o codigo esta vigente com base na data passada por parametro.
	 *
	 * @param inDate
	 * @return true se estiver vigente, false caso contrario.
	 */
	public boolean isVigente(LocalDate inDate) {
		return (dIniVig == null || !inDate.isBefore(dIniVig)) && (dFimVig == null || !inDate.isAfter(dFimVig));
	}

	@Override
	public String toString() {
		return codigo + " - " + descricao;
	}
	
	/**
	 * Retorna o enum correspondente ao codigo IBSCBS informado.
	 *
	 * @param codigoIBSCBS o codigo IBSCBS a ser pesquisado
	 * @return o enum correspondente ou null se nao encontrado
	 */
	public static NFNotaInfoImpostoTributacaoIBSCBSClassTrib valueOfCodigo(final String codigoIBSCBS) {
	    return Arrays.stream(NFNotaInfoImpostoTributacaoIBSCBSClassTrib.values())
	    			.filter(ibscbs -> ibscbs.getCodigo().equals(codigoIBSCBS))
	    				.findFirst().orElse(null);
	}
	
	static class IND {

		static final BigDecimal NA = null;
		static final BigDecimal ZERO = new BigDecimal("0");
		static final BigDecimal UM = new BigDecimal("1");
		static final BigDecimal TRINTA = new BigDecimal("30");
		static final BigDecimal QUARENTA = new BigDecimal("40");
		static final BigDecimal CINQUENTA = new BigDecimal("50");
		static final BigDecimal SESSENTA = new BigDecimal("60");
		static final BigDecimal SETENTA = new BigDecimal("70");
		static final BigDecimal OITENTA = new BigDecimal("80");
		static final BigDecimal CEM = new BigDecimal("100");
		static final Boolean S = true;
		static final Boolean N = false;
		static final Boolean NA_SN = null;
		
	}
	
}

package com.fincatto.documentofiscal.nfe400.classes;

import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTipoAliquotaIBSCBS.PADRAO;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTipoAliquotaIBSCBS.UNIFORME_SETORIAL;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTipoAliquotaIBSCBS.UNIFORME_NACIONAL;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTipoAliquotaIBSCBS.SEM_ALIQUOTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoAliquotaIBSCBS.NA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoAliquotaIBSCBS.ZERO;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoAliquotaIBSCBS.UM;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoAliquotaIBSCBS.TRINTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoAliquotaIBSCBS.QUARENTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoAliquotaIBSCBS.CINQUENTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoAliquotaIBSCBS.SESSENTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoAliquotaIBSCBS.SETENTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoAliquotaIBSCBS.OITENTA;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoAliquotaIBSCBS.CEM;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_000;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_010;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_011;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_200;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_210;
import static com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoIBSCBS.CST_830;

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
				null, PADRAO, NA, NA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_000002("000002", CST_000, "Exploração de via",
				"Art. 11, VIII", PADRAO, NA, NA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_000003("000003", CST_000, "Regime automotivo - projetos incentivados (art. 311)",
				"Art. 311", PADRAO, NA, NA, NA, ZERO, UM, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_000004("000004", CST_000, "Regime automotivo - projetos incentivados (art. 312)",
				"Art. 312", PADRAO, NA, NA, NA, ZERO, UM, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	// CST_010
	CST_010001("010001", CST_010, "Operações do FGTS não realizadas pela Caixa Econômica Federal",
				"Art. 212", UNIFORME_SETORIAL, NA, NA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_010002("010002", CST_010, "Operações do serviço financeiro",
				"Art. 233", UNIFORME_SETORIAL, NA, NA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	// CST_011
	CST_011001("011001", CST_011, "Planos de assistência funerária.",
				"Art. 236", UNIFORME_NACIONAL, SESSENTA, SETENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_011002("011002", CST_011, "Planos de assistência à saúde",
				"Art. 237", UNIFORME_NACIONAL, SETENTA, SETENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_011003("011003", CST_011, "Intermediação de planos de assistência à saúde",
				"Art. 240", UNIFORME_NACIONAL, SETENTA, SETENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_011004("011004", CST_011, "Concursos e prognósticos",
				"Art. 246", UNIFORME_NACIONAL, NA, NA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_011005("011005", CST_011, "Planos de assistência à saúde de animais domésticos",
				"Art. 243", UNIFORME_NACIONAL, TRINTA, TRINTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	// CST_200
	CST_200001("200001", CST_200, "Aquisições realizadas entre empresas autorizadas a operar em zonas de processamento de exportação",
				"Art. 103", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_200002("200002", CST_200, "Fornecimento ou importação para produtor rural não contribuinte ou TAC",
				"Art. 110", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_200003("200003", CST_200, "Vendas de produtos destinados à alimentação humana (Anexo I)",
				"Art. 125", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_200004("200004", CST_200, "Venda de dispositivos médicos com a especificação das respectivas classificações da NCM/SH previstas no Anexo XII da Lei Complementar nº 214, de 2025, observado o art. 144 da Lei Complementar nº 214, de 2025.",
				"Art. 144, I", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_200005("200005", CST_200, "Venda de dispositivos médicos adquiridos por órgãos da administração pública (Anexo IV).",
				"Art. 144, II", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_200006("200006", CST_200, "Situação de emergência de saúde pública reconhecida pelo Poder público (Anexo XII).",
				"Art. 144, § 3º", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_200007("200007", CST_200, "Fornecimento dos dispositivos de acessibilidade próprios para pessoas com deficiência (Anexo XIII).",
				"Art. 145, I", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	  
	CST_200008("200008", CST_200, "Fornecimento dos dispositivos de acessibilidade próprios para pessoas com deficiência adquiridos por órgãos da administração pública (Anexo V).",
				"Art. 145, II", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200009("200009", CST_200, "Fornecimento de medicamentos (Anexo XIV).", 
				"Art. 146", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200010("200010", CST_200, "Fornecimento dos medicamentos registrados na Anvisa, adquiridos por órgãos da administração pública.",
				"Art. 146, § 1º", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200011("200011", CST_200, "Fornecimento das composições para nutrição enteral e parenteral quando adquiridas por órgãos da administração pública (Anexo VI)",
				"Art. 146, § 2º", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200012("200012", CST_200, "Situação de emergência de saúde pública reconhecida pelo Poder público (Anexo XIV)",
				"Art. 146, § 4º", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200013("200013", CST_200, "Fornecimento de tampões higiênicos, absorventes higiênicos internos ou externos",
				"Art. 147", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200014("200014", CST_200, "Fornecimento dos produtos hortícolas, frutas e ovos (Anexo XV)", 
				"Art. 148", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200015("200015", CST_200, "Venda de automóveis de passageiros de fabricação nacional adquiridos por motoristas profissionais ou pessoas com deficiência",
				"Art. 149", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200016("200016", CST_200, "Prestação de serviços de pesquisa e desenvolvimento por Instituição Científica, Tecnológica e de Inovação (ICT)",
				"Art. 156", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200017("200017", CST_200, "Operações relacionadas ao FGTS", 
				"Art. 212, § 3º, I", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200018("200018", CST_200, "Operações de resseguro e retrocessão",
				"Art. 223, § 4º", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200019("200019", CST_200, "Importador dos serviços financeiros contribuinte", 
				"Art. 231, § 1º, II", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200020("200020", CST_200, "Operação praticada por sociedades cooperativas optantes por regime específico do IBS e CBS",
				"Art. 271", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200021("200021", CST_200, "Serviços de transporte público coletivo de passageiros ferroviário e hidroviário",
				"Art. 285, I", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200022("200022", CST_200, "Operação originada fora da ZFM que destine bem material industrializado a contribuinte estabelecido na ZFM",
				"Art. 445", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200023("200023", CST_200, "Operação realizada por indústria incentivada que destine bem material intermediário para outra indústria incentivada na ZFM",
				"Art. 448", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200024("200024", CST_200, "Operação originada fora das Áreas de Livre Comércio destinadas a contribuinte estabelecido nas Áreas de Livre Comércio",
				"Art. 463", PADRAO, CEM, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200025("200025", CST_200, "Fornecimento dos serviços de educação relacionados ao Programa Universidade para Todos (Prouni)",
				"Art. 308", PADRAO, SESSENTA, CEM, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200026("200026", CST_200, "Locação de imóveis localizados nas zonas reabilitadas", 
				"Art. 158, parágrafo único", PADRAO, OITENTA, OITENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200027("200027", CST_200, "Operações de locação, cessão onerosa e arrendamento de bens imóveis",
				"Art. 261, parágrafo único", PADRAO, SETENTA, SETENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200028("200028", CST_200, "Fornecimento dos serviços de educação (Anexo II)", 
				"Art. 129", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200029("200029", CST_200, "Fornecimento dos serviços de saúde humana (Anexo III)", 
				"Art. 130", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200030("200030", CST_200, "Venda dos dispositivos médicos  (Anexo IV)", 
				"Art. 131", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200031("200031", CST_200, "Fornecimento dos dispositivos de acessibilidade próprios para pessoas com deficiência (Anexo V)",
				"Art. 132", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200032("200032", CST_200, "Fornecimento dos medicamentos registrados na Anvisa ou produzidos por farmácias de manipulação, ressalvados os medicamentos sujeitos à alíquota zero",
				"Art. 133", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200033("200033", CST_200, "Fornecimento das composições para nutrição enteral e parenteral (Anexo VI)",
				"Art. 133, § 1º", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200034("200034", CST_200, "Fornecimento dos alimentos destinados ao consumo humano (Anexo VII)",
				"Art. 135", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200035("200035", CST_200, "Fornecimento dos produtos de higiene pessoal e limpeza (Anexo VIII)",
				"Art. 463", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200036("200036", CST_200, "Fornecimento de produtos agropecuários, aquícolas, pesqueiros, florestais e extrativistas vegetais in natura",
				"Art. 137", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200037("200037", CST_200, "Fornecimento de serviços ambientais de conservação ou recuperação da vegetação nativa", 
				"Art. 137, § 3º", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200038("200038", CST_200, "Fornecimento dos insumos agropecuários e aquícolas (Anexo IX)", 
				"Art. 138", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200039("200039", CST_200, "Fornecimento dos serviços e o licenciamento ou cessão dos direitos destinados às produções nacionais artísticas (Anexo X)",
				"Art. 139", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200040("200040", CST_200, "Fornecimento de serviços de comunicação institucional à administração pública",
				"Art. 140", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200041("200041", CST_200, "Fornecimento de serviço de educação desportiva (art. 141. I)", 
				"Art. 141, I", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200042("200042", CST_200, "Fornecimento de serviço de educação desportiva (art. 141. II)", 
				"Art. 141, II", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200043("200043", CST_200,"Fornecimento à administração pública dos serviços e dos bens relativos à soberania (Anexo XI)",
				"Art. 142, I", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200044("200044", CST_200, "Operações e prestações de serviços de segurança da informação e segurança cibernética desenvolvidos por sociedade que tenha sócio brasileiro (Anexo XI)",
				"Art. 142, II", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200045("200045", CST_200, "Operações relacionadas a projetos de reabilitação urbana de zonas históricas e de áreas críticas de recuperação e reconversão urbanística",
				"Art. 158", PADRAO, SESSENTA, SESSENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200046("200046", CST_200, "Operações com bens imóveis", 
				"Art. 261", PADRAO, CINQUENTA, CINQUENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200047("200047", CST_200, "Bares e Restaurantes", 
				"Art. 275", PADRAO, QUARENTA, QUARENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200048("200048", CST_200, "Hotelaria, Parques de Diversão e Parques Temáticos", 
				"Art. 281",PADRAO, QUARENTA, QUARENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200049("200049", CST_200, "Transporte coletivo de passageiros rodoviário, ferroviário e hidroviário",
				"Art. 286",PADRAO, QUARENTA, QUARENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200450("200450", CST_200, "Serviços de transporte aéreo regional coletivo de passageiros ou de carga",
				"Art. 287",PADRAO, QUARENTA, QUARENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200051("200051", CST_200, "Agências de Turismo", 
				"Art. 289, II",PADRAO, QUARENTA, QUARENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_200052("200052", CST_200, "Prestação de serviços de profissões intelectuais", 
				"Art. 127, I a XVIII", PADRAO, NA, NA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_210001("210001", CST_210, "Redutor social aplicado uma única vez na alienação de bem imóvel residencial novo",
				"Arts. 259 e 261", PADRAO, CINQUENTA, CINQUENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_210002("210002", CST_210, "Redutor social aplicado uma única vez na alienação de lote residencial",
				"Arts. 259 e 261", PADRAO, CINQUENTA, CINQUENTA, NA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),
	
	CST_210003("210003", CST_210, "Redutor social em operações de locação, cessão onerosa e arrendamento de bens imóveis de uso residencial",
				"Art. 260", PADRAO, NA, SETENTA, SETENTA, ZERO, null, null, null, null, null, null, null, toLocalDate(19, 5, 2025)),

	// TODO falta implementar o restante de acordo com a tabela

	// CST_830
	CST_830001("830001", CST_830, "Documento com exclusão da BC da CBS e do IBS de energia elétrica fornecida pela distribuidora à UC",
				"Art 28, parágrafos 3° e 4°", SEM_ALIQUOTA, NA, NA, NA, null, null, null, null, null, null, null, null, toLocalDate(11, 6, 2025));

	public static LocalDate toLocalDate(int dia, int mes, int ano) {
		return LocalDate.of(ano, mes, dia);
	}
	
	public static NFNotaInfoImpostoTributacaoIBSCBSClassTrib valueOfCodigo(final String codigoIBSCBS) {
	    return Arrays.stream(NFNotaInfoImpostoTributacaoIBSCBSClassTrib.values())
	    			.filter(ibscbs -> ibscbs.getCodigo().equals(codigoIBSCBS))
	    				.findFirst().orElse(null);
	}
	
	private final String codigo;
	private final NFNotaInfoImpostoTributacaoIBSCBS cst;
	private final String descricao;
	private final String leiComplementar;
	private final NFNotaInfoImpostoTipoAliquotaIBSCBS tipoAliquota;
	private final NFNotaInfoImpostoAliquotaIBSCBS pRedIBS;
	private final NFNotaInfoImpostoAliquotaIBSCBS pRedCBS;
	private final NFNotaInfoImpostoAliquotaIBSCBS indRedutorBC;
	private final NFNotaInfoImpostoAliquotaIBSCBS indGTribRegular;
	private final NFNotaInfoImpostoAliquotaIBSCBS indCredPres;
	private final NFNotaInfoImpostoAliquotaIBSCBS indMono;
	private final NFNotaInfoImpostoAliquotaIBSCBS indMonoReten;
	private final NFNotaInfoImpostoAliquotaIBSCBS indMonoRet;
	private final NFNotaInfoImpostoAliquotaIBSCBS indMonoDif;
	private final LocalDate dIniVig;
	private final LocalDate dFimVig;
	private final LocalDate dataAtualizacao;

	private NFNotaInfoImpostoTributacaoIBSCBSClassTrib(String codigo, NFNotaInfoImpostoTributacaoIBSCBS cst,
			String descricao, String leiComplementar, NFNotaInfoImpostoTipoAliquotaIBSCBS tipoAliquota,
			NFNotaInfoImpostoAliquotaIBSCBS pRedIBS, NFNotaInfoImpostoAliquotaIBSCBS pRedCBS,
			NFNotaInfoImpostoAliquotaIBSCBS indRedutorBC, NFNotaInfoImpostoAliquotaIBSCBS indGTribRegular,
			NFNotaInfoImpostoAliquotaIBSCBS indCredPres, NFNotaInfoImpostoAliquotaIBSCBS indMono,
			NFNotaInfoImpostoAliquotaIBSCBS indMonoReten, NFNotaInfoImpostoAliquotaIBSCBS indMonoRet,
			NFNotaInfoImpostoAliquotaIBSCBS indMonoDif, LocalDate dIniVig, LocalDate dFimVig,
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

	public NFNotaInfoImpostoAliquotaIBSCBS getIndCredPres() {
		return indCredPres;
	}

	public NFNotaInfoImpostoAliquotaIBSCBS getIndGTribRegular() {
		return indGTribRegular;
	}

	public NFNotaInfoImpostoAliquotaIBSCBS getIndMono() {
		return indMono;
	}

	public NFNotaInfoImpostoAliquotaIBSCBS getIndMonoDif() {
		return indMonoDif;
	}

	public NFNotaInfoImpostoAliquotaIBSCBS getIndMonoRet() {
		return indMonoRet;
	}

	public NFNotaInfoImpostoAliquotaIBSCBS getIndMonoReten() {
		return indMonoReten;
	}

	public NFNotaInfoImpostoAliquotaIBSCBS getIndRedutorBC() {
		return indRedutorBC;
	}

	public String getLeiComplementar() {
		return leiComplementar;
	}

	public NFNotaInfoImpostoAliquotaIBSCBS getpRedCBS() {
		return pRedCBS;
	}

	public NFNotaInfoImpostoAliquotaIBSCBS getpRedIBS() {
		return pRedIBS;
	}

	public NFNotaInfoImpostoTipoAliquotaIBSCBS getTipoAliquota() {
		return tipoAliquota;
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

	@Override
	public String toString() {
		return codigo + " - " + descricao;
	}
	
}

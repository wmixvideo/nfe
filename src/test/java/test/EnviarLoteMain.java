package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.fincatto.nfe310.NFeConfigFake;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFEndereco;
import com.fincatto.nfe310.classes.NFFinalidade;
import com.fincatto.nfe310.classes.NFFormaPagamentoPrazo;
import com.fincatto.nfe310.classes.NFModalidadeFrete;
import com.fincatto.nfe310.classes.NFModelo;
import com.fincatto.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe310.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalculo;
import com.fincatto.nfe310.classes.NFOrigem;
import com.fincatto.nfe310.classes.NFProcessoEmissor;
import com.fincatto.nfe310.classes.NFProdutoCompoeValorNota;
import com.fincatto.nfe310.classes.NFRegimeTributario;
import com.fincatto.nfe310.classes.NFTipo;
import com.fincatto.nfe310.classes.NFTipoEmissao;
import com.fincatto.nfe310.classes.NFTipoImpressao;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvio;
import com.fincatto.nfe310.classes.lote.envio.NFLoteEnvioRetornoDados;
import com.fincatto.nfe310.classes.lote.envio.NFLoteIndicadorProcessamento;
import com.fincatto.nfe310.classes.nota.NFIdentificadorLocalDestinoOperacao;
import com.fincatto.nfe310.classes.nota.NFIndicadorIEDestinatario;
import com.fincatto.nfe310.classes.nota.NFIndicadorPresencaComprador;
import com.fincatto.nfe310.classes.nota.NFNota;
import com.fincatto.nfe310.classes.nota.NFNotaInfo;
import com.fincatto.nfe310.classes.nota.NFNotaInfoAvulsa;
import com.fincatto.nfe310.classes.nota.NFNotaInfoDestinatario;
import com.fincatto.nfe310.classes.nota.NFNotaInfoEmitente;
import com.fincatto.nfe310.classes.nota.NFNotaInfoICMSTotal;
import com.fincatto.nfe310.classes.nota.NFNotaInfoIdentificacao;
import com.fincatto.nfe310.classes.nota.NFNotaInfoItem;
import com.fincatto.nfe310.classes.nota.NFNotaInfoItemImposto;
import com.fincatto.nfe310.classes.nota.NFNotaInfoItemImpostoICMS;
import com.fincatto.nfe310.classes.nota.NFNotaInfoItemImpostoICMS00;
import com.fincatto.nfe310.classes.nota.NFNotaInfoItemProduto;
import com.fincatto.nfe310.classes.nota.NFNotaInfoTotal;
import com.fincatto.nfe310.classes.nota.NFNotaInfoTransporte;
import com.fincatto.nfe310.classes.nota.NFOperacaoConsumidorFinal;
import com.fincatto.nfe310.webservices.WSFacade;

public class EnviarLoteMain {

	public static void main(String[] args) throws Exception {
		NFNota nota = new NFNota();

		nota.setInfo(new NFNotaInfo());
		nota.getInfo().setVersao(new BigDecimal("3.10"));

		// ====================================================================================
		// IDENTIFICAÇÃO
		// ====================================================================================
		nota.getInfo().setIdentificacao(new NFNotaInfoIdentificacao());
		nota.getInfo().getIdentificacao().setAmbiente(NFAmbiente.HOMOLOGACAO);
		nota.getInfo().getIdentificacao().setCodigoMunicipio("2111300");
		nota.getInfo().getIdentificacao().setCodigoRandomico(String.format("%08d", new Random().nextInt(100000000)));
		nota.getInfo().getIdentificacao().setDataHoraEmissao(DateTime.now());
		nota.getInfo().getIdentificacao().setDataHoraSaidaOuEntrada(DateTime.now());
		// nota.getInfo().getIdentificacao().setDigitoVerificador();
		nota.getInfo().getIdentificacao().setFinalidade(NFFinalidade.NORMAL);
		nota.getInfo().getIdentificacao().setFormaPagamento(NFFormaPagamentoPrazo.OUTROS);
		nota.getInfo().getIdentificacao().setIdentificadorLocalDestinoOperacao(
				NFIdentificadorLocalDestinoOperacao.OPERACAO_INTERNA);
		nota.getInfo().getIdentificacao().setIndicadorPresencaComprador(NFIndicadorPresencaComprador.NAO_APLICA);
		// nota.getInfo().getIdentificacao().setJustificativaEntradaContingencia("");
		nota.getInfo().getIdentificacao().setModelo(NFModelo.NFE);
		nota.getInfo().getIdentificacao().setNaturezaOperacao("TRIBUTADA INTERNA");
		nota.getInfo().getIdentificacao().setNumeroNota("123123123");
		nota.getInfo().getIdentificacao().setOperacaoConsumidorFinal(NFOperacaoConsumidorFinal.SIM);
		nota.getInfo().getIdentificacao().setProgramaEmissor(NFProcessoEmissor.AVULSA_FISCO);
		// nota.getInfo().getIdentificacao().setReferenciadas(null);
		nota.getInfo().getIdentificacao().setSerie("890");
		nota.getInfo().getIdentificacao().setTipo(NFTipo.SAIDA);
		nota.getInfo().getIdentificacao().setTipoEmissao(NFTipoEmissao.EMISSAO_NORMAL);
		nota.getInfo().getIdentificacao().setTipoImpressao(NFTipoImpressao.DANFE_SIMPLIFICADO);
		nota.getInfo().getIdentificacao().setVersaoEmissor("1.0.0-SNAPSHOT");
		nota.getInfo().getIdentificacao().setUf(NFUnidadeFederativa.MA);
		// nota.getInfo().getIdentificacao().setDataHoraContigencia(DateTime.now());
		// nota.getInfo().getIdentificacao().setJustificativaEntradaContingencia(
		// "EXECUÇÃO DE TESTES PARA NOTA FISCAL ELETRÔNICA AVULSA NO MA");

		// ====================================================================================
		// IDENTIFICAÇÃO DE NOTA AVULSA
		// ====================================================================================
		nota.getInfo().setAvulsa(new NFNotaInfoAvulsa());
		nota.getInfo().getAvulsa().setCnpj("03526252000147");
		nota.getInfo().getAvulsa().setDataEmissaoDocumentoArrecadacao(LocalDate.now());
		nota.getInfo().getAvulsa().setDataPagamentoDocumentoArrecadacao(LocalDate.now());
		nota.getInfo().getAvulsa().setFone("98987026437");
		nota.getInfo().getAvulsa().setMatriculaAgente("60004532309");
		nota.getInfo().getAvulsa().setNomeAgente("WELYAB DA SILVA PAULA");
		nota.getInfo().getAvulsa().setNumeroDocumentoArrecadacaoReceita("1223344556");
		nota.getInfo().getAvulsa().setOrgaoEmitente("SEFAZ-MA");
		nota.getInfo().getAvulsa().setReparticaoFiscalEmitente("TRÂNSITO");
		nota.getInfo().getAvulsa().setUf(NFUnidadeFederativa.MA);
		nota.getInfo().getAvulsa().setValorTotalConstanteDocumentoArrecadacaoReceita(new BigDecimal("100.00"));

		// ====================================================================================
		// EMITENTE
		// ====================================================================================
		nota.getInfo().setEmitente(new NFNotaInfoEmitente());
		// nota.getInfo().getEmitente().setClassificacaoNacionalAtividadesEconomicas("");
		// nota.getInfo().getEmitente().setCnpj("");
		nota.getInfo().getEmitente().setCpf("60004532309");
		nota.getInfo().getEmitente().setInscricaoEstadual("ISENTO");
		// nota.getInfo().getEmitente().setInscricaoEstadualSubstituicaoTributaria("");
		// nota.getInfo().getEmitente().setInscricaoMunicipal("");
		nota.getInfo().getEmitente().setRazaoSocial("WELYAB DA SILVA PAULA");
		nota.getInfo().getEmitente().setNomeFantasia("WELYAB DA SILVA PAULA");
		nota.getInfo().getEmitente().setRegimeTributario(NFRegimeTributario.NORMAL);
		// nota.getInfo().getEmitente().setInscricaoEstadualSubstituicaoTributaria("");
		nota.getInfo().getEmitente().setEndereco(new NFEndereco());
		nota.getInfo().getEmitente().getEndereco().setBairro("TURU");
		nota.getInfo().getEmitente().getEndereco().setCep("65065580");
		nota.getInfo().getEmitente().getEndereco().setCodigoMunicipio("2111300");
		// nota.getInfo().getEmitente().getEndereco().setCodigoPais("");
		nota.getInfo().getEmitente().getEndereco().setComplemento("PROX BOATE ZERO UM");
		nota.getInfo().getEmitente().getEndereco().setDescricaoMunicipio("SÃO LUÍS");
		nota.getInfo().getEmitente().getEndereco().setDescricaoPais("BRASIL");
		nota.getInfo().getEmitente().getEndereco().setLogradouro("RUA UM");
		nota.getInfo().getEmitente().getEndereco().setNumero("8");
		nota.getInfo().getEmitente().getEndereco().setTelefone("98987026437");
		nota.getInfo().getEmitente().getEndereco().setUf(NFUnidadeFederativa.MA);

		// ====================================================================================
		// DESTINATÁRIO
		// ====================================================================================
		nota.getInfo().setDestinatario(new NFNotaInfoDestinatario());
		// nota.getInfo().getDestinatario().setCnpj("");
		nota.getInfo().getDestinatario().setCpf("60004532309");
		nota.getInfo().getDestinatario().setEmail("welyab.exe@gmail.com");
		// nota.getInfo().getDestinatario().setIdEstrangeiro("");
		nota.getInfo().getDestinatario().setIndicadorIEDestinatario(NFIndicadorIEDestinatario.NAO_CONTRIBUINTE);
		// nota.getInfo().getDestinatario().setInscricaoEstadual("");
		// nota.getInfo().getDestinatario().setInscricaoMunicipal("");
		// nota.getInfo().getDestinatario().setInscricaoSuframa("");
		nota.getInfo().getDestinatario().setRazaoSocial("WELYAB DA SILVA PAULA");
		nota.getInfo().getDestinatario().setEndereco(new NFEndereco());
		nota.getInfo().getDestinatario().setEndereco(new NFEndereco());
		nota.getInfo().getDestinatario().getEndereco().setBairro("TURU");
		nota.getInfo().getDestinatario().getEndereco().setCep("65065580");
		nota.getInfo().getDestinatario().getEndereco().setCodigoMunicipio("2111300");
		// nota.getInfo().getDestinatario().getEndereco().setCodigoPais("");
		nota.getInfo().getDestinatario().getEndereco().setComplemento("PROX BOATE ZERO UM");
		nota.getInfo().getDestinatario().getEndereco().setDescricaoMunicipio("SÃO LUÍS");
		nota.getInfo().getDestinatario().getEndereco().setDescricaoPais("BRASIL");
		nota.getInfo().getDestinatario().getEndereco().setLogradouro("RUA UM");
		nota.getInfo().getDestinatario().getEndereco().setNumero("8");
		nota.getInfo().getDestinatario().getEndereco().setTelefone("98987026437");
		nota.getInfo().getDestinatario().getEndereco().setUf(NFUnidadeFederativa.MA);

		// ====================================================================================
		// TRANSPORTADOR
		// ====================================================================================
		nota.getInfo().setTransporte(new NFNotaInfoTransporte());
		nota.getInfo().getTransporte().setModalidadeFrete(NFModalidadeFrete.SEM_FRETE);

		// ====================================================================================
		// PRODUTOS
		// ====================================================================================
		List<NFNotaInfoItem> produtos = new ArrayList<>();
		produtos.add(new NFNotaInfoItem());
		produtos.get(0).setNumeroItem(1);
		// produtos.get(0).setInformacoesAdicionais("");
		produtos.get(0).setProduto(new NFNotaInfoItemProduto());
		// produtos.get(0).getProduto().setArmamentos(null);
		produtos.get(0).getProduto().setCampoeValorNota(NFProdutoCompoeValorNota.SIM);
		produtos.get(0).getProduto().setCfop("1204");
		produtos.get(0).getProduto().setCodigo("XPTO");
		produtos.get(0).getProduto().setCodigoDeBarras("");
		produtos.get(0).getProduto().setCodigoDeBarrasTributavel("");
		// produtos.get(0).getProduto().setCodigoEspecificadorSituacaoTributaria("");
		// produtos.get(0).getProduto().setCombustivel(null);
		// produtos.get(0).getProduto().setDeclaracoesImportacao(null);
		produtos.get(0).getProduto().setDescricao("SAPATO");
		// produtos.get(0).getProduto().setDetalhesExportacao(null);
		// produtos.get(0).getProduto().setExtipi("");
		// produtos.get(0).getProduto().setMedicamentos(null);
		produtos.get(0).getProduto().setNcm("64039900");
		// produtos.get(0).getProduto().setNomeclaturaValorAduaneiroEstatistica(null);
		// produtos.get(0).getProduto().setNumeroControleFCI("");
		// produtos.get(0).getProduto().setNumeroPedidoCliente("");
		// produtos.get(0).getProduto().setNumeroPedidoItemCliente("");
		// produtos.get(0).getProduto().setNumeroRECOPI("");
		produtos.get(0).getProduto().setQuantidadeComercial(new BigDecimal("1.00"));
		produtos.get(0).getProduto().setQuantidadeTributavel(new BigDecimal("1.00"));
		produtos.get(0).getProduto().setUnidadeComercial("KG");
		produtos.get(0).getProduto().setUnidadeTributavel("KG");
		// produtos.get(0).getProduto().setValorDesconto(new BigDecimal("0.00"));
		// produtos.get(0).getProduto().setValorFrete(new BigDecimal("0.00"));
		// produtos.get(0).getProduto().setValorOutrasDespesasAcessorias(new BigDecimal("0.00"));
		// produtos.get(0).getProduto().setValorSeguro(new BigDecimal("0.00"));
		produtos.get(0).getProduto().setValorTotalBruto(new BigDecimal("100.00"));
		produtos.get(0).getProduto().setValorUnitario(new BigDecimal("100.00"));
		produtos.get(0).getProduto().setValorUnitarioTributavel(new BigDecimal("100.00"));
		// produtos.get(0).getProduto().setVeiculo(null);
		produtos.get(0).setImposto(new NFNotaInfoItemImposto());
		produtos.get(0).getImposto().setIcms(new NFNotaInfoItemImpostoICMS());
		produtos.get(0).getImposto().getIcms().setIcms00(new NFNotaInfoItemImpostoICMS00());
		produtos.get(0).getImposto().getIcms().getIcms00().setModalidadeBaseCalculo(
				NFNotaInfoItemImpostoICMSModalidadeBaseCalculo.PAUTA);
		produtos.get(0).getImposto().getIcms().getIcms00().setOrigem(NFOrigem.NACIONAL);
		produtos.get(0).getImposto().getIcms().getIcms00().setPercentualAliquota(new BigDecimal("10.00"));
		produtos.get(0).getImposto().getIcms().getIcms00().setSituacaoTributaria(
				NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_INTEGRALMENTE);
		produtos.get(0).getImposto().getIcms().getIcms00().setValorBaseCalculo(new BigDecimal("100.00"));
		produtos.get(0).getImposto().getIcms().getIcms00().setValorTributo(new BigDecimal("10.00"));
		produtos.get(0).getImposto().setValorTotalTributos(new BigDecimal("10.00"));
		// produtos.get(0).setImpostoDevolvido(new NFImpostoDevolvido());
		nota.getInfo().setItens(produtos);

		// ====================================================================================
		// TOTALIZACÕES DA NFE
		// ====================================================================================
		nota.getInfo().setTotal(new NFNotaInfoTotal());
		// ICMS
		nota.getInfo().getTotal().setIcmsTotal(new NFNotaInfoICMSTotal());
		nota.getInfo().getTotal().getIcmsTotal().setBaseCalculoICMS(new BigDecimal("100.00"));
		nota.getInfo().getTotal().getIcmsTotal().setBaseCalculoICMSST(new BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setOutrasDespesasAcessorias(new BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorCOFINS(new BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorICMSDesonerado(new BigDecimal("0.00"));
		// nota.getInfo().getTotal().getIcmsTotal().setValorICMSFundoCombatePobreza(new
		// BigDecimal("0.00"));
		// nota.getInfo().getTotal().getIcmsTotal().setValorICMSPartilhaDestinatario(new
		// BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorICMSPartilhaRementente(null);
		nota.getInfo().getTotal().getIcmsTotal().setValorPIS(new BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorTotalDesconto(new BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorTotalDosProdutosServicos(new BigDecimal("100.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorTotalFrete(new BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorTotalICMS(new BigDecimal("10.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorTotalICMSST(new BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorTotalII(new BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorTotalIPI(new BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorTotalNFe(new BigDecimal("100.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorTotalSeguro(new BigDecimal("0.00"));
		nota.getInfo().getTotal().getIcmsTotal().setValorTotalTributos(new BigDecimal("10.00"));
		// ISS
		// nota.getInfo().getTotal().setIssqnTotal(new NFNotaInfoISSQNTotal());
		// nota.getInfo().getTotal().getIssqnTotal().setBaseCalculoISS(new BigDecimal("0.00"));
		// nota.getInfo().getTotal().getIssqnTotal().setDataPrestacaoServico(LocalDate.now());
		// nota.getInfo().getTotal().getIssqnTotal().setTributacao(NFNotaInfoRegimeEspecialTributacao.ESTIMATIVA);
		// nota.getInfo().getTotal().getIssqnTotal().setValorCOFINSsobreServicos(new
		// BigDecimal("0.00"));
		// nota.getInfo().getTotal().getIssqnTotal().setValorDeducao(new BigDecimal("0.00"));
		// nota.getInfo().getTotal().getIssqnTotal().setValorOutros(new BigDecimal("0.00"));
		// nota.getInfo().getTotal().getIssqnTotal().setValorPISsobreServicos(new
		// BigDecimal("0.00"));
		// nota.getInfo().getTotal().getIssqnTotal().setValorTotalDescontoCondicionado(new
		// BigDecimal("0.00"));
		// nota.getInfo().getTotal().getIssqnTotal().setValorTotalISS(new BigDecimal("0.00"));
		// nota.getInfo().getTotal().getIssqnTotal().setValorTotalRetencaoISS(new
		// BigDecimal("0.00"));
		// nota.getInfo().getTotal().getIssqnTotal().setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(
		// new BigDecimal("0.00"));
		// nota.getInfo().getTotal().setRetencoesTributos(new NFNotaInfoRetencoesTributos());

		ArrayList<NFNota> list = new ArrayList<>();
		list.add(nota);

		NFLoteEnvio lote = new NFLoteEnvio();
		lote.setIdLote("1465527170687");
		lote.setVersao("3.10");
		lote.setIndicadorProcessamento(NFLoteIndicadorProcessamento.PROCESSAMENTO_ASSINCRONO);
		lote.setNotas(list);

		WSFacade s = new WSFacade(new NFeConfigFake());
		NFLoteEnvioRetornoDados enviaLote = s.enviaLote(lote);
		System.out.println(enviaLote.getRetorno());
	}
}

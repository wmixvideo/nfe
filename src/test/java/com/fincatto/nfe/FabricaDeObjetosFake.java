package com.fincatto.nfe;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import org.joda.time.LocalDate;

import com.fincatto.nfe.classes.NFOrigem;
import com.fincatto.nfe.classes.nota.NFNotaInfoCana;
import com.fincatto.nfe.classes.nota.NFNotaInfoCanaDeducao;
import com.fincatto.nfe.classes.nota.NFNotaInfoCanaFornecimentoDiario;
import com.fincatto.nfe.classes.nota.NFNotaInfoDuplicata;
import com.fincatto.nfe.classes.nota.NFNotaInfoFatura;
import com.fincatto.nfe.classes.nota.NFNotaInfoICMSTotal;
import com.fincatto.nfe.classes.nota.NFNotaInfoISSQNTotal;
import com.fincatto.nfe.classes.nota.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe.classes.nota.NFNotaInfoImpostoTributacaoISSQN;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoCOFINS;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoCOFINSAliquota;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoCOFINSNaoTributavel;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoCOFINSOutrasOperacoes;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoCOFINSQuantidade;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoCOFINSST;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoICMS;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoICMS00;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoIPI;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoIPINaoTributado;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoIPITributado;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoISSQN;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoImportacao;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoPIS;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoPISAliquota;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoPISNaoTributado;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoPISOutrasOperacoes;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoPISQuantidade;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemImpostoPISST;
import com.fincatto.nfe.classes.nota.NFNotaInfoItemProdutoCombustivelCIDE;
import com.fincatto.nfe.classes.nota.NFNotaInfoLacre;
import com.fincatto.nfe.classes.nota.NFNotaInfoObservacao;
import com.fincatto.nfe.classes.nota.NFNotaInfoProcessoReferenciado;
import com.fincatto.nfe.classes.nota.NFNotaInfoReboque;
import com.fincatto.nfe.classes.nota.NFNotaInfoRetencaoICMSTransporte;
import com.fincatto.nfe.classes.nota.NFNotaInfoRetencoesTributos;
import com.fincatto.nfe.classes.nota.NFNotaInfoSituacaoTributariaCOFINS;
import com.fincatto.nfe.classes.nota.NFNotaInfoSituacaoTributariaIPI;
import com.fincatto.nfe.classes.nota.NFNotaInfoSituacaoTributariaPIS;
import com.fincatto.nfe.classes.nota.NFNotaInfoTransportador;
import com.fincatto.nfe.classes.nota.NFNotaInfoVeiculo;
import com.fincatto.nfe.classes.nota.NFNotaInfoVolume;
import com.fincatto.nfe.classes.nota.NFOrigemProcesso;

public class FabricaDeObjetosFake {

    public static NFNotaInfoItemProdutoCombustivelCIDE getNFNotaInfoItemProdutoCombustivelCIDE() {
        final NFNotaInfoItemProdutoCombustivelCIDE cide = new NFNotaInfoItemProdutoCombustivelCIDE();
        cide.setQuantidadeBCCIDE(new BigDecimal("99999999999.9999"));
        cide.setValor(new BigDecimal("999999999999.99"));
        cide.setValorAliquota(new BigDecimal("9999999999.9999"));
        return cide;
    }

    public static NFNotaInfoItemImpostoPIS getNFNotaInfoItemImpostoPIS() {
        final NFNotaInfoItemImpostoPIS pis = new NFNotaInfoItemImpostoPIS();
        pis.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISAliquota());
        pis.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISNaoTributado());
        pis.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISOutrasOperacoes());
        pis.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISQuantidade());
        return pis;
    }

    public static NFNotaInfoItemImpostoISSQN getNFNotaInfoItemImpostoISSQN() {
        final NFNotaInfoItemImpostoISSQN impostoISSQN = new NFNotaInfoItemImpostoISSQN();
        impostoISSQN.setCodigoMunicipio(9999999);
        impostoISSQN.setCodigoTributacao(NFNotaInfoImpostoTributacaoISSQN.ISENTA);
        impostoISSQN.setItemListaServicos(9999);
        impostoISSQN.setValor(new BigDecimal("999999999999.99"));
        impostoISSQN.setValorAliquota(new BigDecimal("99.99"));
        impostoISSQN.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        return impostoISSQN;
    }

    public static NFNotaInfoItemImpostoIPI getNFNotaInfoItemImpostoIPI() {
        final NFNotaInfoItemImpostoIPI ipi = new NFNotaInfoItemImpostoIPI();
        ipi.setClasseEnquadramento("157br");
        ipi.setCnpjProdutor("12345678901234");
        ipi.setCodigoEnquadramento("aT2");
        ipi.setCodigoSelo("iNEFifS1jexTxcCvgjlQ186nR6JAwM2koyjbWKA1DJSLmZy432GoSwoygXc5");
        ipi.setNaoTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPINaoTributado());
        ipi.setQuantidadeSelo(new BigInteger("999999999999"));
        ipi.setTributado(FabricaDeObjetosFake.getNFNotaInfoItemImpostoIPITributado());
        return ipi;
    }

    public static NFNotaInfoItemImpostoImportacao getNFNotaInfoItemImpostoImportacao() {
        final NFNotaInfoItemImpostoImportacao importacao = new NFNotaInfoItemImpostoImportacao();
        importacao.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        importacao.setValorDespesaAduaneira(new BigDecimal("999999999999.99"));
        importacao.setValorImpostoImportacao(new BigDecimal("999999999999.99"));
        importacao.setValorIOF(new BigDecimal("999999999999.99"));
        return importacao;
    }

    public static NFNotaInfoItemImpostoCOFINS getNFNotaInfoItemImpostoCOFINS() {
        final NFNotaInfoItemImpostoCOFINS cofins = new NFNotaInfoItemImpostoCOFINS();
        cofins.setAliquota(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota());
        cofins.setNaoTributavel(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSNaoTributavel());
        cofins.setOutrasOperacoes(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSOutrasOperacoes());
        cofins.setQuantidade(FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSQuantidade());
        return cofins;
    }

    public static NFNotaInfoItemImpostoICMS getNFNotaInfoItemImpostoICMS() {
        final NFNotaInfoItemImpostoICMS icms = new NFNotaInfoItemImpostoICMS();
        icms.setIcms00(FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS00());
        return icms;
    }

    public static NFNotaInfoItemImpostoICMS00 getNFNotaInfoItemImpostoICMS00() {
        final NFNotaInfoItemImpostoICMS00 icms00 = new NFNotaInfoItemImpostoICMS00();
        icms00.setModalidadeBaseCalculo(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.PAUTA);
        icms00.setOrigem(NFOrigem.NACIONAL);
        icms00.setPercentualAliquota(new BigDecimal("99.99"));
        icms00.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA);
        icms00.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        icms00.setValorTributo(new BigDecimal("999999999999.99"));
        return icms00;
    }

    public static NFNotaInfoItemImpostoIPITributado getNFNotaInfoItemImpostoIPITributado() {
        final NFNotaInfoItemImpostoIPITributado ipiTributado = new NFNotaInfoItemImpostoIPITributado();
        ipiTributado.setSituacaoTributaria(NFNotaInfoSituacaoTributariaIPI.SAIDA_ISENTA);
        ipiTributado.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        ipiTributado.setPercentualAliquota(new BigDecimal("99.99"));
        ipiTributado.setValorTributo(new BigDecimal("999999999999.99"));
        return ipiTributado;
    }

    public static NFNotaInfoItemImpostoIPINaoTributado getNFNotaInfoItemImpostoIPINaoTributado() {
        final NFNotaInfoItemImpostoIPINaoTributado ipiNaoTributado = new NFNotaInfoItemImpostoIPINaoTributado();
        ipiNaoTributado.setSituacaoTributaria(NFNotaInfoSituacaoTributariaIPI.SAIDA_ISENTA);
        return ipiNaoTributado;
    }

    public static NFNotaInfoItemImpostoPISST getNFNotaInfoItemImpostoPISST() {
        final NFNotaInfoItemImpostoPISST impostoPISST = new NFNotaInfoItemImpostoPISST();
        impostoPISST.setValorAliquota(new BigDecimal("9999999999.9999"));
        impostoPISST.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        impostoPISST.setValorTributo(new BigDecimal("999999999999.99"));
        return impostoPISST;
    }

    public static NFNotaInfoItemImpostoPISQuantidade getNFNotaInfoItemImpostoPISQuantidade() {
        final NFNotaInfoItemImpostoPISQuantidade pisQuantidade = new NFNotaInfoItemImpostoPISQuantidade();
        pisQuantidade.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        pisQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO);
        pisQuantidade.setValorAliquota(new BigDecimal("9999999999.9999"));
        pisQuantidade.setValorTributo(new BigDecimal("999999999999.99"));
        return pisQuantidade;
    }

    public static NFNotaInfoItemImpostoPISOutrasOperacoes getNFNotaInfoItemImpostoPISOutrasOperacoes() {
        final NFNotaInfoItemImpostoPISOutrasOperacoes pisOutrasOperacoes = new NFNotaInfoItemImpostoPISOutrasOperacoes();
        pisOutrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.OUTRAS_OPERACOES_SAIDA);
        pisOutrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        pisOutrasOperacoes.setValorAliquota(new BigDecimal("9999999999.9999"));
        pisOutrasOperacoes.setValorTributo(new BigDecimal("999999999999.99"));
        return pisOutrasOperacoes;
    }

    public static NFNotaInfoItemImpostoPISNaoTributado getNFNotaInfoItemImpostoPISNaoTributado() {
        final NFNotaInfoItemImpostoPISNaoTributado pisNaoTributado = new NFNotaInfoItemImpostoPISNaoTributado();
        pisNaoTributado.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO);
        return pisNaoTributado;
    }

    public static NFNotaInfoItemImpostoPISAliquota getNFNotaInfoItemImpostoPISAliquota() {
        final NFNotaInfoItemImpostoPISAliquota pisAliquota = new NFNotaInfoItemImpostoPISAliquota();
        pisAliquota.setPercentualAliquota(new BigDecimal("99.99"));
        pisAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO);
        pisAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        pisAliquota.setValorTributo(new BigDecimal("999999999999.99"));
        return pisAliquota;
    }

    public static NFNotaInfoItemImpostoCOFINSST getNFNotaInfoItemImpostoCOFINSST() {
        final NFNotaInfoItemImpostoCOFINSST cofins = new NFNotaInfoItemImpostoCOFINSST();
        cofins.setPercentualAliquota(new BigDecimal("99.99"));
        cofins.setQuantidadeVendida(new BigDecimal("99999999999"));
        cofins.setValorCOFINS(new BigDecimal("999999999999"));
        return cofins;
    }

    public static NFNotaInfoItemImpostoCOFINSQuantidade getNFNotaInfoItemImpostoCOFINSQuantidade() {
        final NFNotaInfoItemImpostoCOFINSQuantidade cofinsQuantidade = new NFNotaInfoItemImpostoCOFINSQuantidade();
        cofinsQuantidade.setQuantidadeVendida(new BigDecimal("99999999999"));
        cofinsQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_AQUISICAO_ALIQUOTA_ZERO);
        cofinsQuantidade.setValorAliquota(new BigDecimal("9999999999"));
        cofinsQuantidade.setValorTributo(new BigDecimal("999999999999"));
        return cofinsQuantidade;
    }

    public static NFNotaInfoItemImpostoCOFINSOutrasOperacoes getNFNotaInfoItemImpostoCOFINSOutrasOperacoes() {
        final NFNotaInfoItemImpostoCOFINSOutrasOperacoes outrasOperacoes = new NFNotaInfoItemImpostoCOFINSOutrasOperacoes();
        outrasOperacoes.setPercentualCOFINS(new BigDecimal("99.99"));
        outrasOperacoes.setQuantidadeVendida(new BigDecimal("99999999999"));
        outrasOperacoes.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.OUTRAS_OPERACOES_SAIDA);
        outrasOperacoes.setValorAliquota(new BigDecimal("9999999999"));
        outrasOperacoes.setValorBaseCalculo(new BigDecimal("999999999999"));
        outrasOperacoes.setValorCOFINS(new BigDecimal("999999999999"));
        return outrasOperacoes;
    }

    public static NFNotaInfoItemImpostoCOFINSNaoTributavel getNFNotaInfoItemImpostoCOFINSNaoTributavel() {
        final NFNotaInfoItemImpostoCOFINSNaoTributavel cofinsNaoTributado = new NFNotaInfoItemImpostoCOFINSNaoTributavel();
        cofinsNaoTributado.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO);
        return cofinsNaoTributado;
    }

    public static NFNotaInfoItemImpostoCOFINSAliquota getNFNotaInfoItemImpostoCOFINSAliquota() {
        final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
        cofinsAliquota.setPercentualAliquota(new BigDecimal("99.99"));
        cofinsAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OUTRAS);
        cofinsAliquota.setValor(new BigDecimal("999999999999.99"));
        cofinsAliquota.setValorBaseCalulo(new BigDecimal("999999999999.99"));
        return cofinsAliquota;
    }

    public static NFNotaInfoRetencoesTributos getNFNotaInfoRetencoesTributos() {
        final NFNotaInfoRetencoesTributos retencoesTributos = new NFNotaInfoRetencoesTributos();
        retencoesTributos.setBaseCalculoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setBaseCalculoRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetencaoPrevidenciaSocial(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCOFINS(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoCSLL(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoIRRF(new BigDecimal("999999999999.99"));
        retencoesTributos.setValorRetidoPIS(new BigDecimal("999999999999.99"));
        return retencoesTributos;
    }

    public static NFNotaInfoISSQNTotal getNFNotaInfoISSQNTotal() {
        final NFNotaInfoISSQNTotal issqnTotal = new NFNotaInfoISSQNTotal();
        issqnTotal.setBaseCalculoISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorCOFINSsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorPISsobreServicos(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalISS(new BigDecimal("999999999999.99"));
        issqnTotal.setValorTotalServicosSobNaoIncidenciaNaoTributadosICMS(new BigDecimal("999999999999.99"));
        return issqnTotal;
    }

    public static NFNotaInfoICMSTotal getNFNotaInfoICMSTotal() {
        final NFNotaInfoICMSTotal icmsTotal = new NFNotaInfoICMSTotal();
        icmsTotal.setBaseCalculoICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setOutrasDespesasAcessorias(new BigDecimal("999999999999.99"));
        icmsTotal.setValor(new BigDecimal("999999999999.99"));
        icmsTotal.setValorCOFINS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorPIS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDesconto(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalDosProdutosServicos(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalFrete(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMS(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalICMSST(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalII(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalIPI(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalNFe(new BigDecimal("999999999999.99"));
        icmsTotal.setValorTotalSeguro(new BigDecimal("999999999999.99"));
        return icmsTotal;
    }

    public static NFNotaInfoVeiculo getNFNotaInfoVeiculo() {
        final NFNotaInfoVeiculo veiculo = new NFNotaInfoVeiculo();
        veiculo.setPlacaVeiculo("MKZ8159");
        veiculo.setRegistroNacionalTransportadorCarga("8Io5YKSKW1qy3v7zGwLx");
        veiculo.setUf(NFUnidadeFederativa.SP);
        return veiculo;
    }

    public static NFNotaInfoTransportador getNFNotaInfoTransportador() {
        final NFNotaInfoTransportador transportador = new NFNotaInfoTransportador();
        transportador.setCnpj("34843274000164");
        transportador.setEnderecoComplemento("D8nOWsHxI5K4RgYTUGwWgIKajhiUf4Q7aOOmaTV2wnYV0kQ5MezOjqfoPcNY");
        transportador.setInscricaoEstadual("");
        transportador.setNomeMunicipio("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setRazaoSocial("4lb4Qv5yi9oYq7s8fF98a0EEv98oAxl0CIs5gzyKNVp1skE3IHD9Z7JbjHCn");
        transportador.setUf(NFUnidadeFederativa.SP);
        return transportador;
    }

    public static NFNotaInfoReboque getNFNotaInfoReboque() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setUf(NFUnidadeFederativa.SC);
        reboque.setVagao("8fFAKefiBQIDTkCCSQk3");
        return reboque;
    }

    public static NFNotaInfoRetencaoICMSTransporte getNFNotaInfoRetencaoICMSTransporte() {
        final NFNotaInfoRetencaoICMSTransporte retencaoICMSTransporte = new NFNotaInfoRetencaoICMSTransporte();
        retencaoICMSTransporte.setAliquotaRetencao(new BigDecimal("99.99"));
        retencaoICMSTransporte.setBcRetencaoICMS(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setCfop(9999);
        retencaoICMSTransporte.setCodigoMunicipioOcorrenciaFatoGeradorICMSTransporte(9999999);
        retencaoICMSTransporte.setValorICMSRetido(new BigDecimal("999999999999.99"));
        retencaoICMSTransporte.setValorServico(new BigDecimal("999999999999.99"));
        return retencaoICMSTransporte;
    }

    public static NFNotaInfoCanaDeducao getNFNotaInfoCanaDeducao() {
        final NFNotaInfoCanaDeducao infoCanaDeducao = new NFNotaInfoCanaDeducao();
        infoCanaDeducao.setDescricaoDeducao("67TgthEHf2gowJBy4PZ3ulgaDDAi80s27pIzYK6DJORNAPqL7vJ5ZbQShDcA");
        infoCanaDeducao.setValorDeducao(new BigDecimal("1000"));
        infoCanaDeducao.setValorFornecimento(new BigDecimal("900"));
        infoCanaDeducao.setValorLiquidoFornecimento(new BigDecimal("980"));
        infoCanaDeducao.setValorTotalDeducao(new BigDecimal("2000.70"));
        return infoCanaDeducao;
    }

    public static NFNotaInfoCanaFornecimentoDiario getNFNotaInfoCanaFornecimentoDiario() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = new NFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setDia(15);
        canaFornecimentoDiario.setQuantidade(new BigDecimal("3"));
        canaFornecimentoDiario.setQuantidadeTotalAnterior(new BigDecimal("10"));
        canaFornecimentoDiario.setQuantidadeTotalGeral(new BigDecimal("80"));
        canaFornecimentoDiario.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        return canaFornecimentoDiario;
    }

    public static NFNotaInfoCana getNFNotaInfoCana() {
        final NFNotaInfoCana infoCana = new NFNotaInfoCana();
        infoCana.setDeducoes(new ArrayList<NFNotaInfoCanaDeducao>());
        final ArrayList<NFNotaInfoCanaFornecimentoDiario> infosCanaFornecimentoDario = new ArrayList<>();
        infosCanaFornecimentoDario.add(FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario());
        infoCana.setFornecimentosDiario(infosCanaFornecimentoDario);
        infoCana.setReferencia("06/2013");
        infoCana.setSafra("2013/2014");
        return infoCana;
    }

    public static NFNotaInfoObservacao getNFNotaInfoObservacao() {
        final NFNotaInfoObservacao observacao = new NFNotaInfoObservacao();
        observacao.setIdentificacaoCampo("kRkrK4FGWOn27RSjYjMB");
        observacao.setConteudoCampo("ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo");
        return observacao;
    }

    public static NFNotaInfoProcessoReferenciado getNFNotaInfoProcessoReferenciado() {
        final NFNotaInfoProcessoReferenciado processoReferenciado = new NFNotaInfoProcessoReferenciado();
        processoReferenciado.setIdentificadorProcessoOuAtoConcessorio("SziSRSIRZvYWlxcbmmJfRZsLgVHaHTurUL9ea1kwFe7fssrxTVSK6uaFwGO5");
        processoReferenciado.setIndicadorOrigemProcesso(NFOrigemProcesso.JUSTICA_FEDERAL);
        return processoReferenciado;
    }

    public static NFNotaInfoFatura getNFNotaInfoFatura() {
        final NFNotaInfoFatura fatura = new NFNotaInfoFatura();
        fatura.setNumeroFatura("KDVAp0aewPjmHaTsjbDX1O6NOR9tc7TxGflFLXsMZt2hEKar3oqzZ11uzEQF");
        fatura.setValorDesconto(new BigDecimal("0.15"));
        fatura.setValorLiquidoFatura(new BigDecimal("3000"));
        fatura.setValorOriginalFatura(new BigDecimal("3001.15"));
        return fatura;
    }

    public static NFNotaInfoDuplicata getNFNotaInfoDuplicata() {
        final NFNotaInfoDuplicata duplicata = new NFNotaInfoDuplicata();
        duplicata.setDataVencimento(new LocalDate(2014, 07, 10));
        duplicata.setNumeroDuplicata("TQ49cyOL5KtBAUTF0LShhThpUbtCK1fQH1PH4AMcKzMNLxyDbV957IRhWK8Z");
        duplicata.setValorDuplicata(new BigDecimal("999999.99"));
        return duplicata;
    }

    public static NFNotaInfoVolume getNFNotaInfoVolume() {
        final NFNotaInfoVolume volume = new NFNotaInfoVolume();
        volume.setEspecieVolumesTransportados("3Qf46HFs7FcWlhuQqLJ96vsrgJHu6B5ZXmmwMZ1RtvQVOV4Yp6M9VNqn5Ecb");
        final NFNotaInfoLacre notaInfoLacre = new NFNotaInfoLacre();
        notaInfoLacre.setNumeroLacre("gvmjb9BB2cmwsLbzeR3Bsk8QbA7b1XEgXUhKeS9QZGiwhFnqDtEzS3377MP2");
        volume.setLacres(Arrays.asList(notaInfoLacre));
        volume.setMarca("lc0w13Xw2PxsSD4u4q3N6Qix9ZuCFm0HXo6BxBmKnjVbh9Xwy3k9UwBNfuYo");
        volume.setNumeracaoVolumesTransportados("mcBUtZwnI5DKj2YZNAcLP7W9h6j1xKmF5SX1BTKmsvyg0H5xSrfVw8HGn8eb");
        volume.setPesoBruto(new BigDecimal("1.358"));
        volume.setPesoLiquido(new BigDecimal("1"));
        volume.setQuantidadeVolumesTransportados(new BigInteger("99999999999"));
        return volume;
    }
}
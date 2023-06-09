package com.fincatto.documentofiscal.cte300;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import com.fincatto.documentofiscal.cte300.classes.*;
import com.fincatto.documentofiscal.cte300.classes.nota.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Collections;

public class FabricaDeObjetosFake {

    public static CTeNotaInfo getCTeNotaInfo() {
        final CTeNotaInfo info = new CTeNotaInfo();
        info.setVersao("3.00");
        info.setIdentificador("12345678901234567890123456789012345678901234");
        info.setIdentificacao(FabricaDeObjetosFake.getInfoIdentificador());
        info.setDadosComplementares(FabricaDeObjetosFake.getInfoDadosComplementares());
        info.setCteNormal(FabricaDeObjetosFake.getInfoCTeNormal());
        info.setEmitente(FabricaDeObjetosFake.getInfoEmitente());
        info.setValorPrestacaoServico(FabricaDeObjetosFake.getValorPrestacaoServico());
        info.setInformacoesRelativasImpostos(FabricaDeObjetosFake.getImpostos());
        return info;
    }

    public static CTeNotaInfoInformacoesRelativasImpostos getImpostos() {
        final CTeNotaInfoInformacoesRelativasImpostos imposto = new CTeNotaInfoInformacoesRelativasImpostos();
        imposto.setIcms(FabricaDeObjetosFake.getImpostosICMS());
        imposto.setIcmsPartilha(FabricaDeObjetosFake.getImpostoPartilhaIcms());
        imposto.setInformacoesAdicionaisFisco("Informacoes do Fisco");
        imposto.setValorTotalTributos(BigDecimal.ONE);
        return imposto;
    }

    public static CTeNotaInfoInformacoesRelativasImpostosICMS getImpostosICMS() {
        final CTeNotaInfoInformacoesRelativasImpostosICMS impostoIcms = new CTeNotaInfoInformacoesRelativasImpostosICMS();
        impostoIcms.setIcms00(FabricaDeObjetosFake.getIcms00());
        return impostoIcms;
    }

    public static CTeNotaInfoInformacoesRelativasImpostosICMS00 getIcms00() {
        final CTeNotaInfoInformacoesRelativasImpostosICMS00 impostoIcms = new CTeNotaInfoInformacoesRelativasImpostosICMS00();
        impostoIcms.setAliquotaICMS(new BigDecimal("17"));
        impostoIcms.setBaseCalculoICMS(new BigDecimal("100"));
        impostoIcms.setCodigoSituacaoTributaria(CTCodigoSituacaoTributariaICMS.TRIBUTACAO_INTEGRALMENTE);
        impostoIcms.setValorICMS(new BigDecimal("0.17"));
        return impostoIcms;
    }

    public static CTeNotaInfoInformacoesRelativasImpostosICMSPartilha getImpostoPartilhaIcms() {
        final CTeNotaInfoInformacoesRelativasImpostosICMSPartilha impostoPartilha = new CTeNotaInfoInformacoesRelativasImpostosICMSPartilha();
        impostoPartilha.setAliquotaFCP(BigDecimal.ONE);
        impostoPartilha.setAliquotaInterestadual(new BigDecimal("17"));
        impostoPartilha.setAliquotaInterna(new BigDecimal("17"));
        impostoPartilha.setAliquotaPartilha(new BigDecimal("50"));
        impostoPartilha.setBcICMS(new BigDecimal("100"));
        impostoPartilha.setValorFCP(new BigDecimal("1"));
        impostoPartilha.setValorUf(new BigDecimal("8.5"));
        impostoPartilha.setValorUfDestino(new BigDecimal("8.5"));
        return impostoPartilha;
    }

    public static CTeNotaInfoValorPrestacaoServico getValorPrestacaoServico() {
        final CTeNotaInfoValorPrestacaoServico cteValorPrestacaoServico = new CTeNotaInfoValorPrestacaoServico();
        cteValorPrestacaoServico.setComponentesValorPrestacao(Collections.singletonList(FabricaDeObjetosFake.getComponenteValorPrestacao()));
        cteValorPrestacaoServico.setValorReceber(new BigDecimal("100"));
        cteValorPrestacaoServico.setValorTotalPrestacaoServico(new BigDecimal("100"));
        return cteValorPrestacaoServico;
    }

    public static CTeNotaInfoValorPrestacaoServicoComponentesValorPrestacao getComponenteValorPrestacao() {
        final CTeNotaInfoValorPrestacaoServicoComponentesValorPrestacao cteNComponentesValorPrestacao = new CTeNotaInfoValorPrestacaoServicoComponentesValorPrestacao();
        cteNComponentesValorPrestacao.setNomeComponente("FRETE");
        cteNComponentesValorPrestacao.setValorComponente(new BigDecimal("100"));
        return cteNComponentesValorPrestacao;
    }

    public static CTeNotaInfoEmitente getInfoEmitente() {
        final CTeNotaInfoEmitente infoEmitente = new CTeNotaInfoEmitente();
        infoEmitente.setCnpj("00000000000011");
        infoEmitente.setEnderEmit(FabricaDeObjetosFake.getEnderecoEmitente());
        infoEmitente.setInscricaoEstadual("1234567890");
        infoEmitente.setInscricaoEstadualST("1234567890");
        infoEmitente.setNomeFantasia("FANTASIA EMITENTE");
        infoEmitente.setRazaoSocial("RAZAO SOCIAL EMITENTE");
        return infoEmitente;
    }

    public static CTeNotaInfoCTeNormal getInfoCTeNormal() {
        final CTeNotaInfoCTeNormal cteInfoNormal = new CTeNotaInfoCTeNormal();
        cteInfoNormal.setCobranca(FabricaDeObjetosFake.getInfoCTeNormalCobranca());
        cteInfoNormal.setInfoCarga(FabricaDeObjetosFake.getInfoCarga());
        cteInfoNormal.setInfoDocumentos(FabricaDeObjetosFake.getInfoDocumentos());
        cteInfoNormal.setInfoModal(FabricaDeObjetosFake.getInfoModal());
        return cteInfoNormal;
    }

    public static CTeNotaInfoCTeNormalInfoModal getInfoModal() {
        final CTeNotaInfoCTeNormalInfoModal cteInfoModal = new CTeNotaInfoCTeNormalInfoModal();
        cteInfoModal.setVersao("3.0");
        cteInfoModal.setRodoviario(FabricaDeObjetosFake.getInfoModalRodoviario());
        return cteInfoModal;
    }

    public static CTeNotaInfoCTeNormalInfoModalRodoviario getInfoModalRodoviario() {
        final CTeNotaInfoCTeNormalInfoModalRodoviario cteInfoModalRodoviario = new CTeNotaInfoCTeNormalInfoModalRodoviario();
        cteInfoModalRodoviario.setOrdemColetaAssociadas(Collections.singletonList(FabricaDeObjetosFake.getInfoModalRodoviarioOrdemColetaAssociadas()));
        cteInfoModalRodoviario.setRntrc("12345678");
        return cteInfoModalRodoviario;
    }

    public static CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas getInfoModalRodoviarioOrdemColetaAssociadas() {
        final CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas cteInfoModalRodoviarioOrdemColetaAssociadas = new CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadas();
        cteInfoModalRodoviarioOrdemColetaAssociadas.setDataEmissao(FabricaDeObjetosFake.getLocalDate());
        cteInfoModalRodoviarioOrdemColetaAssociadas.setNumeroOrdemColeta("125");
        cteInfoModalRodoviarioOrdemColetaAssociadas.setOrdemColetaAssociadasEmi(FabricaDeObjetosFake.getInfoModalRodoviarioOrdemCOletaAssociadasEmi());
        return cteInfoModalRodoviarioOrdemColetaAssociadas;
    }

    private static CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi getInfoModalRodoviarioOrdemCOletaAssociadasEmi() {
        final CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi emi = new CTeNotaInfoCTeNormalInfoModalRodoviarioOrdemColetaAssociadasEmi();
        emi.setCnpj("00000000000000");
        emi.setCodigoInterno("1754");
        emi.setInscricaoEstadual("ISENTO");
        emi.setSiglaUF("SC");
        emi.setTelefone("4832000000");
        return emi;
    }

    public static CTeNotaInfoCTeNormalInfoDocumentos getInfoDocumentos() {
        final CTeNotaInfoCTeNormalInfoDocumentos cteInfoDocumentos = new CTeNotaInfoCTeNormalInfoDocumentos();
        cteInfoDocumentos.setInfoNFe(Collections.singletonList(FabricaDeObjetosFake.getInfoNFe()));
        return cteInfoDocumentos;
    }

    public static CTeNotaInfoCTeNormalInfoDocumentosInfoNFe getInfoNFe() {
        final CTeNotaInfoCTeNormalInfoDocumentosInfoNFe cteInfoNFe = new CTeNotaInfoCTeNormalInfoDocumentosInfoNFe();
        cteInfoNFe.setChave("12345678901234567890123456789012345678901234");
        cteInfoNFe.setDataPrevistaEntrega(FabricaDeObjetosFake.getLocalDate());
        cteInfoNFe.setInfoUnidCarga(Collections.singletonList(FabricaDeObjetosFake.getInfoUnidadeCarga()));
        return cteInfoNFe;
    }

    public static CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga getInfoUnidadeCarga() {
        final CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga cteInfoUnidadeCarga = new CTeNotaInfoCTeNormalInfoDocumentosInfoUnidadeCarga();
        cteInfoUnidadeCarga.setIdentificacaoCarga("IDE");
        cteInfoUnidadeCarga.setQuantidadeRateada(BigDecimal.ONE);
        cteInfoUnidadeCarga.setUnidadeCarga(CTTipoUnidadeCarga.PALLET);
        return cteInfoUnidadeCarga;
    }

    public static CTeNotaInfoCTeNormalInfoCarga getInfoCarga() {
        final CTeNotaInfoCTeNormalInfoCarga infoCarga = new CTeNotaInfoCTeNormalInfoCarga();
        infoCarga.setDescricaoOutrasCaracteristicas("Carga pesada");
        infoCarga.setDescricaoProdutoPredominante("Ferro");
        infoCarga.setInformacoesQuantidadeCarga(Collections.singletonList(FabricaDeObjetosFake.getInfoCargaInfoQuantidadeCarga()));
        infoCarga.setValorAverbacao(new BigDecimal("100000"));
        infoCarga.setValorTotalCarga(new BigDecimal("100000"));
        return infoCarga;
    }

    public static CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga getInfoCargaInfoQuantidadeCarga() {
        final CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga quantidadeCarga = new CTeNotaInfoCTeNormalInfoCargaInformacoesQuantidadeCarga();
        quantidadeCarga.setQuantidade(BigDecimal.ONE);
        quantidadeCarga.setUnidadeMedida(CTUnidadeMedida.M3);
        quantidadeCarga.setTipoMedia("METRO CUBICO");
        return quantidadeCarga;
    }

    public static CTeNotaInfoCTeNormalCobranca getInfoCTeNormalCobranca() {
        final CTeNotaInfoCTeNormalCobranca cobranca = new CTeNotaInfoCTeNormalCobranca();
        cobranca.setDuplicata(Collections.singletonList(FabricaDeObjetosFake.getCTeNormalCobrancaDuplicata()));
        cobranca.setFatura(FabricaDeObjetosFake.getCTeNormalCobrancaFatura());
        return cobranca;
    }

    public static CTeNotaInfoCTeNormalCobrancaFatura getCTeNormalCobrancaFatura() {
        final CTeNotaInfoCTeNormalCobrancaFatura fatura = new CTeNotaInfoCTeNormalCobrancaFatura();
        fatura.setNumero("1");
        fatura.setValorDesconto(BigDecimal.ZERO);
        fatura.setValorOriginal(new BigDecimal("100"));
        fatura.setValorLiquido(new BigDecimal("100"));
        return fatura;
    }

    public static CTeNotaInfoCTeNormalCobrancaDuplicata getCTeNormalCobrancaDuplicata() {
        final CTeNotaInfoCTeNormalCobrancaDuplicata duplicata = new CTeNotaInfoCTeNormalCobrancaDuplicata();
        duplicata.setDataVencimento(FabricaDeObjetosFake.getLocalDate());
        duplicata.setNumero("1");
        duplicata.setValor(new BigDecimal("100"));
        return duplicata;
    }

    public static CTeNotaInfoDadosComplementares getInfoDadosComplementares() {
        final CTeNotaInfoDadosComplementares dadosComplementares = new CTeNotaInfoDadosComplementares();
        dadosComplementares.setCaracteristicasTransporte("ENTREGA");
        dadosComplementares.setCaracteristicasServico("ENTREGA");
        dadosComplementares.setFuncionarioEmissor("Joao da Silva");
        dadosComplementares.setFluxo(FabricaDeObjetosFake.getFluxo());
        dadosComplementares.setEntrega(FabricaDeObjetosFake.getEntrega());
        dadosComplementares.setMunicipioOrigem("Floriano");
        dadosComplementares.setMunicipioDestino("Floriano");
        dadosComplementares.setObservacaoGeral("Observacao geral");
        return dadosComplementares;
    }

    public static CTeNotaInfoDadosComplementaresObservacaoContribuinte getObservacaoContribuinte() {
        final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacaoContribuinte = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
        observacaoContribuinte.setCampo("Observacao geral");
        observacaoContribuinte.setTexto("Texto de informacoes do contribuinte");
        return observacaoContribuinte;
    }

    public static CTeNotaInfoDadosComplementaresEntrega getEntrega() {
        final CTeNotaInfoDadosComplementaresEntrega entrega = new CTeNotaInfoDadosComplementaresEntrega();
        entrega.setEntregaComDataDefinida(FabricaDeObjetosFake.getEntregaComDataDefinida());
        return entrega;
    }

    public static CTeNotaInfoDadosComplementaresEntregaComDataDefinida getEntregaComDataDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaComDataDefinida entregaComDataDefinida = new CTeNotaInfoDadosComplementaresEntregaComDataDefinida();
        entregaComDataDefinida.setDataProgramada(FabricaDeObjetosFake.getLocalDate());
        entregaComDataDefinida.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.NA_DATA);
        return entregaComDataDefinida;
    }

    public static CTeNotaInfoDadosComplementaresEntregaComHoraDefinida getEntregaComHoraDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaComHoraDefinida entregaComHoraDefinida = new CTeNotaInfoDadosComplementaresEntregaComHoraDefinida();
        entregaComHoraDefinida.setHoraProgramada(FabricaDeObjetosFake.getLocalTime());
        entregaComHoraDefinida.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.NO_HORARIO);
        return entregaComHoraDefinida;
    }

    public static CTeNotaInfoDadosComplementaresEntregaIntervalo getEntregaIntervalo() {
        final CTeNotaInfoDadosComplementaresEntregaIntervalo entregaIntervalo = new CTeNotaInfoDadosComplementaresEntregaIntervalo();
        entregaIntervalo.setHoraInicio(FabricaDeObjetosFake.getLocalTime());
        entregaIntervalo.setHoraFim(FabricaDeObjetosFake.getLocalTime());
        entregaIntervalo.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.NO_INTERVALO_DE_TEMPO);
        return entregaIntervalo;
    }

    public static CTeNotaInfoDadosComplementaresEntregaSemDataDefinida getEntregaSemDataDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaSemDataDefinida entregaSemDataDefinida = new CTeNotaInfoDadosComplementaresEntregaSemDataDefinida();
        entregaSemDataDefinida.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.SEM_DATA_DEFINIDA);
        return entregaSemDataDefinida;
    }

    public static CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida getEntregaSemHoraDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida entregaSemHoraDefinida = new CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida();
        entregaSemHoraDefinida.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.SEM_HORA_DEFINIDA);
        return entregaSemHoraDefinida;
    }

    public static CTeNotaInfoDadosComplementaresEntregaPeriodo getEntregaPeriodo() {
        final CTeNotaInfoDadosComplementaresEntregaPeriodo entregaPeriodo = new CTeNotaInfoDadosComplementaresEntregaPeriodo();
        entregaPeriodo.setDataInicio(FabricaDeObjetosFake.getLocalDate());
        entregaPeriodo.setDataFim(FabricaDeObjetosFake.getLocalDate());
        entregaPeriodo.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.NO_PERIODO);
        return entregaPeriodo;
    }

    public static CTeNotaInfoDadosComplementaresFluxo getFluxo() {
        final CTeNotaInfoDadosComplementaresFluxo fluxo = new CTeNotaInfoDadosComplementaresFluxo();
        fluxo.setOrigem("Floriano");
        fluxo.setPass(Collections.singletonList(FabricaDeObjetosFake.getFluxoPass()));
        fluxo.setDestino("Floriano");
        fluxo.setRota("Floriano");
        return fluxo;
    }

    public static CTeNotaInfoDadosComplementaresFluxoPass getFluxoPass() {
        final CTeNotaInfoDadosComplementaresFluxoPass fluxoPass = new CTeNotaInfoDadosComplementaresFluxoPass();
        fluxoPass.setPass("IATA");
        return fluxoPass;
    }

    public static CTeNotaInfoIdentificacao getInfoIdentificador() {
        final CTeNotaInfoIdentificacao identificacao = new CTeNotaInfoIdentificacao();
        identificacao.setCodigoUF(DFUnidadeFederativa.SC);
        identificacao.setCodigoNumerico("67890123");
        identificacao.setCfop("5353");
        identificacao.setNaturezaOperacao("Prestacao de servico de transporte");
        identificacao.setModelo(DFModelo.CTE);
        identificacao.setSerie(1);
        identificacao.setNumero(123);
        identificacao.setDataEmissao(ZonedDateTime.of(2018, 1, 22, 10, 10, 10, 0, DFConfig.TIMEZONE_SP.toZoneId()));
        identificacao.setTipoImpressao(CTTipoImpressao.RETRATO);
        identificacao.setTipoEmissao(CTTipoEmissao.EMISSAO_NORMAL);
        identificacao.setDigitoVerificador(4);
        identificacao.setAmbiente(DFAmbiente.HOMOLOGACAO);
        identificacao.setFinalidade(CTFinalidade.NORMAL);
        identificacao.setProcessoEmissao(CTProcessoEmissao.EMISSOR_CONTRIBUINTE);
        identificacao.setVersaoProcessoEmissao("1.00");
        identificacao.setIndicadorGlobalizado(1);
        identificacao.setCodigoMunicipioEnvio("4205407");
        identificacao.setDescricaoMunicipioEnvio("Floriano");
        identificacao.setSiglaUFEnvio("SC");
        identificacao.setModalidadeFrete(CTModal.RODOVIARIO);
        identificacao.setTipoServico(CTTipoServico.NORMAL);
        identificacao.setCodigoMunicipioInicio("4205407");
        identificacao.setDescricaoMunicipioInicio("Floriano");
        identificacao.setSiglaUfInicio("SC");
        identificacao.setCodigoMunicipioFim("4205407");
        identificacao.setDescricaoMunicipioFim("Floriano");
        identificacao.setSiglaUfFim("SC");
        identificacao.setRetira(CTRetirada.NAO);
        identificacao.setDetalheRetira("Nao retira");
        identificacao.setIndIEToma(CTIndicadorTomador.NAO_CONTRIBUINTE);
        identificacao.setTomadorServico3(FabricaDeObjetosFake.getTomadorServico3());
        identificacao.setDataContingencia(null);
        identificacao.setJustificativa(null);
        return identificacao;
    }

    public static CTeNotaInfoIdentificacaoTomadorServico3 getTomadorServico3() {
        final CTeNotaInfoIdentificacaoTomadorServico3 tomador3 = new CTeNotaInfoIdentificacaoTomadorServico3();
        tomador3.setTomadorServico(CTTomadorServico.RECEBEDOR);
        return tomador3;
    }

    public static CTeNotaInfoIdentificacaoTomadorServico4 getTomadorServico4() {
        final CTeNotaInfoIdentificacaoTomadorServico4 tomador4 = new CTeNotaInfoIdentificacaoTomadorServico4();
        tomador4.setCnpj("12345678901234");
        tomador4.setCpf("00000000000");
        tomador4.setInscricaoEstadual("ISENTO");
        tomador4.setRazaoSocial("RAZAO SOCIAL TOMADOR");
        tomador4.setNomeFantasia("NOME FANTASIA");
        tomador4.setTelefone("4830000000");
        tomador4.setEnderTomadorServico(FabricaDeObjetosFake.getEndereco());
        tomador4.setEmail("teste@teste.com.br");
        return tomador4;
    }

    public static CTeNotaEndereco getEndereco() {
        final CTeNotaEndereco endereco = new CTeNotaEndereco();
        endereco.setLogradouro("RUA ANITA GARIBALDI");
        endereco.setNumero("1");
        endereco.setComplemento("SALA 1");
        endereco.setBairro("CENTRO");
        endereco.setCodigoMunicipio("4205407");
        endereco.setDescricaoMunicipio("Floriano");
        endereco.setCep("88010500");
        endereco.setSiglaUF("SC");
        endereco.setCodigoPais("1058");
        endereco.setDescricaoPais("BRASIL");
        return endereco;
    }

    public static CTeNotaEnderecoEmitente getEnderecoEmitente() {
        final CTeNotaEnderecoEmitente endereco = new CTeNotaEnderecoEmitente();
        endereco.setLogradouro("RUA ANITA GARIBALDI");
        endereco.setNumero("1");
        endereco.setComplemento("SALA 1");
        endereco.setBairro("CENTRO");
        endereco.setCodigoMunicipio("4205407");
        endereco.setDescricaoMunicipio("Floriano");
        endereco.setCep("88010500");
        endereco.setSiglaUF("SC");
        endereco.setTelefone("4832000000");
        return endereco;
    }
    
    public static LocalDate getLocalDate() {
        return LocalDate.of(2018, 1, 22);
    }

    public static LocalTime getLocalTime() {
        return LocalTime.of(10, 10, 10);
    }
}

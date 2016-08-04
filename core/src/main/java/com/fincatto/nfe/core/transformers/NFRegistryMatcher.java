package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.*;
import com.fincatto.nfe.core.cadastro.NFIndicadorContribuinteCTe;
import com.fincatto.nfe.core.cadastro.NFIndicadorContribuinteNFe;
import com.fincatto.nfe.core.cadastro.NFSituacaoContribuinte;
import com.fincatto.nfe.core.lote.envio.NFLoteIndicadorProcessamento;
import com.fincatto.nfe.core.nota.*;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.simpleframework.xml.transform.RegistryMatcher;

public class NFRegistryMatcher extends RegistryMatcher {

    public NFRegistryMatcher() {
        super.bind(NFTipo.class, new NFTipoTransformer());
        super.bind(NFModelo.class, new NFModeloTransformer());
        super.bind(NFOrigem.class, new NFOrigemTransformer());
        super.bind(NFAmbiente.class, new NFAmbienteTransformer());
        super.bind(LocalDate.class, new NFLocalDateTransformer());
        super.bind(LocalTime.class, new NFLocalTimeTransformer());
        super.bind(NFFinalidade.class, new NFFinalidadeTransformer());
        super.bind(NFTipoEmissao.class, new NFTipoEmissaoTransformer());
        super.bind(DateTime.class, new NFDateTimeTransformer());
        super.bind(LocalDateTime.class, new NFLocalDateTimeTransformer());
        super.bind(NFTipoImpressao.class, new NFTipoImpressaoTransformer());
        super.bind(NFOrigemProcesso.class, new NFOrigemProcessoTransformer());
        super.bind(NFOperadoraCartao.class, new NFOperadoraCartaoTransformer());
        super.bind(NFProcessoEmissor.class, new NFProgramaEmissorTransformer());
        super.bind(NFModalidadeFrete.class, new NFModalidadeFreteTransformer());
        super.bind(NFRegimeTributario.class, new NFRegimeTributarioTransformer());
        super.bind(NFFormaPagamentoPrazo.class, new NFFormaPagamentoTransformer());
        super.bind(NFUnidadeFederativa.class, new NFUnidadeFederativaTransformer());
        super.bind(NFNotaInfoVeiculoCor.class, new NFNotaInfoVeiculoCorTransformer());
        super.bind(NFFormaPagamentoMoeda.class, new NFFormaPagamentoMoedaTransformer());
        super.bind(NFNotaInfoTipoVeiculo.class, new NFNotaInfoTipoVeiculoTransformer());
        super.bind(NFSituacaoContribuinte.class, new NFSituacaoContribuinteTransformer());
        super.bind(NFNotaInfoEspecieVeiculo.class, new NFNotaInfoEspecieVeiculoTransformer());
        super.bind(NFProdutoCompoeValorNota.class, new NFProdutoCompoeValorNotaTransformer());
        super.bind(NFTipoIntegracaoPagamento.class, new NFTipoIntegracaoPagamentoTransformer());
        super.bind(NFIndicadorIEDestinatario.class, new NFIndicadorIEDestinatarioTransformer());
        super.bind(NFOperacaoConsumidorFinal.class, new NFOperacaoConsumidorFinalTransformer());
        super.bind(NFNotaInfoCombustivelTipo.class, new NFNotaInfoCombustivelTipoTransformer());
        super.bind(NFIndicadorContribuinteCTe.class, new NFIndicadorContribuinteCTTransformer());
        super.bind(NFIndicadorContribuinteNFe.class, new NFIndicadorContribuinteNFeTransformer());
        super.bind(NFNotaMotivoDesoneracaoICMS.class, new NFNotaMotivoDesoneracaoICMSTransformer());
        super.bind(NFLoteIndicadorProcessamento.class, new NFLoteIndicadorProcessamentoTransformer());
        super.bind(NFViaTransporteInternacional.class, new NFViaTransporteInternacionalTransformer());
        super.bind(NFIndicadorPresencaComprador.class, new NFIndicadorPresencaCompradorTransformer());
        super.bind(NFFormaImportacaoIntermediacao.class, new NFFormaImportacaoIntermediacaoTransformer());
        super.bind(NFNotaInfoImpostoTributacaoICMS.class, new NFNotaInfoImpostoTributacaoICMSTransformer());
        super.bind(NFNotaInfoSituacaoTributariaIPI.class, new NFNotaInfoSituacaoTributariaIPITransformer());
        super.bind(NFNotaInfoSituacaoTributariaPIS.class, new NFNotaInfoSituacaoTributariaPISTransformer());
        super.bind(NFNotaInfoItemModalidadeBCICMSST.class, new NFnotaInfoItemModalidadeBCICMSSTTransformer());
        super.bind(NFNotaInfoRegimeEspecialTributacao.class, new NFNotaInfoRegimeEspecialTributacaoTransformer());
        super.bind(NFNotaInfoSituacaoTributariaCOFINS.class, new NFNotaInfoSituacaoTributariaCOFINSTransformer());
        super.bind(NFNotaInfoItemProdutoArmamentoTipo.class, new NFNotaInfoItemProdutoArmamentoTipoTransformer());
        super.bind(NFIdentificadorLocalDestinoOperacao.class, new NFIdentificadorLocalDestinoOperacaoTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoCondicao.class, new NFNotaInfoItemProdutoVeiculoCondicaoTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoRestricao.class, new NFNotaInfoItemProdutoVeiculoRestricaoTransformer());
        super.bind(NFNotaInfoItemIndicadorIncentivoFiscal.class, new NFNotaInfoItemIndicadorIncentivoFiscalTransformer());
        super.bind(NFNotaInfoItemIndicadorExigibilidadeISS.class, new NFNotaInfoItemIndicadorExigibilidadeISSTransformer());
        super.bind(NFNotaSituacaoOperacionalSimplesNacional.class, new NFNotaSituacaoOperacionalSimplesNacionalTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoTipoOperacao.class, new NFNotaInfoItemProdutoVeiculoTipoOperacaoTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoCondicaoChassi.class, new NFNotaInfoItemProdutoVeiculoCondicaoChassiTransformer());
        super.bind(NFNotaInfoItemModalidadeBCICMS.class, new NFNotaInfoItemModalidadeBCICMSTransformer());
    }
}
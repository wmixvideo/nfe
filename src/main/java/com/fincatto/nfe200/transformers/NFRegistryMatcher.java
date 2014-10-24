package com.fincatto.nfe200.transformers;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.simpleframework.xml.transform.RegistryMatcher;

import com.fincatto.nfe200.classes.NFAmbiente;
import com.fincatto.nfe200.classes.NFFinalidade;
import com.fincatto.nfe200.classes.NFFormaPagamento;
import com.fincatto.nfe200.classes.NFModalidadeFrete;
import com.fincatto.nfe200.classes.NFNotaInfoCombustivelTipo;
import com.fincatto.nfe200.classes.NFNotaInfoEspecieVeiculo;
import com.fincatto.nfe200.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.nfe200.classes.NFNotaInfoItemImpostoICMSModalidadeBaseCalulo;
import com.fincatto.nfe200.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.nfe200.classes.NFNotaInfoItemProdutoArmamentoTipo;
import com.fincatto.nfe200.classes.NFNotaInfoItemProdutoVeiculoCondicao;
import com.fincatto.nfe200.classes.NFNotaInfoItemProdutoVeiculoCondicaoChassi;
import com.fincatto.nfe200.classes.NFNotaInfoItemProdutoVeiculoRestricao;
import com.fincatto.nfe200.classes.NFNotaInfoItemProdutoVeiculoTipoOperacao;
import com.fincatto.nfe200.classes.NFNotaInfoSituacaoTributariaCOFINS;
import com.fincatto.nfe200.classes.NFNotaInfoSituacaoTributariaIPI;
import com.fincatto.nfe200.classes.NFNotaInfoSituacaoTributariaPIS;
import com.fincatto.nfe200.classes.NFNotaInfoTipoVeiculo;
import com.fincatto.nfe200.classes.NFNotaInfoVeiculoCor;
import com.fincatto.nfe200.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.nfe200.classes.NFOrigem;
import com.fincatto.nfe200.classes.NFOrigemProcesso;
import com.fincatto.nfe200.classes.NFProcessoEmissor;
import com.fincatto.nfe200.classes.NFProdutoCompoeValorNota;
import com.fincatto.nfe200.classes.NFRegimeTributario;
import com.fincatto.nfe200.classes.NFTipo;
import com.fincatto.nfe200.classes.NFTipoEmissao;
import com.fincatto.nfe200.classes.NFTipoImpressao;
import com.fincatto.nfe200.classes.NFUnidadeFederativa;

public class NFRegistryMatcher extends RegistryMatcher {

    public NFRegistryMatcher() {
        super.bind(NFTipo.class, new NFTipoTransformer());
        super.bind(NFOrigem.class, new NFOrigemTransformer());
        super.bind(NFAmbiente.class, new NFAmbienteTransformer());
        super.bind(LocalDate.class, new NFLocalDateTransformer());
        super.bind(LocalTime.class, new NFLocalTimeTransformer());
        super.bind(NFFinalidade.class, new NFFinalidadeTransformer());
        super.bind(NFTipoEmissao.class, new NFTipoEmissaoTransformer());
        super.bind(LocalDateTime.class, new NFLocalDateTimeTransformer());
        super.bind(NFTipoImpressao.class, new NFTipoImpressaoTransformer());
        super.bind(NFFormaPagamento.class, new NFFormaPagamentoTransformer());
        super.bind(NFOrigemProcesso.class, new NFOrigemProcessoTransformer());
        super.bind(NFProcessoEmissor.class, new NFProgramaEmissorTransformer());
        super.bind(NFModalidadeFrete.class, new NFModalidadeFreteTransformer());
        super.bind(NFRegimeTributario.class, new NFRegimeTributarioTransformer());
        super.bind(NFUnidadeFederativa.class, new NFUnidadeFederativaTransformer());
        super.bind(NFNotaInfoVeiculoCor.class, new NFNotaInfoVeiculoCorTransformer());
        super.bind(NFNotaInfoTipoVeiculo.class, new NFNotaInfoTipoVeiculoTransformer());
        super.bind(NFNotaInfoEspecieVeiculo.class, new NFNotaInfoEspecieVeiculoTransformer());
        super.bind(NFProdutoCompoeValorNota.class, new NFProdutoCompoeValorNotaTransformer());
        super.bind(NFNotaInfoCombustivelTipo.class, new NFNotaInfoCombustivelTipoTransformer());
        super.bind(NFNotaInfoImpostoTributacaoICMS.class, new NFNotaInfoImpostoTributacaoICMSTransformer());
        super.bind(NFNotaInfoSituacaoTributariaIPI.class, new NFNotaInfoSituacaoTributariaIPITransformer());
        super.bind(NFNotaInfoSituacaoTributariaPIS.class, new NFNotaInfoSituacaoTributariaPISTransformer());
        super.bind(NFNotaInfoItemModalidadeBCICMSST.class, new NFnotaInfoItemModalidadeBCICMSSTTransformer());
        super.bind(NFNotaInfoSituacaoTributariaCOFINS.class, new NFNotaInfoSituacaoTributariaCOFINSTransformer());
        super.bind(NFNotaInfoItemProdutoArmamentoTipo.class, new NFNotaInfoItemProdutoArmamentoTipoTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoCondicao.class, new NFNotaInfoItemProdutoVeiculoCondicaoTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoRestricao.class, new NFNotaInfoItemProdutoVeiculoRestricaoTransformer());
        super.bind(NFNotaSituacaoOperacionalSimplesNacional.class, new NFNotaSituacaoOperacionalSimplesNacionalTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoTipoOperacao.class, new NFNotaInfoItemProdutoVeiculoTipoOperacaoTransformer());
        super.bind(NFNotaInfoItemProdutoVeiculoCondicaoChassi.class, new NFNotaInfoItemProdutoVeiculoCondicaoChassiTransformer());
        super.bind(NFNotaInfoItemImpostoICMSModalidadeBaseCalulo.class, new NFNotaInfoItemImpostoICMSModalidadeBaseCaluloTransformer());
    }
}
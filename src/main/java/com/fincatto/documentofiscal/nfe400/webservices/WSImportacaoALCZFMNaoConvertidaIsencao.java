package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.alczfmimportacao.imobilizacao.NFDetEventoImportacaoALCZFMNaoConvertidaIsencao;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.alczfmimportacao.imobilizacao.NFDetGrupoConsumoZFM;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;

import java.math.BigDecimal;
import java.util.List;


/**
 * Classe responsável por informar a importação de ALC/ZFM não convertida em isenção
 * Classe utiliza de herança de {@link AbstractWSEvento} para reaproveitar código comum a todos os eventos.
 * A classe {@link NFDetEventoSolicitacaoApropriacaoCreditoPresumido} é utilizada para representar os dados específicos do evento (detEvento).
 *
 * @author Marcos Della Justina Schulz
 */
class WSImportacaoALCZFMNaoConvertidaIsencao extends AbstractWSEvento implements DFLog {
    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Importa\u00E7\u00E3o em ALC/ZFM n\u00E3o convertida em isen\u00E7\u00E3o";
    private static final String CODIGO_EVENTO = "211130";

    private List<NFDetGrupoConsumoZFM> gruposImobilizacao;

    @Override
    protected BigDecimal getVersaoLayout() {
        return VERSAO_LAYOUT;
    }

    @Override
    protected String getCodigoEvento() {
        return CODIGO_EVENTO;
    }

    @Override
    protected String getDescricaoEvento() {
        return DESCRICAO_EVENTO;
    }

    @Override
    protected String getChaveAcesso() {
        return this.chaveAcesso;
    }

    /**
     * Construtor da classe {@link WSInfoEfetPagIntegral}.
     *
     * @param config Configuração da NF-e utilizada para a comunicação com o web service.
     */
    WSImportacaoALCZFMNaoConvertidaIsencao(NFeConfig config) {
        super(config);
    }

    /**
     * Adiciona os dados necessários para a geração do XML do evento de importação de ALC/ZFM não convertida em isenção.
     *
     * @param chaveAcesso            Chave de acesso da NF-e relacionada ao evento.
     * @param gruposConsumo Lista de grupos do crédito presumido.
     * @param numeroSequencialEvento Número sequencial do evento.
     * @return A própria instância de {@link WSImportacaoALCZFMNaoConvertidaIsencao} para permitir encadeamento de chamadas.
     */
    WSImportacaoALCZFMNaoConvertidaIsencao adicionarDadosEvento(
            final String chaveAcesso, DFUnidadeFederativa ufEmitenteEvento, final List<NFDetGrupoConsumoZFM> gruposConsumo,
            final int numeroSequencialEvento
    ) {
        super.chaveAcesso = chaveAcesso;
        this.gruposImobilizacao = gruposConsumo;
        super.numeroSequencialEvento = numeroSequencialEvento;
        super.ufAutorEvento = ufEmitenteEvento;
        return this;
    }

    /**
     * Gera os dados XML específicos do evento de solicitação de apropriação de crédito presumido.
     * @return {@link NFEnviaEvento} com os dados do evento preenchidos
     */
    @Override
    protected NFEnviaEvento gerarDadosXml() {
        final NFDetEventoImportacaoALCZFMNaoConvertidaIsencao detEvento = new NFDetEventoImportacaoALCZFMNaoConvertidaIsencao();
        detEvento.setDescricaoEvento(WSImportacaoALCZFMNaoConvertidaIsencao.DESCRICAO_EVENTO);
        detEvento.setVersao(WSImportacaoALCZFMNaoConvertidaIsencao.VERSAO_LAYOUT);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_EMITENTE);
        detEvento.setVersaoAplicativo(WSImportacaoALCZFMNaoConvertidaIsencao.VERSAO_LAYOUT.toString());
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setGruposConsumo(this.gruposImobilizacao);

        return super.gerarDadosPaiXml(detEvento);
    }
}

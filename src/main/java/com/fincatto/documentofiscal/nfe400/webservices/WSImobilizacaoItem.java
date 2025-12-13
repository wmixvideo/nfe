package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.DFLog;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFeConfig;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEnviaEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoTipoAutor;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.apropriacaocredito.NFDetEventoSolicitacaoApropriacaoCreditoPresumido;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.imobilizacao.NFDetEventoImobilizacaoItem;
import com.fincatto.documentofiscal.nfe400.classes.evento.detevento.imobilizacao.NFDetGrupoImobilizacao;

import java.math.BigDecimal;
import java.util.List;


/**
 * Classe responsável por informar a imobilização de itens
 * Classe utiliza de herança de {@link AbstractWSEvento} para reaproveitar código comum a todos os eventos.
 * A classe {@link NFDetEventoSolicitacaoApropriacaoCreditoPresumido} é utilizada para representar os dados específicos do evento (detEvento).
 *
 * @author Marcos Della Justina Schulz
 */
class WSImobilizacaoItem extends AbstractWSEvento implements DFLog {
    private static final BigDecimal VERSAO_LAYOUT = new BigDecimal("1.00");
    private static final String DESCRICAO_EVENTO = "Imobiliza\u00E7\u00E3o de Item";
    private static final String CODIGO_EVENTO = "211130";

    private List<NFDetGrupoImobilizacao> gruposImobilizacao;

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
    WSImobilizacaoItem(NFeConfig config) {
        super(config);
    }

    /**
     * Adiciona os dados necessários para a geração do XML do evento de imobilização de item.
     *
     * @param chaveAcesso            Chave de acesso da NF-e relacionada ao evento.
     * @param gruposImobilizacao Lista de grupos do crédito presumido.
     * @param numeroSequencialEvento Número sequencial do evento.
     * @return A própria instância de {@link WSImobilizacaoItem} para permitir encadeamento de chamadas.
     */
    WSImobilizacaoItem adicionarDadosEvento(
            final String chaveAcesso, DFUnidadeFederativa ufEmitenteEvento, final List<NFDetGrupoImobilizacao> gruposImobilizacao,
            final int numeroSequencialEvento
    ) {
        super.chaveAcesso = chaveAcesso;
        this.gruposImobilizacao = gruposImobilizacao;
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
        final NFDetEventoImobilizacaoItem detEvento = new NFDetEventoImobilizacaoItem();
        detEvento.setDescricaoEvento(WSImobilizacaoItem.DESCRICAO_EVENTO);
        detEvento.setVersao(WSImobilizacaoItem.VERSAO_LAYOUT);
        detEvento.setTipoAutor(NFEventoTipoAutor.EMPRESA_DESTINADA);
        detEvento.setVersaoAplicativo(WSImobilizacaoItem.VERSAO_LAYOUT.toString());
        detEvento.setUfAutorEvento(super.ufAutorEvento);
        detEvento.setGruposImobilizacao(this.gruposImobilizacao);

        return super.gerarDadosPaiXml(detEvento);
    }
}
